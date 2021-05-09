package com.example.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;

@SpringBootApplication
@EnableEurekaClient
public class CloudGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudGatewayApplication.class, args);
  }

	@Bean
	public ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory(
        final CircuitBreakerRegistry circuitBreakerRegistry, final TimeLimiterRegistry timeLimiterRegistry) {
    ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory = new ReactiveResilience4JCircuitBreakerFactory();
		reactiveResilience4JCircuitBreakerFactory.configureCircuitBreakerRegistry(circuitBreakerRegistry);
		reactiveResilience4JCircuitBreakerFactory.configureDefault(id -> {
			CircuitBreakerConfig circuitBreakerConfig =circuitBreakerRegistry.find(id).isPresent()
          ? circuitBreakerRegistry.find(id).get().getCircuitBreakerConfig()
					: circuitBreakerRegistry.getDefaultConfig();
			TimeLimiterConfig timeLimiterConfig = timeLimiterRegistry.find(id).isPresent()
          ? timeLimiterRegistry.find(id).get().getTimeLimiterConfig()
					: timeLimiterRegistry.getDefaultConfig();

			return new Resilience4JConfigBuilder(id)
					.circuitBreakerConfig(circuitBreakerConfig)
					.timeLimiterConfig(timeLimiterConfig)
					.build();
		});
		return reactiveResilience4JCircuitBreakerFactory;
	}

}
