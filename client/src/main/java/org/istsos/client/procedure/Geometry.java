package org.istsos.client.procedure;

/**
 * Handles geometry for Procedure class.
 *
 */
public class Geometry {

    private String type;
    private double[] coordinates;


    public Geometry(String type, double[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {

        String coord = "[";

        for(int i = 0; i < coordinates.length; i++){
            coord = coord.concat(coordinates[i] + ", ");
        }

        coord = coord.concat("]");


        return "Type: " + this.type + " Coordinates: " + coord;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
}