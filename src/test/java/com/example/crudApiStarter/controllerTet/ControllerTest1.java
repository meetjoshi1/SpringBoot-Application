package com.example.crudApiStarter.controllerTet;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.example.crudApiStarter.entity.User;
import com.example.crudApiStarter.service.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebApplicationContext.class})
@WebAppConfiguration
public class ControllerTest1 {

	 private MockMvc mockMvc;
	 
	 @Autowired
	 private UserService userServiceMock;
	 
	 
	 @Ignore
	    public void testgetAllUser() throws Exception {
//	        User first = new User()
//	                .id("101")
//	                .name("Meet")
//	                .location("Miami")
//	                .build();
//	        User second = new User()
//	        		.id("102")
//	                .name("Chetan")
//	                .location("Orlando")
//	                .build();
	
	User first=new User();
	first.setId("101");
	first.setName("Meet");
	first.setLocation("Miami");
	
	User second=new User();
	second.setId("102");
	second.setName("Chetan");
	second.setLocation("Orlando");
	
	        when(userServiceMock.getAllUsers()).thenReturn(Arrays.asList(first, second));
	       
	        mockMvc.perform(get("/ueer/all").accept(MediaType.APPLICATION_JSON))
	        .andDo(print());
	       // .andExpect(jsonPath("$.User.name").value("Meet");
	        
	        
	        // mockMvc.perform(get("/user/all").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(jsonPath("$[0].name", is("Meet")));
	        
	        //   .andExpect(jsonPath("$[0].id", is("101")));
	               // .andExpect(status().isOk())
	              //  .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
//	                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//	                .andExpect(jsonPath("$[0].id", is("101")))
//	                .andExpect(jsonPath("$[0].name", is("Meet")))
//	                .andExpect(jsonPath("$[0].location", is("Miami")))
//	                .andExpect(jsonPath("$[1].id", is("102")))
//	                .andExpect(jsonPath("$[1].name", is("Chetan")))
//	                .andExpect(jsonPath("$[1].location", is("Orlando")));
	 
//	        verify(userServiceMock, times(1)).getAllUsers();
//	        verifyNoMoreInteractions(userServiceMock);
	    }





	private Object is(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	}