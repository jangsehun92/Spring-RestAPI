package jsh.project.board.dto;

public class ArticleUpdateRequest {
	private int id;
	private String title;
	private String content;

	public ArticleUpdateRequest(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
