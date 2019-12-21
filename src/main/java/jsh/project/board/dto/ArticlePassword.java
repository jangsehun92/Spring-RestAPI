package jsh.project.board.dto;

public class ArticlePassword {
	int id;
	String password;
	
	public ArticlePassword() {
		
	}
	
	public ArticlePassword(int id,String password) {
		this.id = id;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
