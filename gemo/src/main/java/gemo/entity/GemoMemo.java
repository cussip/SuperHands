package gemo.entity;

public class GemoMemo {
	int sectionId;
	int id;
	String title;
	String content;	
	
	public GemoMemo() {
	}

	public GemoMemo(int sectionId, int id, String title, String content) {
		this.sectionId = sectionId;
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
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

	@Override
	public String toString() {
		return "GemoMemo [sectionId=" + sectionId + ", id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
}
