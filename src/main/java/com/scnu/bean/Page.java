package com.scnu.bean;

public class Page {
	// 总条数
	private Long totalCount;
	// 当前页
	private int currentPage;
	// 总页数
	private int totalPage;
	// 每页显示的条数
	private int pageNumber;
	// 是否有下一页
	private boolean hasNext;
	// 是否有上一页
	private boolean hasPrev;
	// limit第一个参数
	private int limitStart;
	
	public Page() {
		this.currentPage = 1;
		this.pageNumber  = 5;
	}

	public Page(int currentPage, int pageNumber) {
		this.currentPage = currentPage;
		this.pageNumber = pageNumber;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
		count();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	private void count() {
		totalPage = (int) Math.ceil(totalCount * 1.0d / pageNumber * 1.0d);
		hasNext = currentPage < totalPage;
		hasPrev = currentPage > 1;
		limitStart = (currentPage - 1) * pageNumber;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public boolean isHasPrev() {
		return hasPrev;
	}

	public int getLimitStart() {
		return limitStart;
	}
}
