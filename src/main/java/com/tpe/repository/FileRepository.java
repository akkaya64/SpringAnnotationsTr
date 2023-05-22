package com.tpe.repository;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("file")
public class FileRepository implements Repo{
    @Override
    public void save(Message message) {
        System.out.println("Your message is being saved the file: " + message.getMessage());
    }
}
