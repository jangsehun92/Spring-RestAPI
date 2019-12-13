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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jsh.project.board.dto.Article;
import jsh.project.board.dto.ArticleUpdateRequest;
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
	
	//게시글 비밀번호와 입력한 비밀번호가 같을 경우 동작하도록 처리하기
	//articleUpdate
	@PostMapping("/article/{id}")
	public ResponseEntity<String> update(ArticleUpdateRequest dto){
		
		return new ResponseEntity<String>("OK",HttpStatus.OK);
	}
	
	//articleDelete
	@DeleteMapping("/article/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")int id){
		boardService.articleDelete(id);
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	
}
