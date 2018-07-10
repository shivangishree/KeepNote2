package com.stackroute.keepnote.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.query.QueryProducer;

import com.stackroute.keepnote.model.Note;


/*
 * This class is implementing the NoteDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */

@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	private SessionFactory sessionFactory;
	public NoteDAOImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
	}

	
	/*
	 * Save the note in the database(note) table.
	 */

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean saveNote(Note note) {
		if(note!=null) {
		sessionFactory.getCurrentSession().save(note);
		sessionFactory.getCurrentSession().flush();
		return true;
		}
		return false;
//		
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(note);
//		session.getTransaction().commit();
//		session.close();
//		return true;

	}

	/*
	 * Remove the note from the database(note) table.
	 */

	public boolean deleteNote(int noteId) {
		if(getNoteById(noteId)==null) {
			return false;
		} else {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(getNoteById(noteId));
			session.getTransaction().commit();
			session.close();
			return true;
		}
		
//		String hql = "delete from Student where classId= :classId";
//		((QueryProducer) sessionFactory).createQuery(hql).setString(noteId, "NoteId").executeUpdate();		
		
//		Note note = (Note)(sessionFactory).createCriteria(Note.class).add(Restrictions.eq("noteId", noteId)).uniqueResult();
//		sessionFactory.getCurrentSession().delete(note);
		

	}

	/*
	 * retrieve all existing notes sorted by created Date in descending
	 * order(showing latest note first)
	 */
	public List<Note> getAllNotes() {
//		List<Note> users = new ArrayList<Note>();
//		TypedQuery<Note> query=sessionFactory.getCurrentSession().createQuery("from NOTE");
//		return query.getResultList();
//       
		
		String hql = "FROM Note note ORDER BY note.createdAt DESC";
		Query query = getSessionFactory().openSession().createQuery(hql);
		return query.getResultList();
	}

	/*
	 * retrieve specific note from the database(note) table
	 */
	public Note getNoteById(int noteId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Note note = (Note)session.get(Note.class, noteId);
		session.getTransaction().commit();
		session.close();
		return note;
	}

	/* Update existing note */

	public boolean UpdateNote(Note note) {
		if(getNoteById(note.getNoteId())==null) {
			return false;
		} else {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(note);
			session.getTransaction().commit();
			session.close();
			return true;
		}
	}


	}


