package com.vlcnevl.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="photos")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="image_path")
	@NotBlank(message = "required")
	@NotNull
	private String imagePath;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="cloudinary_id")
	@NotBlank(message = "required")
	@NotNull
	private String cloudinaryId;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Candidate.class)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
}
