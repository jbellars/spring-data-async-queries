## spring-data-java-config

Base project for Spring Data applications using java configuration rather than the xml configuration used in the InfiniteSkills course by Kevin Bowersox at <a href="https://www.safaribooksonline.com/library/view/spring-data-for/9781771375924/">https://www.safaribooksonline.com/library/view/spring-data-for/9781771375924/</a> 

**NOTE:** If you find yourself going through Kevin Bowersox's Infinite Skills course on Spring Data for Java Developers, and you have trouble with the Async methods, make sure you remove the try-with-resources syntax around your ApplicationContext, even if your IDE suggests it is a good idea to prevent possible leaks. **It will cause your context to be destroyed before your asynch queries can be executed/completed.**




