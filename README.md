# istSOS Android Demo

## About 
This is a showcase demonstrating how the istSOS Java-Core library can be used to build android applications.

If you want to learn more about the istSOS Java-Core go to the [Github repo](https://github.com/masterflorin/java-core).

## Features

* Supports core functionality of the istSOS through Java core.
* Uses [Android Asynchronous Http Client](http://loopj.com/android-async-http/) library for handling requests
* Uses [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart) for displaying Observation data
* Compatible with Android API level 21 and above

## Installation

Currently, there are two parts to this.

First, it is recommended that you import the `Java core` as a module into an Android project.

To achieve that you can:

1. Clone the repo
2. Import it via the `Android Studio` as a module

`Java Core` is a Gradle-based project so compatibility with Android won't be a problem.

Second, for the moment you have to modify the `istSOS` class request methods so that it
uses the Android-Async library instead of the AsyncHttp Library which will not work.

Check the `IstSOS.java` in this repo to see how it was done.
 
<b>Note:</b> It will moved to another repository after the GSoC in order to solve this
issue. So far, that was the only solution found.


## Documentation

You can check the following [tutorial](https://github.com/masterflorin/android-demo/blob/master/TUTORIAL.md) to get your feet wet on developing an
Android app using the Java core.

If you want to check out the Java core documentation, have a look [here](https://github.com/masterflorin/java-core/blob/master/UserGuide.md)

## Author

Florin-Daniel Cioloboc ([@florincioloboc](https://twitter.com/florincioloboc)) implemented during Google Summer of Code 2016.

Mentors from istSOS: Mirko Cardoso, Milan Antonovic.

## Release history

* Last updated: 20.08.2016

## Useful links

* istSOS [website](http://istsos.org/)
* istSOS [mailing list](https://groups.google.com/forum/#!forum/istsos)
* GSoC development log on [OSGeo wiki](https://wiki.osgeo.org/wiki/Android_istSOS)