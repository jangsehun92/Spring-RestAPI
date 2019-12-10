package jsh.project.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jsh.project.board.dao.BoardDao;
import jsh.project.board.dto.Article;

@Service
public class BoardService {
	
	private BoardDao boardDao;
	
	public BoardService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public int totalCount() {
		return boardDao.totalCount();
	}
	
	public List<Article> articleList(){
		return boardDao.list();
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
