package jsh.project.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jsh.project.board.dto.Article;
import jsh.project.board.dto.ArticleCreateRequest;
import jsh.project.board.dto.ArticleUpdateRequest;

@Repository
public class BoardDao {
	
	private SqlSession sqlSession;
	
	public BoardDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int totalCount() {
		return sqlSession.selectOne("boardMapper.totalCount");
	}
	
	public List<Article> list(Map<String, Integer> paramMap) {
		return sqlSession.selectList("boardMapper.list", paramMap);
	}
	
	public Article detail(int id) {
		return sqlSession.selectOne("boardMapper.detail",id);
	}
	
	public int create(ArticleCreateRequest dto) {
		return sqlSession.insert("boardMapper.insert",dto);
	}
	
	public int update(ArticleUpdateRequest dto) {
		return sqlSession.update("boardMapper.update",dto);
	}
	
	public int delete(int id) {
		return sqlSession.delete("boardMapper.delete",id);
	}
	
}
