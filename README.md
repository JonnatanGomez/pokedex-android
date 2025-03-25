# Pokedex Android

This is a modern Android application that displays a list of Pokémon and shows detailed information for each Pokémon when selected. The project was built using modern Android development practices with Jetpack Compose for the UI, Retrofit for networking, and Hilt for dependency injection.

## Table of Contents
- [Features](#features)
- [Architecture](#architecture)
- [Dependencies](#dependencies)
- [Installation](#installation)
- [How to Run](#how-to-run)
- [Contributing](#contributing)
- [License](#license)

## Features
- **Pokémon List**: Displays a list of Pokémon (from generation 1) with images and names.
- **Pokémon Details**: Shows detailed information for each Pokémon including:
  - Name and formatted ID (e.g., #001)
  - Official artwork and home sprite image.
  - Basic stats (weight, height)
  - Detailed statistics displayed with progress bars.
  - Species information and additional description (fetched from species endpoint).
- **Search**: Allows users to search for Pokémon by name or ID.
- **Modern UI**: Built with Jetpack Compose providing a fluid and responsive interface.

## Architecture
The project follows a layered architecture:
- **Presentation Layer**: Uses Jetpack Compose to build UI components such as `PokemonListView` and `PokemonDetailView`.
- **ViewModel Layer**: Uses Android Architecture Components (`ViewModel`, `LiveData`) to manage UI-related data. Hilt is used for dependency injection.
- **Data Layer**: 
  - **Repository**: Manages data operations and combines responses from the remote API.
  - **Remote API**: Built with Retrofit to fetch data from the [PokéAPI](https://pokeapi.co).
- **Models**: Data classes represent the API responses (e.g., `GenerationResponse`, `PokemonDetailResponse`, etc.).

## Dependencies
Key dependencies used in the project:
- **Jetpack Compose**: For building the UI.
- **Retrofit**: For networking.
- **Gson**: For JSON serialization/deserialization.
- **Hilt**: For dependency injection.
- **Coil**: For image loading.
- **Kotlin Coroutines**: For asynchronous operations.

## Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/PokedexAndroid.git
   ```
2. **Open the project in Android Studio:**
    - Open Android Studio.
    - Click on "Open an existing Android Studio project" and navigate to the cloned repository folder.
3. **Sync Gradle:**
    - Once the project is open, let Gradle sync the project and download all dependencies.
4. **Configure API and Environment:**
    - The base URL for the PokéAPI is already set to `https://pokeapi.co/api/v2/`. No additional configuration is required.

## How to Run
1. **Connect an Android Device or Use an Emulator:**
    - Connect your physical Android device (ensure USB debugging is enabled) or start an Android Virtual Device (AVD) using the AVD Manager.
2. **Build and Run:**
    - Click on the "Run" button in Android Studio or use `Shift + F10` to build and run the project.
3. **Interact with the App:**
    - The app will launch displaying a list of Pokémon. Tap on any Pokémon to see its detailed information.