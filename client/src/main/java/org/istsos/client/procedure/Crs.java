package org.istsos.client.procedure;

import java.util.HashMap;

/**
 * Handles coordinates system response from Procedure class.
 *
 */
public class Crs {

    private String type;
    private HashMap<String, String> properties;

    public Crs(String type, HashMap<String, String> properties) {
        this.type = type;
        this.properties = properties;
    }

    @Override
    public String toString() {

        String res = "";

        for (String key : properties.keySet()) {
            res = res.concat(key + " " + properties.get(key));
        }

        return "Type: " + this.type + " properties: [" + res + "]";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }
}