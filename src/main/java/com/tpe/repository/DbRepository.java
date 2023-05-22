package com.tpe.repository;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("db")
public class DbRepository implements Repo{
    @Override
    public void save(Message message) {
        System.out.println("Your message is being saved to DB: " + message.getMessage());
    }
}
