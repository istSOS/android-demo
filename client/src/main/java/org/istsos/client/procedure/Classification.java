package org.istsos.client.procedure;

/**
 * Used for handling JSON response where a name, definition, and value elements
 * are provided.
 *
 */
public class Classification {

    private String name;
    private String definition;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Classification(String name, String definition, String value) {
        this.name = name;
        this.definition = definition;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " definition: " + this.definition + " value: " + this.value;
    }
}