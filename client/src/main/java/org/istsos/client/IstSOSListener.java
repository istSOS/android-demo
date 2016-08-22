package org.istsos.client;

/**
 * IstSOS interface for event listener.
 *
 */
public interface IstSOSListener {
	void onSuccess(EventObject event);
	void onError(EventObject event);
}