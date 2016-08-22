package org.istsos.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * Handles rating curve parameters for the VirtualProcedure instance.
 * Supports conversion to/from JSON.
 *
 */
@SuppressWarnings("rawtypes")
public class RatingCurveParameters implements IstSOSObject {
	
	@SerializedName ("A")
	private String A;
	
	@SerializedName ("C")
	private String C;
	
	@SerializedName ("B")
	private String B;
	
	@SerializedName ("from")
	private String from;
	
	@SerializedName ("up_val")
	private String up_val;
	
	@SerializedName ("K")
	private String K;
	
	@SerializedName ("low_val")
	private String low_val;
	
	@SerializedName ("to")
	private String to;
	
	
	public String getA() {
		return A;
	}
	
	public void setA(String a) {
		A = a;
	}
	
	public String getC() {
		return C;
	}
	
	public void setC(String c) {
		C = c;
	}
	
	public String getB() {
		return B;
	}
	
	public void setB(String b) {
		B = b;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getUp_val() {
		return up_val;
	}
	
	public void setUp_val(String up_val) {
		this.up_val = up_val;
	}
	
	public String getK() {
		return K;
	}
	
	public void setK(String k) {
		K = k;
	}
	
	public String getLow_val() {
		return low_val;
	}
	
	public void setLow_val(String low_val) {
		this.low_val = low_val;
	}
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}

	

	public JsonObject toJson() {
		// TODO Auto-generated method stub
		JsonObject json = new JsonObject();
		json.addProperty("A", this.getA());
		json.addProperty("C", this.getC());
		json.addProperty("B", this.getB());
		json.addProperty("K", this.getK());
		json.addProperty("from", this.getFrom());
		json.addProperty("to", this.getTo());
		json.addProperty("up_val", this.getUp_val());
		json.addProperty("low_val", this.getLow_val());
		return json;
	}

	
	static RatingCurveParameters fromJson(JsonObject json){
		
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, RatingCurveParameters.class);
		
	}
	
}