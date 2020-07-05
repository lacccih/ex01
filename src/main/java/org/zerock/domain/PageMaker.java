package org.zerock.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCnt;
	
	private int startPage;
	
	private int endPage;
	
	private boolean prev;
	
	private boolean next;
	
	private int displayPageNum = 3;
	
	private Criteria cri;
	
	public int getTotalCnt() {
		return totalCnt;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
		calcData();
	}
	
	private void calcData() {
		prev = true;
		next = true;
		endPage = (int)(Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		int tempEndPage = (int)(Math.ceil(totalCnt / (double)cri.getPerPageNum()));
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		if(startPage == 1) {
			prev = false;
		}
		if(endPage * cri.getPerPageNum() >= totalCnt) {
			next = false;
		}
	}

	public String makeQuery(int page) {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		return uri.toUriString();
	}
	
	@Override
	public String toString() {
		return "PageMaker [totalCnt=" + totalCnt + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + "]";
	}

}
