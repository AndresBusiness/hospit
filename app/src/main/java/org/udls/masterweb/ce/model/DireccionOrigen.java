package org.udls.masterweb.ce.model;

/**
 * Created by Andres on 11/28/2017.
 */

public class DireccionOrigen {
    private String  place_id;
    private String licence;
    private String osm_type;
    private String osm_id;
    private String lat;
    private String lon;
    private String display_name;
    private String[] boundingbox;

    public DireccionOrigen(){

    }
    public DireccionOrigen(  String  place_id, String licence, String osm_type, String osm_id, String lat, String lon, String display_name){
      this.place_id = place_id;
        this.licence = licence;
        this.osm_type = osm_type;
        this.osm_id = osm_id;
        this.lat = lat;
        this.lon = lon;
        this.display_name = display_name;

    }
    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getOsm_type() {
        return osm_type;
    }

    public void setOsm_type(String osm_type) {
        this.osm_type = osm_type;
    }

    public String getOsm_id() {
        return osm_id;
    }

    public void setOsm_id(String osm_id) {
        this.osm_id = osm_id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }


    public String[] getBoundingbox() {
        return boundingbox;
    }

    public void setBoundingbox(String[] boundingbox) {
        this.boundingbox = boundingbox;
    }
}
