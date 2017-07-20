package com.infiniteskills.springdata.async;

import com.infiniteskills.springdata.async.data.repository.BookRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ParseException;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Main method for application.
 * Added @Configuration annotation to @EnableAsync annotation as <a href="https://stackoverflow.com/a/45206505/2543739">Abdullah Khan indicated on Stack Overflow</a> the Spring <a href="https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/annotation/EnableAsync.html">docs</a> specify.
 *
 */
@Configuration
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

            for (long x = 0; x < 4; x++)
            {
                // TODO: Make method Async
                repository.findByIds(x);
            }
        }
    }
}
