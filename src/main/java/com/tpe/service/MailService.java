package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("mailservice")
@Scope("prototype")
public class MailService implements MessageService {
    @PostConstruct
    public void init() {
        System.out.println("Creating mail object");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("mail bean object has being destroyed");
    }

//    A) FIELD INJECTION
//    @Autowired //reponun objesini classa enjekte ediyor.(DI)--->field injection
//    @Qualifier("fileRepository")
//    private Repo repo;


    //B) SETTER INJECTION
//    private Repo repo;
//    @Autowired
//    @Qualifier("fileRepository")
//    public void setRepo(Repo repo) {
//        this.repo = repo;
//    }


    //C) CONSTRUCTOR INJECTION: daha guvenli, anlasilir, test etmek daha kolay
    private Repo repo;
    public MailService(@Qualifier("fileRepository") Repo repo) {
        this.repo = repo;
    }

    @Override
    //@Qualifier("db")
    public void sendMessage(Message message) {
        System.out.println("This message from Mail Service. Your Message is: " + message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //reponun metodunu için objesine ihityacımız var
        repo.save(message);
    }
}
