package org.istsos.client;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * SamplingTime class.
 * <p> 
 * Handles begin and end positions for time interval in observations. 
 * Begin and End positions are created as Java Date type object
 * of the following format: yyyy-MM-dd'T'HH:mm:ssXX.
 * <p>
 * Supports conversion to/from JSON.
 *
 */
@SuppressWarnings("rawtypes")
public class SamplingTime implements IstSOSObject{

	transient private String duration;
	@SerializedName("beginposition")
	private Date beginPosition;
	@SerializedName("endposition")
	private Date endPosition;

    public SamplingTime(String duration, Date beginPosition, Date endPosition) {
        this.duration = duration;
        this.beginPosition = beginPosition;
        this.endPosition = endPosition;
    }

    public SamplingTime() {
    }

    public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getBeginPosition() {
		return beginPosition;
	}

	public void setBeginPosition(Date beginPosition) {
		this.beginPosition = beginPosition;
	}

	public Date getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(Date endPosition) {
		this.endPosition = endPosition;
	}

	@Override
	public String toString() {

		return "begin_pos: " + this.beginPosition + " end_pos: " + this.endPosition;
		//return super.toString();
	}


	public JsonObject toJson() {
		// TODO Auto-generated method stub
		JsonObject json = new JsonObject();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssXX").create();
		
		json.addProperty("duration", this.getDuration());
		json.addProperty("beginPosition", gson.toJson(this.getBeginPosition()));
		json.addProperty("endPosition", gson.toJson(this.getEndPosition()));
		
		return json;
	}


	static SamplingTime fromJson(JsonObject json) {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssXX").create();
		return gson.fromJson(json, SamplingTime.class);
	}
}