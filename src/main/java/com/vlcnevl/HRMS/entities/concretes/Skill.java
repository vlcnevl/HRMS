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
@Table(name="skills")
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@Column(name="skill_name")
	@NotBlank(message = "required")
	@NotNull
	private String skillName;
	
	@Column(name="skill_level")
	@NotBlank(message = "required")
	@NotNull
	private int skillLevel;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Candidate.class)
	@JoinColumn(name="candidate_id" , nullable = false)
	private Candidate candidate;
	
}
