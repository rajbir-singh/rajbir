/**
 * Created by Sony on 30-08-2017.
 */

package com.rajbir.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(value = {"com.rajbir.*"})

//update web's pom to include "config module" as dependency if you want to use porperties file from "config module"
//@PropertySource("classpath:boneCp.properties")
public class Application {

    @Autowired
    Environment env;

    //update web's pom to include "config module" as dependency if you want to use porperties file from "config module"
//    @Value("${bonecp.driverClass}")
//    String driverClass;

    public static void main(String[] args) {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "live");
        SpringApplication.run(Application.class, args);q
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            //get spring version
            System.out.println("spring version: " + SpringVersion.getVersion());

            //print all classpaths, jdk's jars, maven repo's jars, project's target folder (containing class files)
            System.out.println("system classpath");
            System.getProperty("java.classpath");
//            ClassLoader cl = ClassLoader.getSystemClassLoader();
//
//            URL[] urls = ((URLClassLoader)cl).getURLs();
//
//            for(URL url: urls){
//                System.out.println(url.getFile());
//            }


//            System.out.println("Testing env");
//            System.out.println(driverClass);
//            System.out.println(env.getProperty("bonecp.driverClass"));
//
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }

        };
    }

}
