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
some of its features use Java 8 which are not compatible for the current state of Android. 
Although, this will probably be fixed in the near future.

Even during development, it has not been tested for API level lower than 21 (5.0 Lollipop) therefore
there is no guarantee that it will work. The point is anything >= 21 API level will work fine. 

All in all, for the sake of keeping the Java Core as a library for Java development about yet still flexible
enough for developing for Android it had to be done in this way. 

## Launching the IstSOS instance

This is very important, when initializing IstSOS you should do it only once and it
should take place in the `MainActivity` of your app. If you keep that mind then you will already
avoid some of the possible problems you could have had.

```java

    IstSOS sos = IstSOS.getInstance();

```

Instead you can get the IstSOS instance by using the `getInstance` method, followed by `getServer` with
the name of the server.

```java

    final Server server = IstSOS.getInstance().getServer("localhost");


```

This way you will avoid initializing an `IstSOS` instance and the server because you intend to work
with the same server and data. You can do it in the MainActivity, and from there on you can apply
what you learned now.

Also, as `Server` shouldn't change during execution of requests, it should have the `final` modifier
because the requests are generally nested. Either way if you are working with an IDE, 
it will probably add it.

## Working with services

Now comes a pretty interesting part. 
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
 
             ArrayList<Service> servicesLoadedInApp = (ArrayList<Service>)server.getServices();

          }
 
          @Override
          public void onError(EventObject event) {
 
          }
     });
    
```

Notice that we used an `ArrayList` to store the services as you might have more than one.

## Recommended way to use a service

When working with `Service`, you have to keep in mind that it is one of the most important things for
handling your istSOS requests. You need to use the same service if you want to request observations.

The trick is to use `getService` on the `Server` instance as you might have know that a Server hosts 
a list of services available.

Inside the `loadServices` method you can initialize a `Service` object the same way you did with
a `Server`. Surprised? Either way, this will make things easier as you won't have to request the
services over and over again when you want to use the same one. 

Take notice that you can replace the name with a variable that takes the input from an EditText
or something. 

```java

     server.loadServices(new IstSOSListener() {
          @Override
          public void onSuccess(EventObject event) {
 
             ArrayList<Service> servicesLoadedInApp = (ArrayList<Service>)server.getServices();
             
             Service service = server.getService("demo");


          }
 
          @Override
          public void onError(EventObject event) {
 
          }
     });
    
```

Obviously, in Android you can transfer the name of the service between activities through various
ways. You can check the source of this repo where I used intents to accomplish that.

From now on, you can pretty much use the rest of the methods the same way you did as now. If you
starting with Android directly, I would suggest taking a look at the [`Java Core`] (https://github.com/masterflorin/java-core/blob/master/UserGuide.md) documentation 
for references.

## Displaying data

The suggestion from istSOS is that you display the Observation related data using MPAndroidChart.

I attempted it a couple of times but I had some issues with parsing the data into the proper format
required by the charts and as Google Summer of Code was limited time-wise I didn't managed to solve that.