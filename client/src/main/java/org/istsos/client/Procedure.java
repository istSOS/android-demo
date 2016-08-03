package org.istsos.client;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import org.istsos.client.procedure.Classification;
import org.istsos.client.procedure.Location;

/**
 * Procedure class. Supports conversion to/from JSON.
 *
 */
public class Procedure implements IstSOSObject<Procedure> {
	
	//for get procedure only
	@SerializedName("samplingTime")
	private SamplingTime samplingTime;
	@SerializedName("sensortype")
	private String sensorType;

	private ArrayList<HashMap<String, String>> observedproperties;


	private String system;   //procedure name

	@SerializedName("system_id")
	transient private String systemId;

	private String description;
	private String keywords;

	@SerializedName("assignedSensorId")
	private String assignedId;

	@SerializedName("offerings")
	private ArrayList<String>offerings;


	@SerializedName("identification")
	private ArrayList<Classification> identification = new ArrayList<>();

	@SerializedName("id")
	private int id;

	private Location location;

	private ArrayList<String> capabilities;

	@SerializedName("outputs")
	private ArrayList<ObservedProperty> outputs = new ArrayList<>();

	@SerializedName("classification")
	private ArrayList<Classification> classifications = new ArrayList<>();


	
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getName(){
		return this.system;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public ArrayList<Classification> getIdentification() {
		return identification;
	}

	public void setIdentification(ArrayList<Classification> identification) {
		this.identification = identification;
	}

	public ArrayList<String> getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(ArrayList<String> capabilities) {
		this.capabilities = capabilities;
	}

	public String getAssignedId() {
		return assignedId;
	}

	public void setAssignedId(String assignedId) {
		this.assignedId = assignedId;
	}

	public ArrayList<Classification> getClassifications() {
		return classifications;
	}

	public void setClassifications(ArrayList<Classification> classifications) {
		this.classifications = classifications;
	}

	public SamplingTime getSamplingTime() {
		return samplingTime;
	}

	public void setSamplingTime(SamplingTime samplingTime) {
		this.samplingTime = samplingTime;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	public ArrayList<HashMap<String, String>> getObservedproperties() {
		return observedproperties;
	}

	public void setObservedproperties(ArrayList<HashMap<String, String>> observedproperties) {
		this.observedproperties = observedproperties;
	}


	public String getAssignedid() {
		return this.assignedId;
	}

	public void setAssignedid(String assignedId) {
		this.assignedId = assignedId;
	}

	public ArrayList<String> getOfferings() {
		return offerings;
	}

	public void setOfferings(ArrayList<String> offerings) {
		this.offerings = offerings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


	public ArrayList<ObservedProperty> getOutputs() {
		return outputs;
	}

	public void setOutputs(ArrayList<ObservedProperty> outputs) {
		this.outputs = outputs;
	}

	public JsonObject toJson() {

		Gson gson = new GsonBuilder().create();
		return gson.toJsonTree(this,Procedure.class).getAsJsonObject();
	}


	/**
	 *
	 * Generate a Procedure from json objerct
	 *
	 * @param json
	 * @return Procedure
     */
	static Procedure fromJson(JsonObject json){

		GsonBuilder gsonBuilder = new GsonBuilder();

		// Adapter to avoid exception on empty date string (beginposition or endposition)
		gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
			@Override
			public Date deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
					throws JsonParseException {
				try {
					return df.parse(json.getAsString());
				} catch (ParseException e) {
					return null;
				}
			}
		});

		Gson gson = gsonBuilder.create();

		return gson.fromJson(json, Procedure.class);
	}

}