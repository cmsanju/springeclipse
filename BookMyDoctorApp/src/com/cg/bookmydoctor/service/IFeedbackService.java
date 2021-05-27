package com.cg.bookmydoctor.service;

import java.util.List;

import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;

public interface IFeedbackService {

	public FeedBack addFeedback(FeedBack fdb);
	public FeedBack getFeedback(FeedBack fdb);
	public List<FeedBack> getAllFeedback(Doctor doc);
	
	
}
