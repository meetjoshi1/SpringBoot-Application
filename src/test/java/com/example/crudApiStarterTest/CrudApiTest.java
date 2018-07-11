package com.example.crudApiStarterTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.crudApiStarter.CrudApi;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CrudApi.class)
public class CrudApiTest {
	
	@Test
	public void contextLoads() throws Exception{
		
	}

}
