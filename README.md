# Pokémon PokeAPI Compose App

This project is an Android application that consumes the public [PokéAPI](https://pokeapi.co/) to display a list of Pokémon and detailed information about each one. The app is built using Kotlin, Jetpack Compose for the UI, Retrofit for networking, and Hilt for dependency injection.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Project](#running-the-project)
- [Build and Compilation](#build-and-compilation)
- [Notes and Future Improvements](#notes-and-future-improvements)
- [License](#license)

## Features

- **Pokémon List Screen:** Displays a grid/list of Pokémon from the first generation (151 Pokémon).
- **Pokémon Detail Screen:** Shows detailed information including the official artwork, basic stats (weight, height), types, description from the species endpoint, and progress indicators for stats.
- **Responsive UI:** Built using Jetpack Compose with modern UI components.
- **Navigation:** Seamless navigation between list and detail screens with a custom top bar that includes a back button and dynamic title.
- **Dependency Injection:** Managed with Hilt for better code modularity and testability.
- **Networking:** Uses Retrofit to call the PokéAPI endpoints and Gson for JSON serialization.

## Technologies Used

- **Kotlin** (1.5+)
- **Android Studio** (Arctic Fox or later)
- **Jetpack Compose** (UI Toolkit)
- **Retrofit** (HTTP Client)
- **Hilt** (Dependency Injection)
- **Coil** (Image Loading)
- **Navigation Compose** (Navigation)

## Project Structure

- **data/**
    - `remote/`
        - `api/` - Contains `PokeApiService` for API endpoints.
        - `models/` - Data classes for Pokémon list, details, species, and stats.
    - **repository/**
        - Contains `PokemonRepository` that combines API calls.
- **domain/**
    - Contains use cases (e.g., `GetPokemonDetailUseCase`) that encapsulate business logic.
- **presentation/**
    - `ui/` - Composables for screens such as `PokemonListScreen` and `PokemonDetailScreen`.
    - `component/` - Reusable UI components like `DetailTopAppBar`, `PokemonDetailContent`, etc.
    - `viewmodel/` - ViewModels (e.g., `PokemonDetailViewModel`) handling UI state and data fetching.
- **di/**
    - Hilt modules for providing Retrofit, API service, and repository dependencies.
- **res/**
    - Drawable resources (e.g., arrow icons, type icons) and themes.

## Prerequisites

- **Android Studio** installed (Arctic Fox or later is recommended).
- **JDK 11** or later.
- An Android device or emulator (API Level 21 or above recommended).

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/pokeapi-compose-app.git
   cd pokeapi-compose-app