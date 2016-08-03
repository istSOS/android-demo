package org.istsos.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.loopj.android.http.*;
import cz.msebera.android.httpclient.Header;

import com.google.gson.JsonParser;

/**
 * Main class for initializing IstSOS configuration and Server initialization. 
 * Implements HTTP asynchronous requests to IstSOS environment.
 *
 */
public class IstSOS{
	
	private HashMap<String, Server> servers = new HashMap<String, Server>(0);
	
	private static volatile IstSOS instance;
	
	private static AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		
    private IstSOS() { }
    
    public static IstSOS getInstance() {
        if (instance == null ) {
            synchronized (IstSOS.class) {
                if (instance == null) {
                    instance = new IstSOS();
                }
            }
        }
        return instance;
    }
	
    public Server addServer(String name, Server server) {
        this.servers.put(name, server);
    	return server;
    }
	
    public Server initServer(String name, String url) {
        return this.addServer(name, new Server(name, url));
    }
	
    public Server initServer(String name, String url, String user, String password) {
    	return this.addServer(name, new Server(name, url, user, password));
    }
    
    public Server getServer(String name){
    	return this.servers.get(name);
    }
    
    public Collection<Server> getServers(){
    	return this.servers.values();
    }



    protected static void executeGet(String url, final IstSOSListener callback, ArrayList<String> realm){

		RequestParams params = new RequestParams();

		asyncHttpClient.get(url, params, new TextHttpResponseHandler() {
					@Override
					public void onSuccess(int statusCode, Header[] headers, String res) {
						// called when response HTTP status is "200 OK"
						System.out.println("Request executed..");

						EventObject eventObject = new EventObject(
								Event.REQUEST,
								new JsonParser()
										.parse(res)
										.getAsJsonObject());

						if(callback != null){
							callback.onSuccess(eventObject);
						}
					}

					@Override
					public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
						// called when response HTTP status is "4XX" (eg. 401, 403, 404)
						System.out.println("Request failed");
						System.out.println("Status code: " + statusCode);
						System.out.println(res);
					}
				}
		);
    }
    
    //post request
    protected static void executePost(String url, String data, final IstSOSListener callback, ArrayList<String> realm) {

        //TODO: implement post request
    	/*BoundRequestBuilder builder = asyncHttpClient.preparePost(url).setBody(data);

    	if(realm != null){
			Realm tmpRealm = new Realm.Builder(realm.get(0), realm.get(1))
					.setUsePreemptiveAuth(true)
					.setScheme(AuthScheme.BASIC)
					.build();
			builder.setRealm(tmpRealm);
    	}
    	
    	builder.execute(new AsyncCompletionHandler<Integer>(){
    		
    		@Override
		    public Integer onCompleted(Response response) throws Exception {
    			
		    	System.out.println("Request executed..");
		    	
		        EventObject eventObject = new EventObject(
		        		Event.REQUEST, 
		        		new JsonParser()
					        .parse(response.getResponseBody())
					        .getAsJsonObject());
        		
        		if(callback != null){
        			callback.onSuccess(eventObject);
        		}
        		
		        return response.getStatusCode();
    			
    		}
    		
		    @Override
		    public void onThrowable(Throwable t){
		    	System.out.println("Request error!!");
		    	System.out.println(t.getMessage());
		    	t.printStackTrace();
		    }
		    
    	});*/
    	
    	
    }
    
    //put request
    protected static void executePut(String url, String data, final IstSOSListener callback, ArrayList<String> realm) {

        //TODO: implement put request
    	/*BoundRequestBuilder builder = asyncHttpClient.preparePut(url).setBody(data);
    	
    	if(realm != null){
			Realm tmpRealm = new Realm.Builder(realm.get(0), realm.get(1))
					.setUsePreemptiveAuth(true)
					.setScheme(AuthScheme.BASIC)
					.build();
			builder.setRealm(tmpRealm);
    	}
    	
    	builder.execute(new AsyncCompletionHandler<Integer>(){
    		
    		@Override
		    public Integer onCompleted(Response response) throws Exception {
    			
		    	System.out.println("Request executed..");
		    	
		        EventObject eventObject = new EventObject(
		        		Event.REQUEST, 
		        		new JsonParser()
					        .parse(response.getResponseBody())
					        .getAsJsonObject());
        		
        		if(callback != null){
        			callback.onSuccess(eventObject);
        		}
        		
		        return response.getStatusCode();
    			
    		}
    		
		    @Override
		    public void onThrowable(Throwable t){
		    	System.out.println("Request error!!");
		    	System.out.println(t.getMessage());
		    	t.printStackTrace();
		    }
		    
    	});*/
        
    }
    
    protected static void executeDelete(String url, String data, final IstSOSListener callback, ArrayList<String> realm){

        //TODO: implement delete request
   		/*BoundRequestBuilder builder = asyncHttpClient.prepareDelete(url).setBody(data);
    	
    	if(realm != null){
			Realm tmpRealm = new Realm.Builder(realm.get(0), realm.get(1))
					.setUsePreemptiveAuth(true)
					.setScheme(AuthScheme.BASIC)
					.build();
			builder.setRealm(tmpRealm);
    	}
    	
    	builder.execute(new AsyncCompletionHandler<Integer>(){
    		
    		@Override
		    public Integer onCompleted(Response response) throws Exception {
    			
		    	System.out.println("Request executed..");
		    	
		        EventObject eventObject = new EventObject(
		        		Event.REQUEST, 
		        		new JsonParser()
					        .parse(response.getResponseBody())
					        .getAsJsonObject());
        		
        		if(callback != null){
        			callback.onSuccess(eventObject);
        		}
        		
		        return response.getStatusCode();
    			
    		}
    		
		    @Override
		    public void onThrowable(Throwable t){
		    	System.out.println("Request error!!");
		    	System.out.println(t.getMessage());
		    	t.printStackTrace();
		    }
		    
    	});*/
    	
    }

}