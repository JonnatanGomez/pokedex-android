# Pokedex Android

This is a modern Android application that displays a list of Pokémon and shows detailed information for each Pokémon when selected. The project was built using modern Android development practices with Jetpack Compose for the UI, Retrofit for networking, and Hilt for dependency injection.

## Table of Contents
- [Features](#features)
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
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
  - Species information and additional description (fetched from the species endpoint).
- **Search Functionality**: Allows users to search for Pokémon by name or ID.
- **Modern UI**: Built with Jetpack Compose for a fluid and responsive interface.

## Architecture
The project follows a layered architecture:
- **Presentation Layer**: Uses Jetpack Compose to build UI components such as `PokemonListView` and `PokemonDetailView`.
- **ViewModel Layer**: Utilizes Android Architecture Components (`ViewModel`, `LiveData`) to manage UI-related data. Hilt is used for dependency injection.
- **Data Layer**:
  - **Repository**: Manages data operations and combines responses from the remote API.
  - **Remote API**: Built with Retrofit to fetch data from the [PokéAPI](https://pokeapi.co).
- **Models**: Data classes represent the API responses (e.g., `GenerationResponse`, `PokemonDetailResponse`, etc.).

## Technologies Used
- **Kotlin**: The primary programming language.
- **Jetpack Compose**: For building a modern declarative UI.
- **Retrofit**: For network requests.
- **Gson**: For JSON parsing.
- **Hilt**: For dependency injection.
- **Coil**: For efficient image loading.
- **Coroutines**: For asynchronous programming.

## Project Structure
The project is organized into several packages:
- **data**: Contains network models and API service classes.
  - `remote.models`: Data classes for API responses.
  - `remote.api`: Interface for the Retrofit service.
- **repository**: Contains repository classes that abstract data sources.
- **domain**: Contains use cases that encapsulate business logic.
- **presentation**: Contains UI components and ViewModels.
  - `ui`: Composable screens and UI elements.
  - `viewmodel`: ViewModel classes that manage UI state.
- **di**: Dependency injection configuration using Hilt.

## Prerequisites
Before building the project, ensure you have the following installed:
- **Android Studio**: Version 4.0 or higher is recommended.
- **JDK**: Java Development Kit 8 or above.
- **Gradle**: Gradle 6.x or above (automatically managed by Android Studio).

## Dependencies
Key dependencies used in the project include:
- **Jetpack Compose**: For UI development.
- **Retrofit & Gson**: For handling network operations and JSON conversion.
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
    - Once the project is open, let Gradle sync the project and download all required dependencies.
4. **Configure API and Environment:**
    - The base URL for the PokéAPI is set to `https://pokeapi.co/api/v2/`. No additional configuration is required.

## How to Run
1. **Connect an Android Device or Use an Emulator:**
    - Connect your physical Android device (ensure USB debugging is enabled) or start an Android Virtual Device (AVD) using the AVD Manager.
2. **Build and Run:**
    - Click the "Run" button in Android Studio or use the shortcut `Shift + F10` to build and run the project.
3. **Interact with the App:**
    - The app will launch displaying a list of Pokémon. Tap on any Pokémon to view its detailed information.

## Contributing
Contributions are welcome! Feel free to open issues or pull requests with improvements and bug fixes.
