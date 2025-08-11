package risrchanish.notes_manager.entity;

/*
 *  This is an entity class basically, POJO class. 
 *  And purpose is to use it across multiple layers within the project. 
 */

public class Note {

	private String content;
	

	public Note(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Note [content=" + content + "]";
	}
	
	
	
}
