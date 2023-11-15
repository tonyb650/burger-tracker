package com.tonyb650.burgertracker.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // jakarta.persistence -> this 'connects class to database'
@Table(name="burgers") // jakarta.persistence -> 'specifies the table name in MySQL'
public class Burger {
	@Id // jakarata -> this is the primary key for our table
	@GeneratedValue(strategy = GenerationType.IDENTITY) // specifies how the ID will be generated
	private Long id;
	
	// Error message examples:
	// @Size(min = 3, max = 40, message="Language must be at least 3 characters.")
	// private String language;
	// @NotNull
	// @Min(value=100, message="Must be at least 100 pages.")
	// private Integer numberOfPages;
	
	
	@NotBlank (message="Burger name cannot be blank")
	@Size(min = 5, max=200, message="Burger name must be between 5 and 200 characters")
	private String burgerName;
	
	@NotEmpty  (message="Restaurant name cannot be empty")
	@Size(min = 5, max=200, message="Restaurant name must be between 5 and 200 characters")
	private String restaurantName;
	
	@NotNull (message="Rating is required")
	@Min(1)
	@Max(5)
	private Integer rating;
	
	@NotNull (message="Please add some notes")
	private String burgerNotes;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date updatedAt;
	
	// empty constructor needed
	public Burger() {
	} 
	
	public Burger(String burger, String restaurant, Integer rating, String notes) {
		this.burgerName = burger;
		this.restaurantName = restaurant;
		this.rating = rating;
		this.burgerNotes = notes;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBurgerName() {
		return burgerName;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getBurgerNotes() {
		return burgerNotes;
	}

	public void setBurgerNotes(String burgerNotes) {
		this.burgerNotes = burgerNotes;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}	
}
