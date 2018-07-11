package com.example.crudApiStarter.controllerTet;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.crudApiStarter.controller.CrudCntroller;
import com.example.crudApiStarter.entity.User;
import com.example.crudApiStarter.service.UserService;
import com.example.crudApiStarterTest.CrudApiTest;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class ControllerTest extends CrudApiTest{
	
	 @Autowired
	    private WebApplicationContext wac;
	    private MockMvc mockMvc;
	    
	    @Autowired
		 private UserService userServiceMock;
		 
	    	    	   
	    @Configuration
	    @EnableAutoConfiguration
	    public static class Config {
	    	
	    @Bean
	    public CrudCntroller apiController() {
	            return new CrudCntroller();
	        }
	    }

	    @Before
	    public void setUp() throws Exception {
	        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	    }
	    
	    @Test
	    public void testGetAllUser() throws Exception {
	        mockMvc.perform(get("/user/all").accept(MediaType.APPLICATION_JSON))
	                .andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	                .andExpect(jsonPath("$[0].name", is("Meet")));
	    }
	    
	    @Ignore
	    public void getAllUser() throws Exception {
	    	
	    	User first=new User();
	    	first.setId("101");
	    	first.setName("Meet");
	    	first.setLocation("Miami");
	    	
	    	User second=new User();
	    	second.setId("102");
	    	second.setName("Chetan");
	    	second.setLocation("Orlando");
	    	
	        when(userServiceMock.getAllUsers()).thenReturn(Arrays.asList(first, second));
	        mockMvc.perform(get("/user/all").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(jsonPath("$[0].id", is("101")));

	    }
	    
	    @Test
	    public void testGetUserById() throws Exception {
	    	
	    	
	    	mockMvc.perform(get("/user/101").accept(MediaType.APPLICATION_JSON))
	        		.andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	                .andExpect(jsonPath("$.id", is("101")));
	    }
	    
	    @Test
	    public void testGetUserByName() throws Exception {
	        mockMvc.perform(get("/user?name=Meet").accept(MediaType.APPLICATION_JSON))
	        		.andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	                .andExpect(jsonPath("$[0].name", is("Meet")));
	    }
	   
}
