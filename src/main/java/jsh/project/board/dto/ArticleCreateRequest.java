package jsh.project.board.dto;

public class ArticleCreateRequest {
	private String writer;
	private String password;
	private String title;
	private String content;
	
	public ArticleCreateRequest(String writer, String password, String title, String content) {
		this.writer = writer;
		this.password = password;
		this.title = title;
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
