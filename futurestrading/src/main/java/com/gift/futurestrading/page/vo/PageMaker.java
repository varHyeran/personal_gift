package com.gift.futurestrading.page.vo;

public class PageMaker {
	private int totalCount;				/* 게시판 전체 데이터 개수 */
	private int displayPageNum = 10;  	/* 게시판 화면에서 한번에 보여질 페이지 번호의 개수 (1,2,3,4,5,6,7,9,10) */
	private int startPage;      		/* 현재 화면에서 보이는 startPage 번호 */
	private int endPage;       			/* 현재 화면에 보이는 endPage 번호 */
	private boolean prev;       		/* 페이징 이전 버튼 활성화 여부 */
	private boolean next;      			/* 페이징 다음 버튼 활성화 여부 */

	private Criteria cri;      /* Criteria를 주입받는다. */

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	
	private void calcData() {
		
		/* (int)(Math.ceil(현재 페이지번호 / (double)한번에 보여질 페이지 번호개수) * 한번에 보여질 페이지번호 개수). */
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		
		/* (endPage - 한번에 보여질 페이지 번호 개수) + 1 */
		startPage = (endPage - displayPageNum) + 1;
		
		/* (int)(Math.ceil(totalCount / (double)Criteria의 한페이지 당 게시글 개수)) */
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		/* startPage가 1이 아니면 활성화, 1이 면 비활성화 */
		prev = startPage == 1 ? false : true;
		
		/* (endPage * Criteria의 한페이지 당 게시글 개수) 가 totlaCount보다 크거나 같으면 비활성화, 아니면 활성화 */
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;

	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
}
