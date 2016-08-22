package org.istsos.client;


import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;

/**
 * Handles creation of URL for IstSOS requests based on the
 * event.
 * <p>
 * NOT be used as an instance for to/from JSON conversion, can only be
 * used as part of execute IstSOS requests.
 *
 */
public class Requests {
	
	public static enum Request {
		
		// load available services 
	    SERVICE,
	    
	    // request the database configuration section
	    DATABASE,
	    
	    //request validate database configuration
	    VALIDATE_DATABASE,
	    
	    //request configuration sections
	    CONFIGURATION_SECTIONS,
	    
	    //request procedures from service
	    PROCEDURES,
	    
	    //request procedure operations from service
	    PROCEDURE,
	    
	    //request virtual procedures from service
	    VIRTUAL_PROCEDURES,
	    
	    //request virtual procedure code from service
	    VIRTUAL_PROCEDURES_CODE,
	    
	    //request virtual procedure rating curve from service
	    VIRTUAL_PROCEDURES_RATINGCURVE,
	    
	    //request observed properties list from service
	    OBSERVED_PROPERTIES,
	    
	    //request data qualities list from service
	    DATA_QUALITIES,
	    
	    //request units of measure list from service
	    UOMS,
	    
	    //request offerings list from service
	    OFFERINGS,
	    
	    //request procedures under selected offering
	    OFFERINGS_MEMBERS,
	    
	    //request procedures not under selected offering
	    OFFERINGS_NONMEMBERS,
	    
	    // request the service provider configuration section
	    PROVIDER,
	    
	    //request the service identification configuration
	    IDENTIFICATION,
	    
	    //request coordinates system configuration
	    COORDINATES_SYSTEM,
	    
	    //request mqtt publisher configuration
	    MQTT_PUBLISHER,
	    
	    //request proxy configuration
	    PROXY_CONFIGURATION,
	    
	    //request geometry collections
	    GEOMETRY_COLLECTION,
	    
	    //request system types configuration
	    SYSTEM_TYPES,
	    
	    //request list of valid epsg codes from service
	    EPSG,
	    
	    //request information about istSOS
	    ABOUT,
	    
	    //request status of services
	    STATUS,
	    
	    //request getobservation configuration
	    GETOBSERVATION_CONFIGURATION,
	    
	    //request getobservation
	    GETOBSERVATION,
	    
	    //request insert observation
	    INSERT_OBSERVATION
	    
	    
	}
	
	public static String getUrl(Request request, Map<String, String> urlKeyMap){
		
		String url = "${url}";
		StrSubstitutor sub = new StrSubstitutor(urlKeyMap);
		
		switch (request) {
		
        	case ABOUT:
        		url+="wa/istsos/operations/about";
        		break;
        		
        	case CONFIGURATION_SECTIONS:
        		url+="wa/istsos/services/${name}/configsections";
        		break;
        		
        	case GEOMETRY_COLLECTION:
        		url+="wa/istsos/services/${name}/procedures/operations/geojson";
        		break;
		
	        case SERVICE:
	        	url+="wa/istsos/services";
	            break;
	            
	        case PROVIDER:
	        	url+="wa/istsos/services/${name}/configsections/provider";
	        	break;
	        	
	        case IDENTIFICATION:
	        	url+="wa/istsos/services/${name}/configsections/identification";
	        	break;
	        	
	        case COORDINATES_SYSTEM:
	        	url+="wa/istsos/services/${name}/configsections/geo";
	        	break;
	        	
	        case MQTT_PUBLISHER:
	        	url+="wa/istsos/services/${name}/configsections/mqtt";
	        	break;
	        	
	        case PROXY_CONFIGURATION:
	        	url+="wa/istsos/services/${name}/configsections/serviceurl";
	        	break;
	        	
	        case SYSTEM_TYPES:
	        	url+="wa/istsos/services/${name}/systemtypes";
	        	break;
	        	
	        case EPSG:
	        	url+="wa/istsos/services/${name}/epsgs";
	        	break;
	        	
	        case STATUS:
	        	url+="wa/istsos/operations/status";
	        	break;
	        
	        case GETOBSERVATION_CONFIGURATION:
	        	url+="wa/istsos/services/${name}/configsections/getobservation";
	        	break;
	                
	        case DATABASE:
	        	url+="wa/istsos/services/${name}/configsections/connection";
	            break;
	        
	        case VALIDATE_DATABASE:
	        	url+="wa/istsos/operations/validatedb";
	        	break;
	        	
	        case PROCEDURES:
	        	url+="wa/istsos/services/${name}/procedures/operations/getlist";
	        	break;
	        	
	        case PROCEDURE:
	        	if(urlKeyMap.containsKey("code") == false){
	        		url+="wa/istsos/services/${name}/procedures";
		        	break;
	        	}else{
	        		url+="wa/istsos/services/${name}/procedures/${code}";
		        	break;
	        	}
	        	
	        case VIRTUAL_PROCEDURES:
	        	if(urlKeyMap.containsKey("code") == false){
	        		url+="wa/istsos/services/${name}/virtualprocedures/operations/getlist";
		        	break;
	        	}else{
	        		url+="wa/istsos/services/${name}/virtualprocedures/${code}";
	        		break;
	        	}
	        	
	        case VIRTUAL_PROCEDURES_CODE:
	        	url+="wa/istsos/services/${name}/virtualprocedures/${code}/code";
	        	break;
	        	
	        case VIRTUAL_PROCEDURES_RATINGCURVE:
	        	url+="wa/istsos/services/${name}/virtualprocedures/${code}/code";
	        	break;
	        	
	        case OBSERVED_PROPERTIES:
	        	if(urlKeyMap.containsKey("code") == false){
	        		url+="wa/istsos/services/${name}/observedproperties";
		        	break;
	        	}else{
	        		url+="wa/istsos/services/${name}/observedproperties/${code}";
		        	break;
	        	}
	        	
	        case DATA_QUALITIES:
	        	if(urlKeyMap.containsKey("code") == false){
	        		url+="wa/istsos/services/${name}/dataqualities";
	        		break;
	        	}else{
	        		url+="wa/istsos/services/${name}/dataqualities/${code}";
	        		break;
	        	}
	        	
	        case UOMS:
	        	if(urlKeyMap.containsKey("code") == false){
	        		url+="wa/istsos/services/${name}/uoms";
		        	break;
	        	}else{
	        		url+="wa/istsos/services/${name}/uoms/${code}";
		        	break;
	        	}
	        	
	        case OFFERINGS:
	        	if(urlKeyMap.containsKey("code") == false){
	        		url+="wa/istsos/services/${name}/offerings";
		        	break;
	        	}else{
	        		url+="wa/istsos/services/${name}/offerings/${code}";
		        	break;
	        	}
	        
	        case OFFERINGS_MEMBERS:
	        	url+="wa/istsos/services/${name}/offerings/${code}/procedures/operations/memberslist";
	        	break;
	        	
	        case OFFERINGS_NONMEMBERS:
	        	url+="wa/istsos/services/${name}/offerings/${code}/procedures/operations/nonmemberslist";
	        	break;
	        	
	        case GETOBSERVATION:
	        	url+="wa/istsos/services/${name}/operations/getobservation/offerings/"
	        			+ "${offering}/procedures/${procedure}/observedproperties/"
	        			+ "${definition}/eventtime/${begin_position}/${end_position}";

				System.out.println(url);
				break;
			
	        case INSERT_OBSERVATION:
	        	url+="wa/istsos/istsos/services/{SERVICE_NAME}/operations/insertobservation";
	        	break;
			
	                    
	        default:
	        	url+="wa/istsos/services";
	            break;
	            
	    }

        return sub.replace(url);
	}
	
	
}