package com.getgifted.rssparser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
public class RssParserTest extends RssParserApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void fetchLatestItems() throws Exception {
		mockMvc.perform(get("/items")).andExpect(status().isOk());
	}
	
	@Test
	public void fetchDirectionBasedOnFieldItems() throws Exception {
		mockMvc.perform(get("/items?page=0&size=10&sort=updated_date&direction=asc")).andExpect(status().isOk());
	}
	
	@Test
	public void fetchItemsWithInvalidPage() throws Exception {
		mockMvc.perform(get("/items?page=INVALID&size=10&sort=updated_date&direction=asc")).andExpect(status().isBadRequest());
	}
	
	@Test
	public void fetchItemsWithInvalidSize() throws Exception {
		mockMvc.perform(get("/items?page=0&size=INVALID&sort=updated_date&direction=asc")).andExpect(status().isBadRequest());
	}
	
	@Test
	public void fetchItemsWithInvalidSort() throws Exception {
		mockMvc.perform(get("/items?page=0&size=10&sort=INVALID&direction=asc")).andExpect(status().isBadRequest());
	}
	
	@Test
	public void fetchItemsWithInvalidDirection() throws Exception {
		mockMvc.perform(get("/items?page=0&size=10&sort=updated_date&direction=INVALID")).andExpect(status().isBadRequest());
	}

}