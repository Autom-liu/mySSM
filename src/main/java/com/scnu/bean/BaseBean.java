package com.scnu.bean;


public class BaseBean {

	private Page page;
	
	public BaseBean() {
		super();
		this.page = new Page();
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
