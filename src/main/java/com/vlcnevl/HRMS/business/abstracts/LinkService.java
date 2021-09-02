package com.vlcnevl.HRMS.business.abstracts;

import java.util.List;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Link;

public interface LinkService {
	DataResult<List<Link>> getAll();
	Result add(Link link);
	DataResult<List<Link>> getByCandidateId(int candidateId);
	Result delete(int linkId);
	Result update(Link link);
	
}
