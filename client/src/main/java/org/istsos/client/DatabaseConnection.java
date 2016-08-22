package org.istsos.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;


/**
 * Used for creating a connection to a database. Can hold data related
 * to dbname, host, user, password, port.
 * Supports conversion to/from JSON.
 *
 */
@SuppressWarnings("rawtypes")
public class DatabaseConnection implements IstSOSObject{
	
	@SerializedName ("dbname")
	private String dbname;
	
	@SerializedName ("host")
	private String host;
	
	@SerializedName ("user")
	private String user;
	
	@SerializedName ("password")
	private String password;
	
	@SerializedName ("port")
	private String port;
	
	public String getDbname() {
		return dbname;
	}
	
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPort() {
		return port;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	

	public JsonObject toJson() {

		Gson gson = new GsonBuilder().create();
		return gson.toJsonTree(this,DatabaseConnection.class).getAsJsonObject();
	}


	static DatabaseConnection fromJson(JsonObject json) {

		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, DatabaseConnection.class);
	}
}