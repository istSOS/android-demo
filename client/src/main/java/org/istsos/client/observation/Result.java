package org.istsos.client.observation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * Handles result element of an observation.
 *
 */
public class Result {
	
	@SerializedName ("DataArray")
	private DataArray dataArray;

	public DataArray getDataArray() {
		return dataArray;
	}

	public void setDataArray(DataArray dataArray) {
		this.dataArray = dataArray;
	}


	@Override
	public String toString() {
		return "DataArray: " + dataArray;
	}

	static Result fromJson(JsonObject json) {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, Result.class);
		
	}

}