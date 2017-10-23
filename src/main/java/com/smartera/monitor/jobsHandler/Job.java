package com.smartera.monitor.jobsHandler;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Job {

	private static 	String jobId;
	private static	String	jobStory;
	private static	HashMap<String, Object>	jobDetails;
	

	private static	String	STATUS	=	JobStatus.PROCESSING;
	
	public Job(String jobId, String jobStory){
		this.jobId		=	jobId;
		this.jobStory	=	jobStory;
	}
	
	public Job(String jobId, String jobStory, HashMap<String, Object> jobDetails){
		this.jobId		=	jobId;
		this.jobStory	=	jobStory;
		this.jobDetails	=	jobDetails;
	}
	
	public static Object getJobDetails() {
		return jobDetails;
	}

	public static void setJobDetails(HashMap<String, Object> jobDetails) {
		Job.jobDetails = jobDetails;
	}
	
	public static String getJobId() {
		return jobId;
	}
	
	public static void updateStatus(String newStatus){
		Job.STATUS	=	newStatus;
	}
	
	public static void setJobId(String jobId) {
		Job.jobId = jobId;
	}
	
	public static String getJobStory() {
		return jobStory;
	}
	
	public static void setJobStory(String jobStory) {
		jobStory = jobStory;
	}
	
	public static JSONObject toJson() throws JSONException{
		
		JSONObject	jobInJsonFormat	=	new JSONObject();
		
		//TODO-j should throw exception in case Job story is null or Status is not set
		jobInJsonFormat.put("job_ID"	, 	Job.jobId);
		jobInJsonFormat.put("job_STORY"	, 	Job.jobStory);
		jobInJsonFormat.put("job_DETAILS",	Job.jobDetails);
		jobInJsonFormat.put("job_STATUS", 	STATUS);
		
		return jobInJsonFormat;
	}
	
	public static HashMap<String, Object> toHashMap() {
		
		HashMap<String, Object>	jobAsHashMap	=	new HashMap<String, Object>();
		//TODO-j should throw exception in case Job story is null or Status is not set
		jobAsHashMap.put("job_ID",		Job.jobId);
		jobAsHashMap.put("job_STORY", 	Job.jobStory);
		jobAsHashMap.put("job_DETAILS",	Job.jobDetails);
		jobAsHashMap.put("job_STATUS", 	STATUS);
		
		return jobAsHashMap;
	}
		
}
