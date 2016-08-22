package org.istsos.client;

import com.google.gson.JsonObject;

/**
 * Generic-type Interface for to/from conversion for instances in IstSOS environment. 
 *
 * @param <T>
 */
public interface IstSOSObject<T> {
	
	JsonObject toJson();
	
	
}