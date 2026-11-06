package com.example.vehicleservice.config;
import org.springframework.context.annotation.*; import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
@Configuration public class AppConfig { @Bean public ConcurrentMapCacheManager cacheManager(){return new ConcurrentMapCacheManager("serviceHistory");} }
