package jsh.project.board.api;

import org.springframework.web.bind.annotation.RestController;

import jsh.project.board.service.BoardService;

@RestController
public class BoardRestApi {
	
	private BoardService boardService;
	
	public BoardRestApi(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//articleList
	
	//airtcleDetail
	
	//articleUpdate
	
	//articleDelete
	
	
}
