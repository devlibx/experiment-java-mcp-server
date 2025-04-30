# Weather MCP Server

A Spring Boot application that provides weather information through the Model Context Protocol (MCP). This project demonstrates how to create an MCP server using Spring AI to expose weather data as a tool that can be used by AI assistants.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Using the MCP Inspector](#using-the-mcp-inspector)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## 🔍 Overview

This project implements a weather service that provides mock weather data for different locations. It exposes this functionality through the Model Context Protocol (MCP), allowing AI assistants to retrieve weather information for specified locations.

## ✨ Features

- Get current weather information for any location
- Mock weather data generation with realistic parameters
- MCP integration for AI assistant compatibility
- Spring Boot application with easy setup and configuration

## 🛠️ Technologies

- Java 17
- Spring Boot 3.2.0
- Spring AI MCP Server
- Maven
- Lombok

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── gox/
│   │           └── weather/
│   │               ├── WeatherMcpApplication.java    # Main application class
│   │               ├── model/
│   │               │   └── WeatherData.java          # Weather data model
│   │               └── service/
│   │                   └── WeatherService.java       # Weather service with MCP tool
│   └── resources/
│       └── application.properties                    # Application configuration
```

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Node.js and npm (for MCP Inspector)

## 🚀 Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/weather-mcp-java.git
   cd weather-mcp-java
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

## 🏃‍♂️ Running the Application

Start the Spring Boot application:

```bash
mvn spring-boot:run
```

The application will start on port 8080 by default (configurable in `application.properties`).

## ⚙️ Configuring MCP in IDE Tools

To use this MCP server with AI assistants in IDE tools like Cursor or Cline:

1. Open your IDE's settings for AI assistant configuration
2. Look for MCP or Model Context Protocol settings
3. Add a new MCP server with the following SSE endpoint:
   ```
   http://localhost:8089/sse
   ```
4. Save the settings and restart the AI assistant if necessary
5. The weather tool should now be available to your AI assistant

Note: Make sure the port (8089) matches the port configured in your `application.properties` file.

## 🔧 Using the MCP Inspector

The MCP Inspector is a tool that allows you to test and debug your MCP server. To use it:

1. Install and run the MCP Inspector:
   ```bash
   npx @modelcontextprotocol/inspector
   ```

2. Open the MCP Inspector in your browser:
   ```
   http://127.0.0.1:6274/#tools
   ```

3. Connect to your MCP server by entering the SSE endpoint:
   ```
   http://localhost:8080/mcp/sse
   ```

   Note: The port (8080) should match the port your Spring Boot application is running on.

4. Once connected, you can test the `getWeather` tool by providing a location parameter.

## 📚 API Documentation

### Weather Service

The Weather Service provides the following functionality:

#### Get Weather

Returns weather information for a specified location.

**Tool Name**: `getWeather`

**Parameters**:
- `location` (String): The name of the location to get weather for (e.g., "New York", "London", "Tokyo")

**Response**:
```json
{
  "location": "New York",
  "temperature": 22.5,
  "condition": "Partly Cloudy",
  "humidity": 65,
  "windSpeed": 12.3
}
```

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.
