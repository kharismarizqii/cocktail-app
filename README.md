# Cocktail App
This project is a mini-copy of [TheCocktailDB](https://www.thecocktaildb.com/api.php). Main features of this application are List Cocktail, Detail Cocktail and Filter.

<p align="center">
  <a href="https://drive.google.com/drive/folders/1QNM-PExi_p3afHzwFWkOSShPzD-sRIRK?usp=sharing"><img src="https://img.shields.io/badge/DOWNLOAD%20APK-v1.0-brightgreen" alt="Cocktail-App"/></a> 
  <br/>
  <br/>
  <a href="https://kotlinlang.org/"><img src="https://img.shields.io/badge/kotlin-v1.5.10-blue" alt="kotlin"/></a>
  <a href="https://gradle.org/"><img src="https://img.shields.io/badge/gradle-v7.0.0-green" alt="gradle"/></a>
  <a href="https://developer.android.com/studio/"><img src="https://img.shields.io/badge/android%20studio-v4.2.1-blue" alt="android-studio"></a>
  <a href="https://material.io/develop/android"><img src="https://img.shields.io/badge/material-v1.4.0-lightgrey" alt="material-design"></a>
  <a href="https://square.github.io/okhttp/4.x/okhttp/okhttp3/"><img src="https://img.shields.io/badge/okhttp3-v4.9.0-green" alt="okhttp3"></a>
  <a href="https://square.github.io/retrofit/"><img src="https://img.shields.io/badge/retrofit2-v2.9.0-brightgreen" alt="retrofit2"></a>
  <a href="https://developer.android.com/kotlin/coroutines"><img src="https://img.shields.io/badge/coroutines-v1.4.3-blue" alt="coroutines"/></a>
  <a href="https://github.com/google/dagger"><img src="https://img.shields.io/badge/dagger2-v2.38.1-yellow" alt="dagger2"/></a>
  <a href="https://github.com/ajalt/timberkt"><img src="https://img.shields.io/badge/timber-v1.5.1-orange" alt="timber"/></a>
  <a href="https://mockk.io/"><img src="https://img.shields.io/badge/mockk-v1.12.0-blue" alt="mockk"/></a>
</p>

### Features
- List Cocktail Page:
  - Search by Name
  - Filter
  - Clickable data item
  - Loading State
- Detail Cocktail Page
- Filter Dialog

### Tech Stack
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- [Dagger2](https://github.com/google/dagger) - for dependency injection.
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - Construct the REST APIs.
- Jetpack
  - ViewModel - Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
  - ViewBinding - Generates a binding class for each XML layout file that allows you to more easily write code that interacts with views.
  - LiveData - A lifecycle-aware observable data holder class.
- [MockK](https://github.com/mockk/mockk) and JUnit - for unit testing.
- [timberkt](https://github.com/ajalt/timberkt) - An easy Android logging with Kotlin and Timber.
- [Glide](https://github.com/bumptech/glide) - Loading images from network.

## Architecture
Currency Converter is based on the MVVM architecture and the Repository pattern.

![architecture](https://user-images.githubusercontent.com/24237865/77502018-f7d36000-6e9c-11ea-92b0-1097240c8689.png)

# License
```xml
The MIT License (MIT)

Copyright (c) 2017 skydoves

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```


