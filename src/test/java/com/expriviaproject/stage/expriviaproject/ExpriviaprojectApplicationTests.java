package com.expriviaproject.stage.expriviaproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.*;

import com.expriviaproject.stage.expriviaproject.entities.user;


@SpringBootTest
class ExpriviaprojectApplicationTests extends AbstractTest {

	@Override
	@BeforeEach
	public void setUp() {
	   super.setUp();
	}
	@Test
	public void getUserList() throws Exception {
	   String uri = "/user";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		  .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   user[] userList = super.mapFromJson(content, user[].class);
	   assertTrue(userList.length > 0);
	}
	@Test
	public void createUser() throws Exception {
	   String uri = "/user";
	   user user = new user();
	   user.setId("1");
	   user.setName("Alessio");
	   user.setSurname("Aprile");
	   user.setEmail("hhalessio@gmail.com");
	   String inputJson = super.mapToJson(user);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		  .contentType(MediaType.APPLICATION_JSON_VALUE)
		  .content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertEquals(content, "");
	}
	@Test
	public void updateUser() throws Exception {
	   String uri = "/user/1";
	   user user = new user();
	   user.setId("2");
	   user.setName("aaAlessio");
	   user.setSurname("aaAprile");
	   user.setEmail("aaAhhalessio@gmail.com");
	   String inputJson = super.mapToJson(user);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
		  .contentType(MediaType.APPLICATION_JSON_VALUE)
		  .content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertEquals(content, "");
	}
	@Test
   	public void deleteUser() throws Exception {
      String uri = "/user/1";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "");
   }

}
