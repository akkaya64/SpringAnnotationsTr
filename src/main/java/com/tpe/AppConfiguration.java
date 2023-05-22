package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration//bu classta config olacak
@ComponentScan("com.tpe")//bu packagedaki componentları tara, default: "com.tpe"
@PropertySource("classpath:application.properties")
public class AppConfiguration {
    @Autowired
    private Environment environment;

    @Bean // Random clasindan bir tane Beam olusturuluyor
    @Qualifier("bean")
    public Random random(){
        return new Random();
    }

    // @Value ile yaptiklarimizi properties clasi ilede yapabiliriz
    // degiskenlerin degerlerini yine bir dosyadan okuyabiliriz

//    @Bean
//    public Properties properties(){
//        Properties properties = new Properties();
//        properties.put("mymail", environment.getProperty("app.email"));
//        properties.put("myjavahome", environment.getProperty("JAVA_HOME"));
//        return properties;
//    }

    @Bean
    public Properties properties(){
        Properties properties = new Properties();
        properties.put("mymail", environment.getProperty("app.email"));
        properties.put("myjavahome", environment.getProperty("JAVA_HOME"));
        return properties;

    }


}
