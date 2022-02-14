package com.wf2311.jclipper.spring.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author <a href="mailto:wf2311@163.com">wf2311</a>
 * @since 2021/6/8 15:39.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class JclipperWebappApplication {
    public static void main(String[] args) {
        SpringApplication.run(JclipperWebappApplication.class, args);
    }
}
