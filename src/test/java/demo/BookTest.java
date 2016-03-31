package demo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.Filter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookToolApplication.class)
@WebAppConfiguration
public class BookTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8")
            );

    private MockMvc mockMvc;

    
    @Autowired
    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    //@Autowired
    //private Filter springSecurityFilterChain;
    
    private Book book = new Book();
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext)
        		//.addFilters(springSecurityFilterChain)
        		.build();
        book.title = "Creation of the process";
        book.deployer = "Tim Strace";
        book.description = "Should clear the processes";
        book.developer = "Tom Jones";
        book.technicalDetails = "You have to run bush script on behalf of the user";
        BookParameter parameter1 = new BookParameter();
        parameter1.title = "Processor threashold";
        book.parameters.add(parameter1);
        BookParameter parameter2 = new BookParameter();
        parameter2.title = "Disk space threashold";
        parameter2.value = "95%";
        book.parameters.add(parameter2);
       
    }
	
	@Test
	public void addBook() throws Exception {
		String jsonData = json(this.book);
    	System.out.println(jsonData);
    	mockMvc.perform(post("/v1/books")
    			.contentType(contentType)
                .content(jsonData)
                )
        		.andExpect(status().isCreated())
        		;//.andExpect(content().contentType(contentType));
        		
	}
	
	protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

}
