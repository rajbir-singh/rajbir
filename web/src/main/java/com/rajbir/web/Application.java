/**
 * Created by Sony on 30-08-2017.
 */

package com.rajbir.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
@PropertySource("classpath:boneCp.properties")
public class Application {

    @Autowired
    Environment env;

    @Value("${bonecp.driverClass}")
    String driverClass;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            //print all classpaths, jdk's jars, maven repo's jars, project's target folder (containing class files)
//            ClassLoader cl = ClassLoader.getSystemClassLoader();
//
//            URL[] urls = ((URLClassLoader)cl).getURLs();
//
//            for(URL url: urls){
//                System.out.println(url.getFile());
//            }


            System.out.println("Testing env");
            System.out.println(driverClass);
            System.out.println(env.getProperty("bonecp.driverClass"));


            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
