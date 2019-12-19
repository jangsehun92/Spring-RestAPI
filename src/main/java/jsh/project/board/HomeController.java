package jsh.project.board;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jsh.project.board.dto.Article;
import jsh.project.board.service.BoardService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private BoardService boardService;
	
	public HomeController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//게시판 메인 페이지 요청
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	//글보기 요청
	@GetMapping("/article/{id}")
	public ResponseEntity<Article> detail(@PathVariable("id")int id) {
		logger.info("/article/"+id);
		return new ResponseEntity<Article>(boardService.articleDetail(id), HttpStatus.OK);
	}
	
	//글입력 요청
	@GetMapping("/article")
	public String articleCreateForm() {
		return "articleCreateForm";
	}
	
	
	//글수정폼 요청 
	@GetMapping("/article/update/{id}")
	public String articleUpdateForm(Model model,@PathVariable("id")int id) {
		model.addAttribute("article",boardService.articleDetail(id));
		return "articleUpdateForm";
	}
	
	
}
