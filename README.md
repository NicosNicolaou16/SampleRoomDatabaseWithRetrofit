This is a sample project that uses room database with retrofit to present list of data on a recycler
view using data binding. <br />
[Click here and check the branch updateToHilt,it is migration of the project with Hilt Dependency Injection](https://github.com/NicosNicolaou16/SampleRoomDatabaseWithRetrofit/tree/updateToHilt)

# The Project Contain the following technologies

The programming language is the [Kotlin](https://kotlinlang.org/docs/getting-started.html), it is a
modern, JVM-based programming language that is concise, safe, and interoperable with Java. <br />
[Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) is used for asynchronous
tasks. <br />
[Kotlin KTX](https://developer.android.com/kotlin/ktx) is a collection of Kotlin extensions that
offer more concise and expressive code for working with Android APIs and libraries.
[Room Database](https://developer.android.com/training/data-storage/room) is responsible for saving
the retrieved data from the remote server, querying data from the local database, and supporting
offline functionality.  <br />
[Retrofit](https://square.github.io/retrofit/) is responsible for making requests and retrieving data from the remote server. ([Repository](https://github.com/square/retrofit)) <br />
[Data Binding](https://developer.android.com/topic/libraries/data-binding) in Android lets you link
UI components to data directly in the XML layout. It automatically updates the UI when the data
changes, reducing the need for manual coding and making the app easier to maintain. <br />
[View Binding](https://developer.android.com/topic/libraries/view-binding) in Android is a feature
that automatically generates a binding class for each layout, providing direct access to the views
without using `findViewById()`. It ensures safer, type-checked code by reducing the risk of errors
like `NullPointerException`, making the code simpler and more maintainable. <br />
Navigation <br />
Live Data <br />
MVVM <br />
Support kapt and ksp (ksp only setup for Room Database) <br />
minifyEnabled, shrinkResources, R8 are enabled <br />

# Feeds/Urls/End Point (parsing some data from the response)

## (Links References for Ends Points)

https://github.com/r-spacex/SpaceX-API (GitHub) <br />
https://docs.spacexdata.com/?version=latest (Postman) <br />

Target SDK version: 35 <br />
Minimum SDK version: 28 <br />
Kotlin version: 2.0.21 <br />
Gradle version: 8.7.2 <br />