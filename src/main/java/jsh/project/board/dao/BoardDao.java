package jsh.project.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jsh.project.board.dto.Article;

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
	
	public int update(int id) {
		return sqlSession.update("boardMapper.update",id);
	}
	
	public int delete(int id) {
		return sqlSession.delete("boardMapper.delete",id);
	}
	
}
