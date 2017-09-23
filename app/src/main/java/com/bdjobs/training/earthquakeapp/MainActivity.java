package com.bdjobs.training.earthquakeapp;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.widget.ListAdapter;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainAcitivity";
    String mainUrl = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson";
    //String dateUrl = "&starttime=2014-01-01&endtime=2014-01-02";
    //String baseUrl = mainUrl + dateUrl;
    static String counter = null;
    Calendar startmyCalendar = Calendar.getInstance();
    Calendar endmyCalendar = Calendar.getInstance();


    ArrayList<FeaturesData> featuresDataArrayList = new ArrayList<>();
    ListView earthQuakeLV;
    ProgressDialog progressDialog;
    EditText startET, endET;
    TextView counterTV;
    Button okBT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // findviewbyID();
        initializer();


        Cache cache = MySingleton.getInstance(this).getRequestQueue().getCache();
        onClickListeners();
//        if (cache == null ) {
//            onClickListeners();
//        } else {
//            MySingleton.getInstance(this).getRequestQueue().getCache().clear();
//            onClickListeners();
//            //   getEarthquakeData(startDate, endDate);
//        }


        startDatePicker();
        endDatePicker();


        Log.d(TAG, "came here");
    }

    private void endDatePicker() {
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                endmyCalendar.set(Calendar.YEAR, year);
                endmyCalendar.set(Calendar.MONTH, monthOfYear);
                endmyCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelend();
            }


        };
        endET.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, endmyCalendar
                        .get(Calendar.YEAR), endmyCalendar.get(Calendar.MONTH),
                        endmyCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabelend() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        endET.setText(sdf.format(endmyCalendar.getTime()));
    }

    private void startDatePicker() {
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                startmyCalendar.set(Calendar.YEAR, year);
                startmyCalendar.set(Calendar.MONTH, monthOfYear);
                startmyCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelstart();
            }


        };
        startET.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, startmyCalendar
                        .get(Calendar.YEAR), startmyCalendar.get(Calendar.MONTH),
                        startmyCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabelstart() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        startET.setText(sdf.format(startmyCalendar.getTime()));
    }

//    private void findviewbyID() {
//        earthQuakeLV = (ListView) findViewById(R.id.earthQuakeLV);
//        startET = (EditText) findViewById(R.id.startET);
//          endET = (EditText) findViewById(R.id.endET);
//        counterTV = (TextView) findViewById(R.id.counterTV);
//        okBT = (Button) findViewById(R.id.okBT);
//    }

    private void initializer() {


        earthQuakeLV = (ListView) findViewById(R.id.earthQuakeLV);
        startET = (EditText) findViewById(R.id.startET);
        endET = (EditText) findViewById(R.id.endET);
        counterTV = (TextView) findViewById(R.id.counterTV);
        okBT = (Button) findViewById(R.id.okBT);


    }

    private void onClickListeners() {
        okBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startDate = startET.getText().toString();
                String endDate = endET.getText().toString();
                featuresDataArrayList.clear();

                //Toast.makeText(MainActivity.this, startDate, Toast.LENGTH_SHORT).show();
                if (startDate == null || startDate.isEmpty() || startDate.equalsIgnoreCase(null)) {
                    Toast.makeText(MainActivity.this, "Startdate can not be empty!", Toast.LENGTH_SHORT).show();

                } else if (endDate == null || endDate.isEmpty() || endDate.equalsIgnoreCase(null)) {
                    Toast.makeText(MainActivity.this, "Enddate can not be empty!", Toast.LENGTH_SHORT).show();

                } else {

                    // earthQuakeLV.getAdapter().notifyAll();
                    getEarthquakeData(startDate, endDate);
                }

            }
        });

    }


    public void getEarthquakeData(String StartDate, String EndDate) {


        progressDialog = ProgressDialog.show(this, "Please wait",
                "Updating Data..", false);
        String url2 = mainUrl + "&starttime=" + StartDate + "&endtime=" + EndDate;
        final StringRequest earthQuakeRequest1 = new StringRequest(Request.Method.GET, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }

                try {

                    JSONObject responseObject = new JSONObject(response);
                    // JSONObject typeObject = responseObject.getJSONObject("type");
                    JSONObject metadataObject = responseObject.getJSONObject("metadata");
                    JSONArray featuresArray = responseObject.getJSONArray("features");
//                    String a = String.valueOf(featuresArray.length());

//                    Toast.makeText(MainActivity.this, a, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < featuresArray.length(); i++) {


                        JSONObject json = featuresArray.getJSONObject(i);
                        String featuretype = json.getString("type");
                        String id = json.getString("id");

                        JSONObject propertiesObject = json.getJSONObject("properties");
                        String mag = propertiesObject.getString("mag");
                        String place = propertiesObject.getString("place");
                        String time = propertiesObject.getString("time");
                        String updated = propertiesObject.getString("updated");
                        String tz = propertiesObject.getString("tz");
                        String url = propertiesObject.getString("url");
                        String detail = propertiesObject.getString("detail");
                        String felt = propertiesObject.getString("felt");
                        String cdi = propertiesObject.getString("cdi");
                        String mmi = propertiesObject.getString("mmi");
                        String alert = propertiesObject.getString("alert");
                        String status = propertiesObject.getString("status");
                        String tsunami = propertiesObject.getString("tsunami");
                        String sig = propertiesObject.getString("sig");
                        String net = propertiesObject.getString("net");
                        String code = propertiesObject.getString("code");
                        String ids = propertiesObject.getString("ids");
                        String sources = propertiesObject.getString("sources");
                        String types = propertiesObject.getString("types");
                        String nst = propertiesObject.getString("nst");
                        String dmin = propertiesObject.getString("dmin");
                        String rms = propertiesObject.getString("rms");
                        String gap = propertiesObject.getString("gap");
                        String magType = propertiesObject.getString("magType");
                        String type = propertiesObject.getString("type");
                        String title = propertiesObject.getString("title");
                        Log.d(TAG, place);
//                        Log.d(TAG, "type" +type+"  " + "id"+id);
                        JSONObject geometryObj = json.getJSONObject("geometry");
                        String geometryType = geometryObj.getString("type");

                        JSONArray coordinatesArray = geometryObj.getJSONArray("coordinates");
                        String coordinateValue = coordinatesArray.toString();
                        //keeping 3 values in coordinateValue
                        //  Log.d(TAG, coordinateValue);
                        for (int j = 0; j < coordinatesArray.length(); j++) {
                            String value = coordinatesArray.getString(j);
                            //   Log.d(TAG, value);
                            //    keeping 1 value in value
                            // String a= coordinateJson.toString();

                        }


                        FeaturesData featuresData = new FeaturesData(mag, place, time, updated, tz, url, detail, felt, cdi, mmi, alert, status, tsunami, sig, net, code, ids, sources, types, nst, dmin, rms, gap, magType, type, title, featuretype, geometryType, coordinateValue);
                        featuresDataArrayList.add(featuresData);
                        com.bdjobs.training.earthquakeapp.ListAdapter listAdapter = new com.bdjobs.training.earthquakeapp.ListAdapter(getApplicationContext(), featuresDataArrayList);
                        earthQuakeLV.setAdapter(listAdapter);


                    }

                    String type = responseObject.getString("type");
                    String generated = metadataObject.getString("title");
                    String getCount = metadataObject.getString("count");
                    counter = getCount;
                    counterTV.setText("Total Counter " + counter);
                    //Toast.makeText(MainActivity.this, generated, Toast.LENGTH_SHORT).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //featuresArray = null;

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }

        };


        MySingleton.getInstance(this).addToRequestQueue(earthQuakeRequest1);

    }
}
