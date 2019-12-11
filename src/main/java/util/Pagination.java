package util;

import java.util.HashMap;
import java.util.Map;

public class Pagination {
	private int totalCount; //게시판의 총 게시글 수 
	private int countList = 10; //한 페이지당 보여줄 게시글 수
	private int countPage = 5; //페이징 처리하여 보여줄 하단의 숫자 범위 ex)5 = 1~5
	
	private int page; //현재 페이지 
	private int totalPage; //게시판의 총 게시글 수를 보여줄 만큼 나눈 후의 값(전체 페이지의 수)
	
	//DB 검색 조건
	private int startCount; 
	private int endCount;	
	
	private int startPage; //하단 페이지네이션의 시작 숫자 
	private int endPage; //하단 페이지네이션의 마지막 숫자
	
	public Pagination() {
		
	}
	
	public Pagination(int totalCount, int page) {
		this.totalCount = totalCount;
		this.page = page;
		make();
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCountList() {
		return countList;
	}

	public void setCountList(int countList) {
		this.countList = countList;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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
	
	public void make() {
		totalPage = (totalCount / countList);
		/*
		총 게시글(totalCount)를 한페이지당 보여줄 게시글 수(countList)로 나눴을때 나머지가 0 보다크다는것은
		게시글이 최소 1개이상 더 있다는 뜻이므로, 전체페이지를 하나더 추가해줘야함
		*/
		if(totalCount % countList > 0) {
			totalPage++;
		}
		
		/*
		 * 전체 페이지(totalPage) 보다 현재 page가 크다면, 현재 페이지를 totalPage로 맞춰준다.
		 * ex) 전체페이지는 24 인데 현재 페이지가 26이라면 현재 페이지를 24로 만들어주는 것임.
		 */
		if(totalPage < page){
			page = totalPage;
		}
		/*
		 * 하단에 표시될 페이지들을 출력해주기 위하여 startPage & endPage 를 계산해준다.
		 * 현재 페이지가 10안밖이라면 하단에는 1~10까지 표시되어야한다.
		 */
		startPage = ((page -1) / countPage) * countPage + 1;
		endPage = startPage + countPage - 1;  
		/*
		 * endPage가 totalPage보다 크다면, 마지막페이지를 전체페이지로 맞춰준다.
		 */
		if(endPage > totalPage) {
			endPage = totalPage;
		}
	}
	
	public Map<String, Integer> scope(){
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		this.startCount = (page - 1) * countList + 1;
		this.endCount = page * countList; 
		resultMap.put("startCount", startCount);
		resultMap.put("endCount", endCount);
		return resultMap;
	}
}
