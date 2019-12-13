package jsh.project.board.dto;

public class ArticleUpdateRequest {
	private String writer;
	private String title;
	private String content;

	public ArticleUpdateRequest(String writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
