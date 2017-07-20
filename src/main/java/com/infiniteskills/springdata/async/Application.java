package com.infiniteskills.springdata.async;

import com.infiniteskills.springdata.async.data.repository.BookRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ParseException;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
public class Application
{

    @SuppressWarnings("resource")
    public static void main(String[] args) throws ParseException
    {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                DataConfiguration.class))
        {
            BookRepository repository = context.getBean(BookRepository.class);

            // TODO: Make method Async
            for (long x = 0; x < 4; x++)
            {
                repository.findByIds(x);
            }
        }
    }
}
