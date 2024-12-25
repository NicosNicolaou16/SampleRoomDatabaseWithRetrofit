# Sample Room Database With Retrofit

This is a sample project that uses Room database with Retrofit to display a list of data in a
RecyclerView using data binding. <br />

# The Project Contain the following technologies

The programming language is the [Kotlin](https://kotlinlang.org/docs/getting-started.html), it is a
modern, JVM-based programming language that is concise, safe, and interoperable with Java. <br />
[Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) is used for asynchronous
tasks. <br />
[Kotlin KTX](https://developer.android.com/kotlin/ktx) is a collection of Kotlin extensions that
offer more concise and expressive code for working with Android APIs and libraries. <br />
[Room Database](https://developer.android.com/training/data-storage/room) is responsible for saving
the retrieved data from the remote server, querying data from the local database, and supporting
offline functionality.  <br />
[Retrofit](https://square.github.io/retrofit/) is responsible for making requests and retrieving
data from the remote server. ([Repository](https://github.com/square/retrofit)) <br />
[Data Binding](https://developer.android.com/topic/libraries/data-binding) in Android lets you link
UI components to data directly in the XML layout. It automatically updates the UI when the data
changes, reducing the need for manual coding and making the app easier to maintain. <br />
[View Binding](https://developer.android.com/topic/libraries/view-binding) in Android is a feature
that automatically generates a binding class for each layout, providing direct access to the views
without using `findViewById()`. It ensures safer, type-checked code by reducing the risk of errors
like `NullPointerException`, making the code simpler and more maintainable. <br />
[Navigation](https://developer.android.com/guide/navigation) in Android manages how users move
between screens. The Navigation Component simplifies this by using a navigation graph to define and
handle navigation paths, back stack management, and data passing between screens. <br />
[Live Data](https://developer.android.com/topic/libraries/architecture/livedata) in Android is a
lifecycle-aware data holder that allows UI components to observe data changes. It automatically
updates the UI when data changes, ensuring updates occur only when the component is in an active
lifecycle state, preventing memory leaks and crashes. <br />
[MVVM](https://developer.android.com/topic/architecture#recommended-app-arch) with repository is an
architecture where the Repository manages data sources (e.g., network, database), the ViewModel
processes the data for the UI, and the View displays the UI, ensuring a clear separation of
concerns. <br />
[Hilt Dependencies Injection](https://developer.android.com/training/dependency-injection/hilt-android)
is an Android library that simplifies dependency injection by using annotations to automatically
manage and provide dependencies across components, built on top of
Dagger. ([Documentation](https://dagger.dev/hilt/)) <br />
[KSP](https://developer.android.com/build/migrate-to-ksp) ("Kotlin Symbol Processing") is a tool for
efficient annotation processing in Kotlin, providing faster code generation and symbol manipulation
compared to KAPT. <br />
[R8](https://developer.android.com/build/shrink-code) enabled, is a code shrinker and obfuscator for
Android that optimizes and reduces the size of APKs by removing unused code and resources, while
also obfuscating the remaining code to improve security. <br />

# Versioning

Target SDK version: 35 <br />
Minimum SDK version: 28 <br />
Kotlin version: 2.1.0 <br />
Gradle version: 8.7.3 <br />

# Feeds/Urls/End Point (parsing some data from the response)

## (Links References for Ends Points)

https://github.com/r-spacex/SpaceX-API (GitHub) <br />
https://docs.spacexdata.com/?version=latest (Postman) <br />