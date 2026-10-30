package io.github.ewnolin.urd.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Entry point for the Urd web application. */
@SpringBootApplication
public class UrdApplication {

  /**
   * Starts the application.
   *
   * @param args command-line arguments passed on to Spring Boot
   */
  public static void main(String[] args) {
    SpringApplication.run(UrdApplication.class, args);
  }
}
