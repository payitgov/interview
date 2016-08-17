# README #

This little guide should enable you to get cracking.

### Instructions ###

* This little app contains the REST interface for the beginnings of a blog platform.
* It only has one REST endpoint at the path /posts
* This endpoint enables CRUD operations on blog posts.
* Your job will be to add the capability to record comments on blog posts.

### Notes ###
* To run the build type (on unix) `./gradlew clean build` or (on windows) `gradlew.bat clean build`
* This application requires Java 8
* You can also run the app using `./gradlew run`
* Use the appropriate gradle tasks to generate the project files for your IDE of choice.
https://docs.gradle.org/current/userguide/idea_plugin.html
or
https://docs.gradle.org/current/userguide/eclipse_plugin.html
* For example `./gradlew cleanIdea idea`
