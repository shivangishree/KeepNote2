package com.stackroute.keepnote.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/*
 * The class "Note" will be acting as the data model for the note Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */
@Entity

public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int noteId;

	@Column
	String noteTitle;

	@Column
	String noteContent;

	@Column
	String noteStatus;

	@Column
	LocalDateTime createdAt;

	public Note() {

	}
	public Note(int i, String string, String string2, String string3) {
		setNoteId(i);
		setNoteTitle(string);
		setNoteContent(string2);
		setNoteStatus(string3);
	}
	
	public Note(int i, String string, String string2, String string3, LocalDateTime localDate) {
	setNoteId(i);
	setNoteTitle(string);
	setNoteContent(string2);
	setNoteStatus(string3);
	setCreatedAt(localDate);
	}

	public int getNoteId() {
		return noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public String getNoteStatus() {
		return noteStatus;
	}
    public LocalDateTime getCreatedAt() {
    	return createdAt;
    }
	public void setNoteId(int parseInt) {
		this.noteId = parseInt;
	}

	public void setNoteTitle(String parameter) {
		this.noteTitle = parameter;
	}

	public void setNoteContent(String parameter) {
		this.noteContent = parameter;
	}

	public void setNoteStatus(String parameter) {
		this.noteStatus = parameter;
	}

	public void setCreatedAt(LocalDateTime now) {
		this.createdAt = now;
	}
	

	/*@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteTitle=" + noteTitle + ", noteContent=" + noteContent + ", noteStatus="
				+ noteStatus + "]";
	}*/

	public Note(String noteTitle, String noteContent, String noteStatus) {
		super();
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.noteStatus = noteStatus;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Note)) {
			return false;
		}
		Note note = (Note) o;
		return getNoteId() == (note.getNoteId()) &&
				getNoteTitle().equals(note.getNoteTitle())
				&& getNoteContent().equals(note.getNoteContent()) && 
				getNoteStatus().equals(note.getNoteStatus());
	}
	
}
