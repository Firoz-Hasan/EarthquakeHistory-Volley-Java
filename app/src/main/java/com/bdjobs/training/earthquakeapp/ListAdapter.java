package com.bdjobs.training.earthquakeapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FIROZ HASAN on 8/27/2017.
 */

public class ListAdapter extends ArrayAdapter {
    LayoutInflater layoutInflater;
    ArrayList<FeaturesData> featuresDatas;
    Context context;
    ViewHolder viewHolder;

    public ListAdapter(Context context, ArrayList<FeaturesData> featuresDatas) {
        super(context, R.layout.listitem, featuresDatas);
        this.featuresDatas = featuresDatas;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = new ViewHolder();
        if (convertView == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listitem, null);
            viewHolder.magTV = (TextView) convertView.findViewById(R.id.magTV);
            viewHolder.placeTV = (TextView) convertView.findViewById(R.id.placeTV);
            viewHolder.timeTV = (TextView) convertView.findViewById(R.id.timeTV);
            viewHolder.updateTV = (TextView) convertView.findViewById(R.id.updateTV);

            viewHolder.tzTV = (TextView) convertView.findViewById(R.id.tzTV);
            viewHolder.urlTV = (TextView) convertView.findViewById(R.id.urlTV);
            viewHolder.detailTV = (TextView) convertView.findViewById(R.id.detailTV);
            viewHolder.feltTV = (TextView) convertView.findViewById(R.id.feltTV);


            viewHolder.cdiTV = (TextView) convertView.findViewById(R.id.cdiTV);
            viewHolder.mmiTV = (TextView) convertView.findViewById(R.id.mmiTV);
            viewHolder.alertTV = (TextView) convertView.findViewById(R.id.alertTV);
            viewHolder.statusTV = (TextView) convertView.findViewById(R.id.statusTV);

            viewHolder.tsunamiTV = (TextView) convertView.findViewById(R.id.tsunamiTV);
            viewHolder.sigTV = (TextView) convertView.findViewById(R.id.sigTV);
            viewHolder.netTV = (TextView) convertView.findViewById(R.id.netTV);
            viewHolder.codeTV = (TextView) convertView.findViewById(R.id.codeTV);


            viewHolder.idsTV = (TextView) convertView.findViewById(R.id.idsTV);
            viewHolder.sourcesTV = (TextView) convertView.findViewById(R.id.sourcesTV);
            viewHolder.typesTV = (TextView) convertView.findViewById(R.id.typesTV);
            viewHolder.nstTV = (TextView) convertView.findViewById(R.id.nstTV);

            viewHolder.dminTV = (TextView) convertView.findViewById(R.id.dminTV);
            viewHolder.rmsTV = (TextView) convertView.findViewById(R.id.rmsTV);
            viewHolder.gapTV = (TextView) convertView.findViewById(R.id.gapTV);
            viewHolder.magtypeTV = (TextView) convertView.findViewById(R.id.magtypeTV);

            viewHolder.typeTV = (TextView) convertView.findViewById(R.id.typeTV);
            viewHolder.titleTV = (TextView) convertView.findViewById(R.id.titleTV);

            viewHolder.featuretype = (TextView) convertView.findViewById(R.id.featureTypeTV);

            viewHolder.geometryTypeTV = (TextView) convertView.findViewById(R.id.geometryTypeTV);
            viewHolder.coordinateValueTV = (TextView) convertView.findViewById(R.id.coordinateValueTV);

            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String mag = featuresDatas.get(position).getMag();
        String place = featuresDatas.get(position).getPlace();
        String time = featuresDatas.get(position).getTime();
        String update = featuresDatas.get(position).getUpdate();

        String tz = featuresDatas.get(position).getTz();
        String url = featuresDatas.get(position).getUrl();
        String detail = featuresDatas.get(position).getDetail();
        String felt = featuresDatas.get(position).getFelt();

        String cdi = featuresDatas.get(position).getCdi();
        String mmi = featuresDatas.get(position).getMmi();
        String alert = featuresDatas.get(position).getAlert();
        String status = featuresDatas.get(position).getStatus();

        String tsunami = featuresDatas.get(position).getTsunami();
        String sig = featuresDatas.get(position).getSig();
        String net = featuresDatas.get(position).getNet();
        String code = featuresDatas.get(position).getCode();

        String ids = featuresDatas.get(position).getCdi();
        String sources = featuresDatas.get(position).getSource();
        String types = featuresDatas.get(position).getTypes();
        String nst = featuresDatas.get(position).getNst();

        String dmin = featuresDatas.get(position).getDmin();
        String rms = featuresDatas.get(position).getRms();
        String gap = featuresDatas.get(position).getGap();
        String magtype = featuresDatas.get(position).getMagtype();

        String type = featuresDatas.get(position).getType();
        String title = featuresDatas.get(position).getTitle();

        String featureType = featuresDatas.get(position).getFeatureType();
        String geometryType = featuresDatas.get(position).getGeometryType();
        String coordinateValue = featuresDatas.get(position).getCoordinateValue();


        viewHolder.magTV.setText(mag);
        viewHolder.placeTV.setText(place);
        viewHolder.timeTV.setText(time);
        viewHolder.updateTV.setText(update);

        viewHolder.tzTV.setText(tz);
        viewHolder.urlTV.setText(url);
        viewHolder.detailTV.setText(detail);
        viewHolder.feltTV.setText(felt);

        viewHolder.cdiTV.setText(cdi);
        viewHolder.mmiTV.setText(mmi);
        viewHolder.alertTV.setText(alert);
        viewHolder.statusTV.setText(status);

        viewHolder.tsunamiTV.setText(tsunami);
        viewHolder.sigTV.setText(sig);
        viewHolder.netTV.setText(net);
        viewHolder.codeTV.setText(code);

        viewHolder.idsTV.setText(ids);
        viewHolder.sourcesTV.setText(sources);
        viewHolder.typesTV.setText(types);
        viewHolder.nstTV.setText(nst);

        viewHolder.dminTV.setText(dmin);
        viewHolder.rmsTV.setText(rms);
        viewHolder.gapTV.setText(gap);
        viewHolder.magtypeTV.setText(magtype);
        viewHolder.typeTV.setText(type);
        viewHolder.titleTV.setText(title);

        viewHolder.featuretype.setText(featureType);
        viewHolder.geometryTypeTV.setText(geometryType);
        viewHolder.coordinateValueTV.setText(coordinateValue);


        return convertView;
    }

    public class ViewHolder {
        TextView featuretype, magTV, placeTV, timeTV, updateTV, tzTV, urlTV, detailTV, feltTV, cdiTV, mmiTV, alertTV,
                statusTV, sigTV, netTV, codeTV, idsTV, sourcesTV, tsunamiTV, typesTV, nstTV, dminTV, rmsTV, gapTV,
                magtypeTV, typeTV, titleTV, geometryTypeTV, coordinateValueTV;

    }
}
