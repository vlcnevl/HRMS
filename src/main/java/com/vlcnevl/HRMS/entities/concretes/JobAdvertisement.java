package com.vlcnevl.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisement")
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="tittle")
	@NotNull
	private String tittle;
	
	@Column(name="description")
	@NotNull
	private String description;
	
	@Column(name="min_salary")
	@NotNull
	@PositiveOrZero
	private int minSalary;
	
	@Column(name="max_salary")
	@NotNull
	@PositiveOrZero
	private int maxSalary;
	
	@Column(name="open_position")
	@Positive
	private int openPosition;
	
	@Column(name="job_type")
	private String jobType;
	
	@Column(name="created_date" , columnDefinition = "Date default CURRENT_DATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate createdDate;
	
	@Column(name="expiration_date")
	@NotNull
	@Future
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate expirationDate;
	
	@Column(name="is_active")
	@NotNull
	private boolean isActive;
	 
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Employer.class)
	@JoinColumn(name= "employer_id")
	private Employer employer;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
	@JoinColumn(name  = "department_id")
	private Department department;  
	
	@ManyToOne(fetch = FetchType.LAZY , targetEntity = City.class)
	@JoinColumn(name="city_id")
	private City city;
	
}
