package com.dvd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="interactives")
public class Interactive {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="star")
	private float star;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="book_id")
	private Book book;
	
	public Interactive() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getStar() {
		return star;
	}

	public void setStar(float star) {
		this.star = star;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
