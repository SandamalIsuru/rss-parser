package com.getgifted.rssparser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getgifted.rssparser.common.Constant.DIRECTION;
import com.getgifted.rssparser.common.Constant.SORT_BY;
import com.getgifted.rssparser.common.PaginatedResponse;
import com.getgifted.rssparser.entity.Item;
import com.getgifted.rssparser.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping(path = "")
	public PaginatedResponse<Item> fetch(
			@RequestParam(defaultValue="${difault.page}") int page, @RequestParam(defaultValue="${difault.size}") int size,
			@RequestParam(defaultValue="updated_date") SORT_BY sort, @RequestParam(defaultValue="asc") DIRECTION direction) {
		return itemService.fetchItems(page, size, sort, direction);

	}

}
