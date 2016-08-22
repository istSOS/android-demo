package org.istsos.client;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * VirtualProcedure class. Supports conversion to/from JSON.
 * <p>
 * Used as Procedure class instance when requesting all virtual procedures
 * from service. Holds Python code as String format, as well as RatingCurve.
 *
 */
public class VirtualProcedure extends Procedure{
	
	@SerializedName ("code")
	private String code;
	
	@SerializedName ("ratingcurve")
	private ArrayList<RatingCurveParameters> ratingCurve = new ArrayList<RatingCurveParameters>();
	
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public ArrayList<RatingCurveParameters> getRatingCurve() {
		return ratingCurve;
	}
	
	public void setRatingCurve(ArrayList<RatingCurveParameters> ratingCurve) {
		this.ratingCurve = ratingCurve;
	}
	
	
	static VirtualProcedure fromJson(JsonObject json){
		
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, VirtualProcedure.class);
		
		
	}
	
}
