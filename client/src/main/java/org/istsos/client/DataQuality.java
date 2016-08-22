package org.istsos.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * DataQuality class. Supports conversion both to/from JSON.
 *
 */
public class DataQuality implements IstSOSObject<DataQuality> {
	
	@SerializedName ("code")
	private int dataQualityCode;
	
	@SerializedName ("name")
	private String dataQualityName;
	
	@SerializedName ("description")
	private String dataQualityDescription;

	
	public int getDataQualityCode() {
		return dataQualityCode;
	}

	public void setDataQualityCode(int dataQualityCode) {
		this.dataQualityCode = dataQualityCode;
	}

	public String getDataQualityName() {
		return dataQualityName;
	}

	public void setDataQualityName(String dataQualityName) {
		this.dataQualityName = dataQualityName;
	}

	public String getDataQualityDescription() {
		return dataQualityDescription;
	}

	public void setDataQualityDescription(String dataQualityDescription) {
		this.dataQualityDescription = dataQualityDescription;
	}

	public JsonObject toJson() {
		
		Gson gson = new GsonBuilder().create();
		return gson.toJsonTree(this, DataQuality.class).getAsJsonObject();
	}


	static DataQuality fromJson(JsonObject json) {

		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, DataQuality.class);
	}
}