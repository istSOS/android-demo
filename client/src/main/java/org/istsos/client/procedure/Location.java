package org.istsos.client.procedure;

import java.util.HashMap;

/**
 * Handles location element for Procedure class.
 *
 */
public class Location {

    private String type;
    private Geometry geometry;
    private Crs crs;
    private HashMap<String, String> properties;


    public Location(String type, Geometry geometry, Crs crs, HashMap<String, String> properties) {
        this.type = type;
        this.geometry = geometry;
        this.crs = crs;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Type: " + this.type + "\nGeometry: " + this.geometry + "\ncrs: " + this.crs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Crs getCrs() {
        return crs;
    }

    public void setCrs(Crs crs) {
        this.crs = crs;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }
}