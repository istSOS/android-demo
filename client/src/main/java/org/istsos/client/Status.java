package org.istsos.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * Status class.
 * <p>
 * Supports conversion to/from JSON.
 *
 */
public class Status implements IstSOSObject<Status>{
	
	@SerializedName ("getcapabilities")
	private boolean getcapabilities;
	
	@SerializedName ("featuresOfInterest")
	private String featuresOfInterest;
	
	@SerializedName ("describesensor")
	private boolean describesensor;
	
	@SerializedName ("getobservation")
	private boolean getobservation;
	
	@SerializedName ("service")
	private String service;
	
	@SerializedName ("database")
	private String database;
	
	@SerializedName ("availability")
	private String availability;
	
	@SerializedName ("offerings")
	private int offerings;
	
	@SerializedName ("getfeaturesofinterest")
	private boolean getfeaturesofinterest;
	
	@SerializedName ("registersensor")
	private boolean registersensor;
	
	@SerializedName ("procedures")
	private int procedures;
	
	@SerializedName ("observedProperties")
	private int observedProperties;
	
	@SerializedName ("insertobservation")
	private boolean insertobservation;
	
	
	public boolean isGetcapabilities() {
		return getcapabilities;
	}
	public void setGetcapabilities(boolean getcapabilities) {
		this.getcapabilities = getcapabilities;
	}
	public String getFeaturesOfInterest() {
		return featuresOfInterest;
	}
	public void setFeaturesOfInterest(String featuresOfInterest) {
		this.featuresOfInterest = featuresOfInterest;
	}
	public boolean isDescribesensor() {
		return describesensor;
	}
	public void setDescribesensor(boolean describesensor) {
		this.describesensor = describesensor;
	}
	public boolean isGetobservation() {
		return getobservation;
	}
	public void setGetobservation(boolean getobservation) {
		this.getobservation = getobservation;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public int getOfferings() {
		return offerings;
	}
	public void setOfferings(int offerings) {
		this.offerings = offerings;
	}
	public boolean isGetfeaturesofinterest() {
		return getfeaturesofinterest;
	}
	public void setGetfeaturesofinterest(boolean getfeaturesofinterest) {
		this.getfeaturesofinterest = getfeaturesofinterest;
	}
	public boolean isRegistersensor() {
		return registersensor;
	}
	public void setRegistersensor(boolean registersensor) {
		this.registersensor = registersensor;
	}
	public int getProcedures() {
		return procedures;
	}
	public void setProcedures(int procedures) {
		this.procedures = procedures;
	}
	public int getObservedProperties() {
		return observedProperties;
	}
	public void setObservedProperties(int observedProperties) {
		this.observedProperties = observedProperties;
	}
	public boolean isInsertobservation() {
		return insertobservation;
	}
	public void setInsertobservation(boolean insertobservation) {
		this.insertobservation = insertobservation;
	}
	

	public JsonObject toJson() {

		Gson gson = new GsonBuilder().create();
		return gson.toJsonTree(this, Status.class).getAsJsonObject();
	}
	
	
	static Status fromJson(JsonObject json) {
		
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, Status.class);
	}
}