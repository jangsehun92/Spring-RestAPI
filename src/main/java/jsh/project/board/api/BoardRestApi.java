package jsh.project.board.api;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jsh.project.board.dto.ArticleCreateRequest;
import jsh.project.board.dto.ArticlePassword;
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
		logger.info("GET /articles/"+page);
		return new ResponseEntity<Map<String, Object>>(boardService.articleList(page), HttpStatus.OK);
	}

	/* REST API 에서 해당 글의 정보를 가져올 때
	//Article Detail
	@GetMapping("/article/{id}")
	public ResponseEntity<Article> detail(@PathVariable("id")int id) {
		logger.info("GET /article/"+id);
		return new ResponseEntity<Article>(boardService.articleDetail(id), HttpStatus.OK);
	}
	*/
	
	//Article CREATE
	@PostMapping("/article")
	public ResponseEntity<String> create(@RequestBody ArticleCreateRequest dto){
		logger.info("dto.getDate : "+dto.getTitle());
		logger.info("POST /article");
		boardService.articleCreate(dto);
		return new ResponseEntity<String>("CREATE OK",HttpStatus.CREATED);
	}
	
	//Article UPDATE
	@PatchMapping("/article/{id}")
	public ResponseEntity<String> create(@RequestBody ArticleUpdateRequest dto, @PathVariable("id")int id){
		logger.info("PATCH /article/"+id);
		boardService.articleUpdate(id, dto);
		return new ResponseEntity<String>("UPDATE OK",HttpStatus.OK);
	}
	
	//Article DELETE
	@DeleteMapping("/article/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")int id){
		logger.info("DELETE /article/"+id);
		boardService.articleDelete(id);
		return new ResponseEntity<String>("DELETE OK", HttpStatus.OK);
	}
	
	//Article passwordCheck
	@PostMapping("/article/password")
	public ResponseEntity<String> passwordCheck(@RequestBody ArticlePassword articlePassword){
		logger.info("POST /article/password?id=["+ articlePassword.getId()+"]&password=["+articlePassword.getPassword()+"]");
		boardService.articlePasswordCheck(articlePassword);
		return new ResponseEntity<String>("PASSWORD CHECK OK", HttpStatus.OK);
	}
	
	
}
