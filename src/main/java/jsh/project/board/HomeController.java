package jsh.project.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jsh.project.board.service.BoardService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private BoardService boardService;
	
	public HomeController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//게시판 메인 페이지 요청
	@GetMapping(value = "/")
	public String home() {
		logger.info("GET /");
		return "home";
	}
	
	//글보기 요청
	@GetMapping("/article/{id}")
	public String detail(Model model, @PathVariable("id")int id) {
		logger.info("GET /article/"+id);
		model.addAttribute("article",boardService.articleDetail(id));
		return "articleDetailForm";
	}
	
	//글입력폼 요청
	@GetMapping("/article/create")
	public String articleCreateForm() {
		logger.info("GET /article/create");
		return "articleCreateForm";
	}
	
	//글수정폼 요청 
	@GetMapping("/article/edit/{id}")
	public String articleUpdateForm(Model model,@PathVariable("id")int id) {
		logger.info("GET /article/edit/"+id);
		model.addAttribute("article",boardService.articleDetail(id));
		return "articleEditForm";
	}
	
	
}
