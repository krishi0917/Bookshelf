package intuit.craftexcercise.testCase;

import intuit.craftexcercise.BookController;
import intuit.craftexcercise.Books;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={  })


public class jUnitTest  {
	
	@Autowired
	private BookController bookController;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void showBooks() throws Exception{
	//	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();		
		List<Books> books = new ArrayList<Books>();
		books.add(new Books("12312312","Cisco Networking" , "Aniket Khaire","rishi"));
//		String BookJson = CommonUtil.json(books);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String Bookjson = ow.writeValueAsString(books);
		System.out.println(Bookjson);
		assertEquals("","");
		
		
 /*       mockMvc.perform(get("/getBooks") 
        		.contentType(MediaType.APPLICATION_JSON)
                .content(Bookjson))
		.andExpect(status().isOk());
        
  */      
        
	}
	
}
