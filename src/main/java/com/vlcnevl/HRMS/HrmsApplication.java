package com.vlcnevl.HRMS;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HrmsApplication.class, args);
		
/*		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dx7wc9sqh",
				"api_key", "372562346743541",
				"api_secret", "vKOSyjUvDG2uD79MAMYNADyN84c",
				"secure", true));
	
		File file = new File("image.jpg");
		
		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());*/
	}

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.vlcnevl.HRMS"))                                       
          .build();                                           
    }
	
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
	
}
