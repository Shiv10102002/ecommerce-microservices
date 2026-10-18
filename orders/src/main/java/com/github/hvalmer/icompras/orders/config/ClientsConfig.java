package com.github.hvalmer.icompras.orders.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.github.hvalmer.icompras.orders.client")
public class ClientsConfig {
}
