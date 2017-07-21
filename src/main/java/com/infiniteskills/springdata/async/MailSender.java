package com.infiniteskills.springdata.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import java.util.concurrent.Future;

@Component
public class MailSender {

    @Async
    public Future<Boolean> sendMail() throws InterruptedException {
        System.out.println("sending mail..");
        Thread.sleep(1000 * 10);
        System.out.println("sending mail completed");
        return new AsyncResult<Boolean>(true);
    }
}
