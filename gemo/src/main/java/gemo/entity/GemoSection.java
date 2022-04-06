package gemo.entity;

public class GemoSection {
	
	String title;
	int id;
	int noteId;
	
	public GemoSection() {
	}

	public GemoSection(String title, int id, int noteId) {
		this.title = title;
		this.id = id;
		this.noteId = noteId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	@Override
	public String toString() {
		return "GemoSection [title=" + title + ", id=" + id + ", noteId=" + noteId + "]";
	}
}
