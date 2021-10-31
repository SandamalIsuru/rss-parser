package com.getgifted.rssparser.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.getgifted.rssparser.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	Page<Item> findAllByOrderByPublishedDateAsc(Pageable pageable);
	Page<Item> findAllByOrderByTitleAsc(Pageable pageable);
	Page<Item> findAllByOrderByUpdatedDateAsc(Pageable pageable);
	Page<Item> findAllByOrderByPublishedDateDesc(Pageable pageable);
	Page<Item> findAllByOrderByTitleDesc(Pageable pageable);
	Page<Item> findAllByOrderByUpdatedDateDesc(Pageable pageable);
}
