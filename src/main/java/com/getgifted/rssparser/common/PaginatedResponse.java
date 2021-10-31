package com.getgifted.rssparser.common;

import java.util.ArrayList;
import java.util.List;

public class PaginatedResponse<E> {
	
	private int totalPages;
	private List<E> response = new ArrayList<E>();
	
	public PaginatedResponse(int totalPages, List<E> reponse) {
		this.totalPages = totalPages;
		this.response = reponse;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<E> getResponse() {
		return response;
	}
	public void setResponse(List<E> response) {
		this.response = response;
	}
	
	

}
