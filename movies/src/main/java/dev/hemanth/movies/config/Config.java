package dev.hemanth.movies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.hemanth.movies.service.MovieService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



@Configuration
public class Config {
//    @Bean
//    public MovieService movieService() {
//        return new MovieService();
//    }
	

	
	    @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.addAllowedOrigin("http://localhost:3001");
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("GET");
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }
	

	
}
