package demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

@Configuration
@EnableJpaRepositories
public class PersistenceConfiguration extends JpaRepositoryConfigExtension {

	@Autowired
    private BookRepository bookRepository;

    @PostConstruct
    private void addBooks() {
    	/*
    	Book book1 = new Book();
    	book1.title = "Proccesses clean up";
        book1.deployer = "Jim Bean";
        book1.description = "Clean up of the processes";
        book1.developer = "Jeff Wurst";
        book1.technicalDetails = "You have to run bush script on behalf of the user";
        BookParameter parameter1 = new BookParameter();
        parameter1.title = "Processor threashold";
        book1.parameters.add(parameter1);
        BookParameter parameter2 = new BookParameter();
        parameter2.title = "Disk threashold";
        parameter2.value = "92%";
        book1.parameters.add(parameter2);
        
        Book book2 = new Book();
    	book2.title = "Proccesses clean up1";
        book2.deployer = "John Smith";
        book2.description = "Clean up of the processes";
        book2.developer = "Run Forest";
        book2.technicalDetails = "You have to run bush script on behalf of the user";
        BookParameter parameter3 = new BookParameter();
        parameter3.title = "Disk threashold";
        book1.parameters.add(parameter3);
        
       
        bookRepository.save(book1);
        bookRepository.save(book2);
        */
    }
    
}
