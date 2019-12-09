package jsh.project.board.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	
	private SqlSession sqlSession;
	
	public BoardDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
