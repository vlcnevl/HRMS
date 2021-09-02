package com.vlcnevl.HRMS.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vlcnevl.HRMS.entities.concretes.Candidate;
import com.vlcnevl.HRMS.entities.concretes.City;
import com.vlcnevl.HRMS.entities.concretes.CoverLetter;
import com.vlcnevl.HRMS.entities.concretes.Education;
import com.vlcnevl.HRMS.entities.concretes.Experience;
import com.vlcnevl.HRMS.entities.concretes.Language;
import com.vlcnevl.HRMS.entities.concretes.Link;
import com.vlcnevl.HRMS.entities.concretes.Photo;
import com.vlcnevl.HRMS.entities.concretes.Skill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	
	@JsonIgnore
	private Candidate candidate;
	private List<City> cities;
	private List<Education> educations;
	private List<Experience> experiences;
	private List<Language> languages;
	private List<CoverLetter> coverLetters;
	private List<Skill> skills;
	private List<Photo> photos;
	private List<Link> links;
}
