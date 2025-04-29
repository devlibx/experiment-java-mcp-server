package com.gox.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class WeatherMcpApplication {
  private static final Logger logger = LoggerFactory.getLogger(
    WeatherMcpApplication.class
  );

  public static void main(String[] args) {
    SpringApplication.run(WeatherMcpApplication.class, args);
    logger.info("Weather MCP Server started successfully!");
  }

  @Bean
  public ToolCallbackProvider weatherTools(WeatherService weatherService) {
    return MethodToolCallbackProvider
      .builder()
      .toolObjects(weatherService)
      .build();
  }
}

@Service
class WeatherService {

  @Tool(description = "Get weather information by city name")
  public String getWeather(String cityName) {
    return "harish";
  }
}
