package com.vlcnevl.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlcnevl.HRMS.business.abstracts.LinkService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.core.utilities.results.SuccessDataResult;
import com.vlcnevl.HRMS.core.utilities.results.SuccessResult;
import com.vlcnevl.HRMS.dataAccess.abstracts.LinkDao;
import com.vlcnevl.HRMS.entities.concretes.Link;

@Service
public class LinkManager implements LinkService {
	
	private LinkDao linkDao;
	
	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<List<Link>>(this.linkDao.findAll());
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
		return new SuccessResult("Link added");
	}

	@Override
	public DataResult<List<Link>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Link>>(this.linkDao.getByCandidateId(candidateId));
	}

	@Override
	public Result delete(int linkId) {
		this.linkDao.deleteById(linkId);
		return new SuccessResult("Link deleted");
	}

	@Override
	public Result update(Link link) {
		Link updateLink = this.linkDao.getById(link.getId());
		updateLink.setPath(link.getPath());
		updateLink.setTittle(link.getTittle());
		this.linkDao.save(updateLink);
		return new SuccessResult("Link updated");
	}

}
