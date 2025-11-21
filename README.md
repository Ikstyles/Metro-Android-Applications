🚇 Find My Metro App

Android Metro Navigation System | Java • XML • MySQL • Google Maps API • Dijkstra’s Algorithm

Find My Metro App is a feature-rich Android application designed to simplify metro travel by providing accurate route planning, fare estimation, and nearby station detection. The app focuses on delivering a smooth and reliable user experience through efficient algorithms, a structured database, and clean UI design. All user and station data is managed using a MySQL database, ensuring fast and consistent data handling throughout the application.

📌 Key Features
🔹 Smart Route Finder

Calculates the shortest and most efficient route between any two stations.

Uses Dijkstra’s Algorithm to ensure accurate path selection.

Displays intermediate stations and total travel steps.

🔹 Fare & Time Estimation

Computes estimated travel fare based on the chosen route.

Provides approximate travel duration to help users plan better.

🔹 Nearby Stations Detection

Utilizes Google Maps API and device GPS to show 5–10 metro stations near the user's current location.

Displays station names and distances for quick access.

🔹 User Authentication

Supports secure login and signup functionality.

Stores user credentials and details in MySQL using a structured local database connection.

🔹 Modern UI Design

Clean and intuitive interface built with XML layouts and Material Design guidelines.

Simple navigation flow for effortless user interaction.

🏗️ Technical Architecture
📱 Frontend (Android)

Developed using Java with XML-based UI layouts.

Follows a modular structure separating route logic, user data, and UI components.

🗄️ Backend (MySQL Database)

Stores station list, route connections, and user information.

Ensures controlled and consistent data handling without external dependencies.

Uses optimized queries for faster route and station retrieval.

🧠 Route Calculation Engine

Based on Dijkstra’s Algorithm for shortest path computation.

Each station is treated as a node; connections between stations act as weighted edges.

Guarantees accurate and optimized route suggestions.

🌍 Location Services

Integrates Google Maps API to fetch the user’s live GPS coordinates.

Identifies and displays nearby metro stations on the map.

🔧 How It Works

User Login

User creates an account or logs in through the authentication screen.

Select Source & Destination

User picks starting and ending stations from dropdown menus.

Processing Route

System applies Dijkstra’s Algorithm on predefined station data.

Displaying Results

App shows the best route, travel duration, fare, and station sequence.

Finding Nearby Stations

User can see nearby metro stations based on their GPS location.

📂 Project Structure Overview
FindMyMetro/
│── app/src/main/java/
│   ├── RouteFinder/         # Dijkstra logic, station graph
│   ├── Auth/                # Login & signup
│   ├── NearbyStations/      # Maps & GPS integration
│   ├── Database/            # MySQL connection & queries
│   └── UI/                  # Activities, layouts, adapters
│
│── app/src/main/res/        # XML layouts, drawable assets, colors, animations
│── MySQL/                   # Tables, sample data, schema
│── README.md                # Project documentation

🔍 Core Highlights

Combines three essential metro tools into one app: route planning, fare calculation, and station locator.

Implements graph-based routing for accurate travel suggestions.

Uses structured MySQL storage instead of cloud services for direct and controlled data management.

Designed with simplicity, performance, and reliability as priorities.

Demonstrates strong Android development skills along with algorithmic problem-solving.

🚀 Setup & Installation
Requirements

Android Studio (latest version)

MySQL Server installed locally

Google Maps API key

Steps

Clone the repository

Import the project into Android Studio

Import the provided MySQL tables

Update database credentials in the app

Add your Google Maps API key

Build and run the application

📈 Future Enhancements

Real-time metro schedules

Smart route suggestions based on traffic/load

Multi-language interface (English + Hindi)

Notification alerts for delays or station closings

Favorite routes and saved travel history

📞 Contact

If you would like to suggest improvements or contribute, feel free to open an issue or create a pull request.
