package com.vlcnevl.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.vlcnevl.HRMS.business.abstracts.CandidateService;
import com.vlcnevl.HRMS.business.abstracts.CityService;
import com.vlcnevl.HRMS.business.abstracts.CoverLetterService;
import com.vlcnevl.HRMS.business.abstracts.DepartmentService;
import com.vlcnevl.HRMS.business.abstracts.EducationService;
import com.vlcnevl.HRMS.business.abstracts.ExperienceService;
import com.vlcnevl.HRMS.business.abstracts.LanguageService;
import com.vlcnevl.HRMS.business.abstracts.LinkService;
import com.vlcnevl.HRMS.business.abstracts.PhotoService;
import com.vlcnevl.HRMS.business.abstracts.SkillService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.ErrorResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.core.utilities.results.SuccessDataResult;
import com.vlcnevl.HRMS.core.utilities.results.SuccessResult;
import com.vlcnevl.HRMS.dataAccess.abstracts.CandidateDao;
import com.vlcnevl.HRMS.entities.concretes.Candidate;
import com.vlcnevl.HRMS.entities.dtos.CvDto;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private CityService cityService;
	private CoverLetterService coverLetterService;
	private DepartmentService departmentService;
	private EducationService educationService;
	private ExperienceService experienceService;
	private LanguageService languageService;
	private LinkService linkService;
	private PhotoService photoService;
	private SkillService skillService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao , CityService cityService, CoverLetterService coverLetterService, 
			DepartmentService departmentService, EducationService educationService, ExperienceService experienceService,
			LanguageService languageService, LinkService linkService ,@Lazy PhotoService photoService, SkillService skillService) {
		super();
		this.candidateDao = candidateDao;
		this.cityService = cityService;
		this.coverLetterService = coverLetterService;
		this.departmentService = departmentService;
		this.educationService = educationService;
		this.experienceService = experienceService;
		this.languageService = languageService;
		this.linkService = linkService;
		this.photoService = photoService;
		this.skillService = skillService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);
		
		return new SuccessResult("Candidate added");	
	}

	@Override
	public DataResult<Candidate> getById(int candidateId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(candidateId));
	}

	@Override
	public DataResult<CvDto> getCvById(int id) {
		
		CvDto cv = new CvDto();
		cv.setCandidate(this.getById(id).getData());
		cv.setPhotos(this.photoService.getByCandidateId(id).getData());
		cv.setLanguages(this.languageService.getByCandidateId(id).getData());
		cv.setCoverLetters(this.coverLetterService.getByCandidateId(id).getData());
		cv.setEducations(this.educationService.getByCandidateIdOrderByGraduationDateASC(id).getData());
		cv.setExperiences(this.experienceService.getByCandidateId(id).getData());
		cv.setLinks(this.linkService.getByCandidateId(id).getData());
		cv.setSkills(this.skillService.getByCandidateId(id).getData());
		return new SuccessDataResult<>(cv,"your cv");
	}


	@Override
	public DataResult<Candidate> getByEmailOrNationalityId(String email, String nationalityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Candidate> getByNationalityId(String nationalityId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByNationalityId(nationalityId));
	}



	@Override
	public Result login(String email, String password) {
		var result = this.candidateDao.findCandidateByEmailAndPassword(email, password);
		
		if(result!=null)
		{
			return new SuccessResult("Login successfully");
		}
		return new ErrorResult("Login unsuccessfull");
	}






}
