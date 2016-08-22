package org.istsos.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * Offering class. Holds information such as name, description, visibility status,
 * expiration date, id, procedures count. 
 * Supports conversion to/from JSON.
 *
 */
@SuppressWarnings("rawtypes")
public class Offering implements IstSOSObject{
	
	
	@SerializedName ("name")
	private String name;
	
	@SerializedName ("description")
	private String description;
	
	@SerializedName ("active")
	private boolean status;
	
	@SerializedName ("expiration")
	private String expiration;
	
	@SerializedName ("id")
	private String id;
	
	@SerializedName ("procedures")
	private int procedures;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getProcedures() {
		return procedures;
	}

	public void setProcedures(int procedures) {
		this.procedures = procedures;
	}

	
	

	public JsonObject toJson() {
		// TODO Auto-generated method stub
		JsonObject json = new JsonObject();
		json.addProperty("name", this.getName());
		json.addProperty("description", this.getDescription());
		json.addProperty("active", this.isStatus());
		json.addProperty("expiration", this.getExpiration());
		json.addProperty("id", this.getId());
		json.addProperty("procedures", this.getProcedures());
		return json;
	}


	static Offering fromJson(JsonObject json) {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, Offering.class);
	}
	
}