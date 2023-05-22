package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;
import java.util.Random;


@Component("smsservice")
public class SmsService implements MessageService {
    @PostConstruct
    public void init() {
        System.out.println("Creating sms object");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("sms bean object has being destroyed");
    }

    @Autowired
    private Random random;

    @Override
    public void sendMessage(Message message) {
        System.out.println("This message from SMS Service. Your Message is: " + message.getMessage());
        System.out.println("Random Number: " + random.nextInt(100));
    }

    @Override
    public void saveMessage(Message message) {
    }

    @Value("${app.email}")
    private  String email;
    @Value("${app.phone}")
    private  String phone;
    public void printContact(){
//        System.out.println("email: email@email.com");
//        System.out.println("phone number: 00987654343");
        System.out.println("email: " + email + ", phone: " + phone);
    }

//    @Autowired
//    private Properties properties;
//    public void printProperties(){
//        System.out.println("contact email :"+properties.get("mymail"));
//        System.out.println("Java Home: "+properties.get("myjavahome"));
//    }

    @Autowired
    private Properties properties;
    public void printProperties(){
        System.out.println("contact email: " + properties.getProperty("mymail"));
        System.out.println("Java Home: " + properties.getProperty("myjavahome"));
    }




}
