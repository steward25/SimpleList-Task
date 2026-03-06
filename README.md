# SimpleList Android Project

A modern Android application demonstrating a multi-module architecture with shared logic, Jetpack Compose UI, and automated documentation.

## Project Structure
- `:simple-list-app`: The main Android application module using Jetpack Compose for the UI.
- `:sales-core`: A pure Kotlin library module containing the business logic and data models (SaleItem, SalesManager).

## Key Features
- **Dynamic Sales Data**: Uses a shared manager to calculate totals and generate mock data.
- **Aligned UI**: Custom Compose components ensuring vertical alignment of currency symbols.
- **Automated Docs**: Integrated with Dokka to generate HTML documentation for the core logic.

## Getting Started
### Prerequisites
- Android Studio Ladybug (or newer)
- JDK 17+
- Gradle 8.10+

### How to Run
1. Clone the repository.
2. Sync the project with Gradle files.
3. Run the `:simple-list-app` module on an emulator or physical device.

## Documentation
