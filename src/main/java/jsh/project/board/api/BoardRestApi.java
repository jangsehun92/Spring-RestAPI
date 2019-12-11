package jsh.project.board.api;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jsh.project.board.dto.Article;
import jsh.project.board.service.BoardService;

@RestController
public class BoardRestApi {
	private static final Logger logger = LoggerFactory.getLogger(BoardRestApi.class);
	
	private BoardService boardService;
	
	public BoardRestApi(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//articleList
	@GetMapping("/articles")
	public ResponseEntity<Map<String, Object>> list(@RequestParam(required = false, defaultValue = "1")int page){
		return new ResponseEntity<Map<String, Object>>(boardService.articleList(page), HttpStatus.OK);
	}
	
	//airtcleDetail
	@GetMapping("/article/{id}")
	public ResponseEntity<Article> detail(@PathVariable("id")int id) {
		logger.info("/article/"+id);
		return new ResponseEntity<Article>(boardService.articleDetail(id), HttpStatus.OK);
	}
	
	//articleUpdate
	
	//articleDelete
	
	
}
