package me.co.kim.domain;

public class Page {
	
	//최소 페이지 번호입니다.
	private int min;
	
	//최대 페이지 번호입니다.
	private int max;
	
	//이전 버튼의 페이지 번호입니다.
	private int prevPage;
	
	//다음 버튼의 페이지 번호입니다.
	private int nextPage;
	
	//전체 페이지 개수입니다.
	private int pageCnt;
	
	//현재 페이지 번호입니다.
	private int currentPage;
	
	//생성자입니다.
	// contentCnt : 전체글의 개수, currentPage : 현재 글 번호, contentPageCnt : 페이지 당 글의 개수, paginationCnt : 페이지 버튼의 개수
	public Page(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
	
		// 현재 페이지 번호입니다.
		this.currentPage = currentPage;
		
		// 전체 페이지 개수입니다. (= 전체글의 개수  / 페이지 당 글의 개수)
		this.pageCnt = contentCnt/contentPageCnt; 
		
		// 전체 개수를 페이지의 수로 나눈 수의 나머지가 0보다 크면 실행되는 로직입니다.
		if(contentCnt%contentPageCnt > 0) {
			pageCnt++;
		}
		
		//페이지의 버튼의 최소값을 구해줍니다.
		min = ((currentPage - 1)/ contentPageCnt)*contentPageCnt + 1;
		
		//페이지 버튼의 최대값을 구해줍니다.
		max = min + paginationCnt -1;
		
		// 마지막 부분에 남아있는 페이지의 개수를 max값으로 설정해 줍니다 (ex 74페이지 일 경우 마지막 4페이지만 max로 설정, 버튼이 4개만 나오게 합니다)
		if(max > pageCnt) {
			max = pageCnt;
		}
		
		
		prevPage = min - 1;
		nextPage = max  + 1;
		
		// 다음페이지가 전체페이지의 개수를 넘어가면 전체페이지의 값을 다음 페이지의 값으로 설정하는 로직입니다.
		if(nextPage > pageCnt) {
			nextPage = pageCnt;
		}
		
	}

	//getter 메서드를 추가합니다.
	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	
	

}
