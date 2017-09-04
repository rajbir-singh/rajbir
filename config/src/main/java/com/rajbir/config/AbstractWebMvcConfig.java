//package com.rajbir.config;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * Created by Sony on 03-09-2017.
// */
//public abstract class AbstractWebMvcConfig extends WebMvcConfigurerAdapter {
//
////    @Resource
////    private OfbContextInterceptor ofbContextInterceptor;
////
////    @Resource
////    private AuthenticationInterceptor authenticationInterceptor;
////
////    @Resource
////    private AuthorizationInterceptor authorizationInterceptor;
////
////    @Resource
////    private UserContextInterceptor userContextInterceptor;
////
////    @Resource
////    private DeveloperAPIInterceptor developerAPIInterceptor;
////
////    @Resource
////    private MetricsInterceptor metricsInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(metricsInterceptor);
////        registry.addInterceptor(ofbContextInterceptor);
////        registry.addInterceptor(authenticationInterceptor);
////        registry.addInterceptor(authorizationInterceptor);
////        registry.addInterceptor(userContextInterceptor);
////        registry.addInterceptor(developerAPIInterceptor);
//    }
//
//    /**
//     * Without this @Value will not work
//     * {@link "http://www.baeldung.com/2012/02/06/properties-with-spring/"}
//     *
//     * @return
//     */
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
//        objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
//        objectMapper.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
//        return objectMapper;
//    }
//
//    //@Bean
//    //public static MetricsTimerAspect metricAspect(){
//    //    MetricsTimerAspect metricAspect = Aspects.aspectOf(MetricsTimerAspect.class);
//    //
//    //    return metricAspect;
//    //}
//}
