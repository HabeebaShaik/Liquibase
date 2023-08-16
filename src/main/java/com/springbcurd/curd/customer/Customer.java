package com.springbcurd.curd.customer;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_Id", length = 10, nullable = false)
	private Integer id;

	@NotNull(message = "Customer name cannot be blank")
	@Pattern(regexp = "^[A-Za-z][A-Za-z]{2,29}$", message = "Name must be of 3 to 30 length with only alphabets")
	@Column(name = "C_Name", length = 30, nullable = false)
	private String name;

	@NotBlank(message = "Email cannot be blank")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Email should be valid")
	@Column(name = "C_Email", length = 40, nullable = false)
	private String email;

	@Positive
	@Digits(integer = 10, fraction = 0, message = "The Phone should be a number with integer part of up to 10 digits!")
	@Column(name = "C_Phone", length = 30, nullable = false)
	private long phone;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;


	public Customer(Integer id,
			@NotNull(message = "Customer name cannot be blank") @Pattern(regexp = "^[A-Za-z][A-Za-z]{2,29}$", message = "Name must be of 3 to 30 length with only alphabets") String name,
			@NotBlank(message = "Email cannot be blank") @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Email should be valid") String email,
			@Positive @Digits(integer = 10, fraction = 0, message = "The Phone should be a number with integer part of up to 10 digits!") long phone,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Customer() {}


}
