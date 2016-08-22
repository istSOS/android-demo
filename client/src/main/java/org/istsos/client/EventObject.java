package org.istsos.client;

/**
 * Implementation of Observable-Observer
 *
 */
public class EventObject {
	
	private Event event;
	
	private Object object;

	public EventObject(Event event, Object object) {
		this.event = event;
		this.object = object;
	}

	public Event getEvent() {
		return event;
	}

	public Object getObject() {
		return object;
	}
	
}