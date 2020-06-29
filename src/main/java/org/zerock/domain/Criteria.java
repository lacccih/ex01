package org.zerock.domain;

public class Criteria {

	private int page;
	
	private int perPageNum;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 3;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		}
		else {
			this.page = page;
		}
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 10) {
			this.perPageNum = 3;
		}
		else {
			this.perPageNum = perPageNum;
		}
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
}
