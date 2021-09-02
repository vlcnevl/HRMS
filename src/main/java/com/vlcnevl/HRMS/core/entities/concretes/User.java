package com.vlcnevl.HRMS.core.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED )
public class User {
	
	public User(String email, String password, boolean status) {
		this.email = email;
		this.password = password;
		this.status = status;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
    @Email
	@NotBlank
	@NotNull(message="required")
	private String email;
	
	@Column(name="password")
	@NotBlank
	@NotNull(message = "required")
	@Size(min = 6)
	private String password;
	
	@Column(name="status")
	private boolean status;
}
