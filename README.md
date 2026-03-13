# Sample Room Database With Retrofit

[![Linktree](https://img.shields.io/badge/linktree-1de9b6?style=for-the-badge&logo=linktree&logoColor=white)](https://linktr.ee/nicos_nicolaou)
[![Site](https://img.shields.io/badge/Site-blue?style=for-the-badge&label=Web)](https://nicosnicolaou16.github.io/)
[![X](https://img.shields.io/badge/X-%23000000.svg?style=for-the-badge&logo=X&logoColor=white)](https://twitter.com/nicolaou_nicos)
[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/nicos-nicolaou-a16720aa)
[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@nicosnicolaou)
[![Mastodon](https://img.shields.io/badge/-MASTODON-%232B90D9?style=for-the-badge&logo=mastodon&logoColor=white)](https://androiddev.social/@nicolaou_nicos)
[![Bluesky](https://img.shields.io/badge/Bluesky-0285FF?style=for-the-badge&logo=Bluesky&logoColor=white)](https://bsky.app/profile/nicolaounicos.bsky.social)
[![Dev.to blog](https://img.shields.io/badge/dev.to-0A0A0A?style=for-the-badge&logo=dev.to&logoColor=white)](https://dev.to/nicosnicolaou16)
[![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)](https://www.youtube.com/@nicosnicolaou16)
[![Google Developer Profile](https://img.shields.io/badge/Developer_Profile-blue?style=for-the-badge&label=Google)](https://g.dev/nicolaou_nicos)

A sample Android project demonstrating the integration of **Room Database** with **Retrofit**. This app fetches data from a remote API and displays it in a RecyclerView, showcasing best practices for offline caching and data persistence.

> [!TIP]  
> Looking for a Hilt implementation?  
> 👉 **[Check out the updateToHilt branch](https://github.com/NicosNicolaou16/SampleRoomDatabaseWithRetrofit/tree/updateToHilt)** 👈

## ✨ Features

* **Offline Support:** Caches retrieved data in a local **Room Database**, allowing the app to function without an active internet connection.
* **Efficient Networking:** Uses **Retrofit** to fetch and parse data from remote endpoints seamlessly.
* **Responsive UI:** Implements **Data Binding** and **View Binding** to reduce boilerplate and ensure type-safe view access.
* **Architecture:** Built on the **MVVM** pattern with a Repository to ensure a clean separation of concerns.
* **Reactive Data:** Utilizes **LiveData** to observe data changes and automatically update the UI based on the lifecycle.
* **Optimized Performance:** Uses **Coroutines** for background tasks and **R8** for code shrinking and optimization.

## 🛠️ Tech Stack & Libraries

This project is built with **[Kotlin](https://kotlinlang.org/docs/getting-started.html)** and utilizes the following tools:

- **UI & Layout:** [Data Binding](https://developer.android.com/topic/libraries/data-binding), [View Binding](https://developer.android.com/topic/libraries/view-binding), [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
- **Architecture:** [MVVM](https://developer.android.com/topic/architecture#recommended-app-arch), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- **Asynchronicity:** [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html), [Kotlin KTX](https://developer.android.com/kotlin/ktx)
- **Data Persistence:** [Room](https://developer.android.com/training/data-storage/room) (SQLite abstraction)
- **Networking:** [Retrofit](https://square.github.io/retrofit/)
- **Navigation:** [Jetpack Navigation Component](https://developer.android.com/guide/navigation)
- **Build & Optimization:** [KSP](https://developer.android.com/build/migrate-to-ksp), [R8](https://developer.android.com/build/shrink-code)

## 🔧 Versioning

- **Target SDK:** **36**
- **Minimum SDK:** **29**
- **Kotlin Version:** **2.3.10**
- **Gradle Version:** **9.1.0**

## 📚 APIs & References

### Data Sources
This project is configured to parse data from the following endpoints:
- **SpaceX API:** [GitHub Repo](https://github.com/r-spacex/SpaceX-API)
- **API Documentation:** [Postman Docs](https://docs.spacexdata.com/?version=latest)

### Key Documentation
- **Room Persistence:** [Android Developers Guide](https://developer.android.com/training/data-storage/room)
- **Retrofit Guide:** [Square Open Source](https://square.github.io/retrofit/)

## ⭐ Stargazers

If you find this sample helpful, please give it a star!
Check out all the stargazers here: [Stargazers on GitHub](https://github.com/NicosNicolaou16/SampleRoomDatabaseWithRetrofit/stargazers)

## 🙏 Support & Contributions

This project is actively maintained. Feedback, bug reports, and feature requests are welcome! Please feel free to **open an issue** or submit a **pull request**.