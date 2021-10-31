package com.getgifted.rssparser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.getgifted.rssparser.common.Constant.DIRECTION;
import com.getgifted.rssparser.common.Constant.SORT_BY;
import com.getgifted.rssparser.common.PaginatedResponse;
import com.getgifted.rssparser.entity.Item;
import com.getgifted.rssparser.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
    private ItemRepository itemRepository;
	
	@SuppressWarnings("unlikely-arg-type")
	public PaginatedResponse<Item> fetchItems (int page, int size, SORT_BY sort, DIRECTION direction) {
		Page<Item> returnList = null;
		switch (sort) {
		  	case title:
	  			if (direction.equals("asc"))
	  				returnList = itemRepository.findAllByOrderByTitleAsc(PageRequest.of(page, size));
	  	  		else
	  	  			returnList = itemRepository.findAllByOrderByTitleDesc(PageRequest.of(page, size));
		  		break;
		  	case published_date:
		  		if (direction.equals("asc"))
	  				returnList = itemRepository.findAllByOrderByPublishedDateAsc(PageRequest.of(page, size));
	  	  		else
	  	  			returnList = itemRepository.findAllByOrderByPublishedDateDesc(PageRequest.of(page, size));
		  		break;
		  	case updated_date:
		  		if (direction.equals("asc"))
	  				returnList = itemRepository.findAllByOrderByUpdatedDateAsc(PageRequest.of(page, size));
	  	  		else
	  	  			returnList = itemRepository.findAllByOrderByUpdatedDateDesc(PageRequest.of(page, size));
		  		break;
		  	default:
		}
		PaginatedResponse<Item> paginatedResponse = new PaginatedResponse<Item>(returnList.getTotalPages(), returnList.getContent());
		return paginatedResponse;
	}
	
	public Item saveOrUpdateItem (Item item) {
		return itemRepository.save(item);
	}

}
