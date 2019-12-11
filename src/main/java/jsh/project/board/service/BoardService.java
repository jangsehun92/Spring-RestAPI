package jsh.project.board.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import jsh.project.board.dao.BoardDao;
import jsh.project.board.dto.Article;
import util.Pagination;

@Service
public class BoardService {
	
	private BoardDao boardDao;
	
	public BoardService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public int totalCount() {
		return boardDao.totalCount();
	}
	
	public Map<String, Object> articleList(int page){
		Map<String, Object> resultMap = new HashMap<>();
		Pagination pagination = new Pagination(totalCount(), page);
		resultMap.put("pagination",pagination); 
		resultMap.put("articleList",boardDao.list(pagination.scope()));
		return resultMap;
	}
	
	public Article articleDetail(int id) {
		return boardDao.detail(id);
	}
	
	public int articleUpdate(int id) {
		return boardDao.update(id);
	}
	
	public void articleDelete(int id) {
		boardDao.delete(id);
	}
	
}
