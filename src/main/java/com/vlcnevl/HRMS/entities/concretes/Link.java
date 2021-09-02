package com.vlcnevl.HRMS.entities.concretes;

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


import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="links")
public class Link {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;
	
	@Column(name="tittle")
	@NotBlank(message = "required")
	@NotNull
	private String tittle;
	
	@Column(name="path")
	@NotBlank(message = "required")
	@NotNull
	private String path;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Candidate.class )
	@JoinColumn(name = "candidate_id",nullable = false)
	private Candidate candidate;
}
