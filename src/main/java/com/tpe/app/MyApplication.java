package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Random;

public class MyApplication {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMessage("Its great to develop with String ");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        // context AppConfiguration class indaki @Configuration u gorecek @ComponentScan ile component edilmis
        // service class larini tarayacak ve bir tane bean olusturacak ve context de hazirda bekletecek
//        MessageService service01 = context.getBean(MailService.class);
//        service.sendMessage(message);

//        MessageService service02 = context.getBean(SmsService.class);
//        MessageService service03 = context.getBean("smsservice",MessageService.class);
//        service02.sendMessage(message);

        //interface i implemente eden  birden fazla component ile işaretlenmiş class varsa
        //hangisini alması gerektiğini belirtmemiz gerekir.

//        MessageService service03 = context.getBean(MailService.class);
//        service03.sendMessage(message);
//        service03.saveMessage(message);

        //Random random = new Random();  burada Random methodunu biz olusturduk bunun yerine config class da Spring
        // bizim icin olustursun
//        Random random = context.getBean(Random.class);
//        System.out.println(random.nextInt(100));

        MessageService service04 = context.getBean("mailservice", MessageService.class);
        MessageService service05 = context.getBean("mailservice", MessageService.class);

        //spring te beanlerin default scope:singleton
        //singleton:tüm uygulama için sadece tek bir bean oluşturulur, beanin tüm life cycleından Spring sorumludur.
        //prototype:her oAnlamadım hocambje istendiğinde yeni bir bean oluşturulur, beanin destroy/sonlandırılmasından sorumlu değildir.


        if (service04 == service05) {
            System.out.println("ayni referansli bean objeleri ");
            System.out.println(service04);
            System.out.println(service05);
        } else {
            System.out.println("farkli referansli bean objeleri");
            System.out.println(service04);
            System.out.println(service05);
        }

//        MessageService service06 = context.getBean("mailservice",MessageService.class);
//        service06.sendMessage(message);
//
        //TUM UYGULAMADAKI BEANLARIN ISIMLERI
//        String[] beanNames = context.getBeanDefinitionNames();
//        for (String names : beanNames) {
//            System.out.println(names);
//        }


        SmsService service07 = context.getBean(SmsService.class);
        service07.sendMessage(message);
        service07.printContact();
        service07.printProperties();



        context.close(); //contextten obje isteyemeyiz,beanler sonlandırılır, getBean ile bean talep edemeyiz.
        System.out.println("context'in close methodundan sonra: ");


    }

}
