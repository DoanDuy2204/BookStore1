package com.dvd.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="discount")
	private float discount;
	
	@Column(name="doc")
	private String doc;
	
	@Column(name="view")
	private int view;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="image_link")
	private String image;
	
	@Column(name="sold_number")
	private int soldNumber;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	@JsonIgnoreProperties("books")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="publishinghouse_id")
	@JsonIgnoreProperties("books")
	private PublishingHouse publishingHouse;

	@ManyToMany(fetch = FetchType.EAGER,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="authors_books",
	joinColumns= {@JoinColumn(name="book_id")},
	inverseJoinColumns= {@JoinColumn(name="author_id")})
	@JsonIgnoreProperties("books")
	private List<Author> authors;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy="book")
	@JsonIgnoreProperties("book")
	private List<Interactive> interactives = new ArrayList<Interactive>();

	@Column(name="star")
	private Double star;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Double getStar() {
		return star;
	}

	public void setStar(Double star) {
		this.star = star;
	}
	public List<Interactive> getInteractives() {
		return interactives;
	}

	public void setInteractives(List<Interactive> interactives) {
		this.interactives = interactives;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public PublishingHouse getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(PublishingHouse publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public int getSoldNumber() {
		return soldNumber;
	}

	public void setSoldNumber(int soldNumber) {
		this.soldNumber = soldNumber;
	}
	
}
