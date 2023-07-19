package com.abcd

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.config.WebFluxConfigurerComposite

private const val DEFAULT_MAX_MEMORY_SIZE = 256000

@SpringBootApplication
class Application {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(com.abcd.Application::class.java, *args)
        }
    }

    @Bean
    fun corsConfigurer(): WebFluxConfigurer {
        return object : WebFluxConfigurerComposite() {

            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**").allowedOrigins("*")
                    .allowedMethods("*")
            }
        }
    }

    @Bean
    fun maxInMemorySizeConfigurer(): WebFluxConfigurer {
        return object : WebFluxConfigurerComposite() {
            override fun configureHttpMessageCodecs(configurer: ServerCodecConfigurer) {
                configurer.defaultCodecs().maxInMemorySize(com.abcd.DEFAULT_MAX_MEMORY_SIZE * 4)
            }
        }
    }
}
