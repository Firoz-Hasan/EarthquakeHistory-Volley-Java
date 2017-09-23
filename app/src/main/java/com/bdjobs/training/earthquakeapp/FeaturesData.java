package com.bdjobs.training.earthquakeapp;

/**
 * Created by FIROZ HASAN on 8/27/2017.
 */

public class FeaturesData {
    String  mag;
    String place;
    String time;
    String update;
    String tz;
    String url;
    String detail;
    String felt;
    String cdi;
    String mmi;
    String alert;
    String status;
    String tsunami;
    String sig;
    String net;
    String code;
    String ids;
    String source;
    String types;
    String nst;
    String dmin;
    String rms;
    String gap;
    String magtype;
    String type;
    String title;
    String featureType ;
    String geometryType;
    String coordinateValue;

    public String getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }

    public String getCoordinateValue() {
        return coordinateValue;
    }

    public void setCoordinateValue(String coordinateValue) {
        this.coordinateValue = coordinateValue;
    }

    public String getFeatureType() {
        return featureType;
    }

    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }



    public FeaturesData(String mag, String place, String time, String update, String tz, String url, String detail, String felt, String cdi, String mmi, String alert, String status, String tsunami, String sig, String net, String code, String ids, String source, String types, String nst, String dmin, String rms, String gap, String magtype, String type, String title,  String featureType, String geometryType,
            String coordinateValue) {
        this.mag = mag;
        this.place = place;
        this.time = time;
        this.update = update;
        this.tz = tz;
        this.url = url;
        this.detail = detail;
        this.felt = felt;
        this.cdi = cdi;
        this.mmi = mmi;
        this.alert = alert;
        this.status = status;
        this.tsunami = tsunami;
        this.sig = sig;
        this.net = net;
        this.code = code;
        this.ids = ids;
        this.source = source;
        this.types = types;
        this.nst = nst;
        this.dmin = dmin;
        this.rms = rms;
        this.gap = gap;
        this.magtype = magtype;
        this.type = type;
        this.title = title;
        this.featureType = featureType;
        this.geometryType = geometryType;
        this.coordinateValue = coordinateValue;
    }

    public String getTz() {

        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getFelt() {
        return felt;
    }

    public void setFelt(String felt) {
        this.felt = felt;
    }

    public String getCdi() {
        return cdi;
    }

    public void setCdi(String cdi) {
        this.cdi = cdi;
    }

    public String getMmi() {
        return mmi;
    }

    public void setMmi(String mmi) {
        this.mmi = mmi;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTsunami() {
        return tsunami;
    }

    public void setTsunami(String tsunami) {
        this.tsunami = tsunami;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getNst() {
        return nst;
    }

    public void setNst(String nst) {
        this.nst = nst;
    }

    public String getDmin() {
        return dmin;
    }

    public void setDmin(String dmin) {
        this.dmin = dmin;
    }

    public String getRms() {
        return rms;
    }

    public void setRms(String rms) {
        this.rms = rms;
    }

    public String getGap() {
        return gap;
    }

    public void setGap(String gap) {
        this.gap = gap;
    }

    public String getMagtype() {
        return magtype;
    }

    public void setMagtype(String magtype) {
        this.magtype = magtype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FeaturesData(String mag, String place, String time, String update) {
        this.mag = mag;
        this.place = place;
        this.time = time;
        this.update = update;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
}
