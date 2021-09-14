package com.vlcnevl.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vlcnevl.HRMS.core.entities.concretes.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAnnouncements"})
@Table(name="employers")
public class Employer extends User{
	
	@Column(name="company_name")
	@NotBlank
	@NotNull(message ="required")
	private String companyName;
	
	@Column(name="web_address")
	@NotBlank
	@NotNull(message ="required")
	private String webAddress;
	
	@Column(name="phone_number")
	@NotBlank
	@NotNull(message="required")
	@Pattern(regexp ="(05|5)[0-9][0-9][1-9]([0-9]){6}")
	private String phoneNumber;
	
	public Employer(String email, String password, boolean status, String companyName, String webAddress,
			String phoneNumber) {
		super(email, password, status);
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
	}
	
	
}
