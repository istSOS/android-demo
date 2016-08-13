# Android Demo Tutorial

## About

This brief tutorial was developed to give you an idea on how to develop your own
customized istSOS Android app.

## Some thoughts

First of all, you should have the UserGuide for the Java core at your disposal in order
to check how to integrate certain functionality into your app.

Hopefully, you followed the INSTALLATION document closely. Here you can read some of the
considerations that were taken during the development and this will shed more light on
why you had to perform all of those changes.

As a fact, the library has backwards compatibility for Java 7 even though the Java Core
was initially developed for Java 8. In order to achieve that, the library adapted for
Android development uses AndroidAsyncHttp library instead of the original AsyncHTTPClient because
it uses many features native to java 8 which are not compatible for Android. 

Even during development, it has not been tested for API level lower than 21 (5.0 Lollipop) therefore
there is no guarantee that it will work. However, anything >= 21 API level will work fine.

All in all, for the sake of keeping the Java Core as a library for Java development about yet still flexible
enough for developing for Android it had to be done in this way. 

## Launching the IstSOS instance

This is very important, when initializing IstSOS you should do it only once and it
should take place in the `MainActivity` of your app. If you keep that mind then you will already
avoid some of the possible problems you could have had.

```java

    IstSOS sos = IstSOS.getInstance();

```

Instead you can get the IstSOS instance by using the `getInstance` method, followed by `getServer`

```java

    final Server server = IstSOS.getInstance().getServer("localhost");


```

This way you will avoid initializing an IstSOS instance and a server that should be done in the
MainActivity. From there on you can just get their reference by simply using those two methods
outlined above in the example.

Also, as `Server` shouldn't change during execution of requests, it should have the `final` modifier.
Either you add or your smart IDE will ask for it, either way you'll need it.

## Working with services

Below is a very simple example where after initializing a `Server` you load the services available
on the server and store them in an ArrayList that you previously declared somewhere in your method
or class.

In this case, you should take note that the `Server` object can store multiple object types including
the list of available services, procedures, offerings, data qualities etc. 

All you have to remember is that there is a method for getting the object out of them and assigning it
to another data structure that you plan to use. For more details about it, check the Java core UserGuide.

```java

     server.loadServices(new IstSOSListener() {
          @Override
          public void onSuccess(EventObject event) {
 
             servicesLoadedInApp = (ArrayList<Service>)server.getServices();

          }
 
          @Override
          public void onError(EventObject event) {
 
          }
     });
    
```

## Displaying data

The suggestion from istSOS is that you display the Observation related data using MPAndroidChart.

On top of that you can see an example of an implementation which will certainly make your life
easier.