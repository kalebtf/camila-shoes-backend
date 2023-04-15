package com.shoes.camila.configuration;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Configuration {

    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .region(Region.US_WEST_2) // Change this to your desired region
                .build();
    }
}
