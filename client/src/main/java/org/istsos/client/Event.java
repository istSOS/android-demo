package org.istsos.client;

/**
 * Contains events that will be fired when task has been successfully completed.
 *
 */
public enum Event {
	
	// Fired at every request made
    REQUEST,
	
	// Fired when services are load 
    SERVICE_LOADED,
    
    //fired when configuration sections are loaded
    CONFIGURATION_SECTIONS_LOADED,
    
    //fired when geometry collection is loaded
    GEOMETRY_COLLECTION_LOADED,
    
    // Fired when the database configuration section of a service is loaded
    DATABASE_LOADED,
    
    //Fired when the database is validated
    DATABASE_VALIDATED,
    
    //fired when observed properties list is loaded
    OBSERVED_PROPERTIES_LOADED,
    
    //fired when observed property is registered to service
    OBSERVED_PROPERTY_REGISTERED,
    
    //fired when selected observed property is updated 
    OBSERVED_PROPERTY_UPDATED,
    
    //fired when observed property is removed from service
    OBSERVED_PROPERTY_REMOVED,
    
    //fired when data qualities list is loaded
    DATA_QUALITIES_LOADED,
    
    //fired when data quality is registered to service
    DATA_QUALITY_REGISTERED,
    
    //fired when selected data quality is updated
    DATA_QUALITY_UPDATED,
    
    //fired when selected data quality is removed
    DATA_QUALITY_REMOVED,
    
    //fired when procedures list is loaded
    PROCEDURES_LOADED,
    
    //fired when a single procedure is loaded
    PROCEDURE_LOADED,
    
    //fired when procedure is registered to service
    PROCEDURE_REGISTERED,
    
    //fired when selected procedure is updated
    PROCEDURE_UPDATED,
    
    //fired when virtual procedures list is loaded
    VIRTUAL_PROCEDURES_LOADED,
    
    //fired when virtual procedure code is loaded
    VIRTUAL_PROCEDURE_CODE_LOADED,
    
    //fired when virtual procedure code is registered
    VIRTUAL_PROCEDURE_CODE_REGISTERED,
    
    //fired when virtual procedure code is updated
    VIRTUAL_PROCEDURE_CODE_UPDATED,
    
    //fired when virtual procedure code is removed
    VIRTUAL_PROCEDURE_CODE_REMOVED,
    
    //fired when virtual procedure rating curve is loaded
    VIRTUAL_PROCEDURE_RATINGCURVE_LOADED,
    
    //fired when virtual procedure rating curve is registered
    VIRTIUAL_PROCEDURE_RATINGCURVE_REGISTERED,
    
    //fired when virtual procedure rating curve is updated
    VIRTUAL_PROCEDURE_RATINGCURVE_UPDATED,
    
    //fired when virtual procedure rating curve is removed
    VIRTUAL_PROCEDURE_RATINGCURVE_REMOVED,
    
    //fired when units of measure list is loaded
    UOMS_LOADED,
    
    //fired when unit of measure is registered to service
    UOM_REGISTERED,
    
    //fired when unit of measure is updated
    UOM_UPDATED,
    
    //fired when unit of measure is removed
    UOM_REMOVED,
    
    //fired when offerings list is loaded
    OFFERINGS_LOADED,
    
    //fired when offering is registered
    OFFERINGS_REGISTERED,
    
    //fired when offering is updated
    OFFERINGS_UPDATED,
    
    //fired when offering is removed
    OFFERINGS_REMOVED,
    
    //fired when procedure members under selected offerings is loaded
    OFFFERINGS_MEMBERS_LOADED,
    
    //fired when procedure members NOT under selected offerings is loaded
    OFFFERINGS_NONMEMBERS_LOADED,
    
    // Fired when service provider is loaded
    PROVIDER_LOADED,
    
    //Fired when service provider 
    PROVIDER_UPDATED,
    
    // Fired when service identification configuration is loaded
    IDENTIFICATION_LOADED,
    
    // Fired when service identification is updated
    IDENTIFICATION_UPDATED,
    
    //Fired when coordinates system configuration is loaded
    COORDINATES_SYSTEM_LOADED,
    
    //fired when coordinates system is updated
    COORDINATES_SYSTEM_UPDATED,
    
    //fired when mqtt publisher configuration is loaded
    MQTT_PUBLISHER_LOADED,
    
    //fired when mqtt publisher configuration is updated
    MQTT_PUBLISHER_UPDATED,
    
    //fired when proxy configuration is loaded
    PROXY_CONFIGURATION_LOADED,
    
    //fired when proxy configuration is updated
    PROXY_CONFIGURATION_UPDATED,
    
    //fired when system types configuration is loaded
    SYSTEM_TYPES_LOADED,
    
    //fired when valid list epsg codes is loaded
    EPSG_LOADED,
    
    //fired when information about istsos is loaded
    ABOUT_LOADED,
    
    //fired when status information is loaded
    STATUS_LOADED,
    
    //fired when getobservation configuration is loaded
    OBSERVATION_CONFIGURATION_LOADED,
    
    //fired when getobservation configuration is updated
    OBSERVATION_CONFIGURATION_UPDATED,
    
    //fired when getobservation is loaded
    OBSERVATION_LOADED,
    
    //fired when observation is inserted
    OBSERVATION_INSERTED,
    
}