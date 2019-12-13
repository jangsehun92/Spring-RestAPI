package jsh.project.board.api;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jsh.project.board.dto.Article;
import jsh.project.board.dto.ArticleCreateRequest;
import jsh.project.board.dto.ArticleUpdateRequest;
import jsh.project.board.service.BoardService;

@RestController
public class BoardRestApi {
	private static final Logger logger = LoggerFactory.getLogger(BoardRestApi.class);
	
	private BoardService boardService;
	
	public BoardRestApi(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//Article List
	@GetMapping("/articles")
	public ResponseEntity<Map<String, Object>> list(@RequestParam(required = false, defaultValue = "1")int page){
		return new ResponseEntity<Map<String, Object>>(boardService.articleList(page), HttpStatus.OK);
	}

	//Article Detail
	@GetMapping("/article/{id}")
	public ResponseEntity<Article> detail(@PathVariable("id")int id) {
		logger.info("/article/"+id);
		return new ResponseEntity<Article>(boardService.articleDetail(id), HttpStatus.OK);
	}
	
	//Aritlce CREATE
	@PostMapping("/article")
	public ResponseEntity<String> create(ArticleCreateRequest dto){
		boardService.articleCreate(dto);
		return new ResponseEntity<String>("CREATE OK",HttpStatus.CREATED);
	}
	
	//Article UPDATE
	@PutMapping("/article/{id}")
	public ResponseEntity<String> create(ArticleUpdateRequest dto, @PathVariable("id")int id){
		boardService.articleUpdate(id,dto);
		return new ResponseEntity<String>("UPDATE OK",HttpStatus.OK);
	}
	
	//Article DELETE
	@DeleteMapping("/article/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")int id){
		boardService.articleDelete(id);
		return new ResponseEntity<String>("DELETE OK", HttpStatus.OK);
	}
	
	
}
