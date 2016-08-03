package org.istsos.client;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

/**
 * UnitOfMeasure class. Holds data such as name, description, and list of procedures to which it is
 * registered.
 * <p>
 * Supports conversion to/from JSON.
 *
 */
@SuppressWarnings("rawtypes")
public class UnitOfMeasure implements IstSOSObject {
	
	@SerializedName ("name")
	private String unitName;
	
	@SerializedName ("description")
	private String description;
	
	@SerializedName ("procedures")
	private ArrayList<String> procedures = new ArrayList<String>();
	
	
	
	public String getUnitName() {
		return unitName;
	}
	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<String> getProcedures() {
		return procedures;
	}
	
	public void setProcedures(ArrayList<String> procedures) {
		this.procedures = procedures;
	}
	
	

	public JsonObject toJson() {
		// TODO Auto-generated method stub
		JsonObject json = new JsonObject();
		json.addProperty("name", this.getUnitName());
		json.addProperty("description", this.getDescription());
		
		//convert procedures to json
		Gson gson = new GsonBuilder().create();
		JsonElement procedures = gson.toJsonTree(this.getProcedures(), new TypeToken<ArrayList<String>>(){}.getType());
		json.add("procedures", procedures);
		return json;
	}
	
	
	static UnitOfMeasure fromJson(JsonObject json) {
		
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, UnitOfMeasure.class);
	}
	
	

}