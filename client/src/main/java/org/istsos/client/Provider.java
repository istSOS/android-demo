package org.istsos.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * Provider class. Handles data related to service provider.
 * Supports conversion to/from JSON.
 *
 */
@SuppressWarnings("rawtypes")
public class Provider implements IstSOSObject{
	
	@SerializedName ("contactcountry")
	private String contactcountry;
	
	@SerializedName ("providername")
	private String providername;
	
	@SerializedName ("contactposition")
	private String contactposition;
	
	@SerializedName ("conctactvoice")
	private String contactvoice;
	
	@SerializedName ("contactadminarea")
	private String contactadminarea;
	
	@SerializedName ("contactemail")
	private String contactemail;
	
	@SerializedName ("contactdeliverypoint")
	private String contactdeliverypoint;
	
	@SerializedName ("contactname")
	private String contactname;
	
	@SerializedName ("contactpostalcode")
	private String contactpostalcode;
	
	@SerializedName ("contactcity")
	private String contactcity;
	
	@SerializedName ("providersite")
	private String providersite;
	
	@SerializedName ("contactfax")
	private String contactfax;
	
	
	public String getContactcountry() {
		return contactcountry;
	}
	
	public void setContactcountry(String contactcountry) {
		this.contactcountry = contactcountry;
	}
	
	public String getProvidername() {
		return providername;
	}
	
	public void setProvidername(String providername) {
		this.providername = providername;
	}
	
	public String getContactposition() {
		return contactposition;
	}
	
	public void setContactposition(String contactposition) {
		this.contactposition = contactposition;
	}
	
	public String getContactvoice() {
		return contactvoice;
	}
	
	public void setContactvoice(String contactvoice) {
		this.contactvoice = contactvoice;
	}
	
	public String getContactadminarea() {
		return contactadminarea;
	}
	
	public void setContactadminarea(String contactadminarea) {
		this.contactadminarea = contactadminarea;
	}
	
	public String getContactemail() {
		return contactemail;
	}
	
	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}
	
	public String getContactdeliverypoint() {
		return contactdeliverypoint;
	}
	
	public void setContactdeliverypoint(String contactdeliverypoint) {
		this.contactdeliverypoint = contactdeliverypoint;
	}
	
	public String getContactname() {
		return contactname;
	}
	
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	
	public String getContactpostalcode() {
		return contactpostalcode;
	}
	
	public void setContactpostalcode(String contactpostalcode) {
		this.contactpostalcode = contactpostalcode;
	}
	
	public String getContactcity() {
		return contactcity;
	}
	
	public void setContactcity(String contactcity) {
		this.contactcity = contactcity;
	}
	
	public String getProvidersite() {
		return providersite;
	}
	
	public void setProvidersite(String providersite) {
		this.providersite = providersite;
	}
	
	public String getContactfax() {
		return contactfax;
	}
	
	public void setContactfax(String contactfax) {
		this.contactfax = contactfax;
	}
	

	public JsonObject toJson() {
		// TODO Auto-generated method stub
		JsonObject json = new JsonObject();
		json.addProperty("contactadminarea", this.getContactadminarea());
		json.addProperty("contactcity", this.getContactcity());
		json.addProperty("contactcountry", this.getContactcountry());
		json.addProperty("contactdeliverypoint", this.getContactdeliverypoint());
		json.addProperty("contactemail", this.getContactemail());
		json.addProperty("contactfax", this.getContactfax());
		json.addProperty("contactname", this.getContactname());
		json.addProperty("contactposition", this.getContactposition());
		json.addProperty("contactpostalcode", this.getContactpostalcode());
		json.addProperty("contactvoice", this.getContactvoice());
		json.addProperty("providername", this.getProvidername());
		json.addProperty("providersite", this.getProvidersite());
		return json;
	}
	

	static Provider fromJson(JsonObject json) {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, Provider.class);
	}
	
}