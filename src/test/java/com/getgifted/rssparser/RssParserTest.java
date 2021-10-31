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
		mockMvc.perform(get("/items")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));

	}
	
	@Test
	public void fetchDirectionBasedOnFieldItems() throws Exception {
		mockMvc.perform(get("/items?page=1&size=10&sort=updated_date&direction=asc")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));

	}

}