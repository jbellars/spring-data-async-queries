package com.infiniteskills.springdata.async;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.infiniteskills.springdata.async.data.entity.Book;
import com.infiniteskills.springdata.async.data.repository.BookRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Main method for application.
 * Added @Configuration annotation to @EnableAsync annotation as <a href="https://stackoverflow.com/a/45206505/2543739">Abdullah Khan indicated on Stack Overflow</a> the Spring <a href="https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/annotation/EnableAsync.html">docs</a> specify.
 *
 */
public class Application
{

	public static void main(String... args) throws InterruptedException, ExecutionException
    {
		// Danger: using try-with-resources will close the context before the asynchronous queries are able to complete.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class);

		// Async example that works: http://memorynotfound.com/asynchronous-service-with-spring-async-and-java-future/
		/*
		MailSender mailSender = context.getBean(MailSender.class);

        System.out.println("about to run");
        @SuppressWarnings("rawtypes")
		Future future = mailSender.sendMail();
        System.out.println("this will run immediately.");

        Boolean result = (Boolean) future.get();

        System.out.println("mail send result: " + result);
        */
        
        BookRepository repository = context.getBean(BookRepository.class);

        for (long x = 0; x < 4; x++)
        {
            //System.out.println("Id = " + x);
			//CompletableFuture<List<Book>> future = (CompletableFuture<List<Book>>) repository.findByIds(x);
            
            @SuppressWarnings("unused")
			List<Book> result = repository.findByIds(x); //(List<Book>) future.get();
        }
        
        
    }
}
