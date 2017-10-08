package com.smartera.monitor.jobsHandler;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.smartera.socialhub.HttpUtility;

import configurations.RegisteredIPs;

public class JobHandler {
	
	private static Job job	=	null;
	private static JobHandler instance	=	null;
	
	private JobHandler(){
		
	}
	
	public static JobHandler getInstance(){
		
		if(JobHandler.instance	==	null){
			JobHandler.instance		=	new JobHandler();
			
			return JobHandler.instance;
		
		}else{
			
			return JobHandler.instance;
		}
	}
	
	public static Job getCurrentJob(){
		return JobHandler.job;
	}
	
	
	public static Job startNewJob(String jobId, String jobStory) throws JSONException{
		
		JobHandler.job	=	new Job(jobId, jobStory);
		JobHandler.report(JobStatus.PROCESSING);
		
		return JobHandler.job;
	}
	
	public static void	completeJob() throws JSONException{
			
		JobHandler.report(JobStatus.SUCESS);
	}
	
	public static void reportFailedJob() throws JSONException{
		JobHandler.report(JobStatus.FAIL);
		
	}
	
	private static void report(String jobStatus) throws JSONException{
		
		//report to monitor service ReportJobStatusServlet
		HashMap<String, Object> job 	=	JobHandler.getCurrentJob().toHashMap();
		
		JSONObject response = HttpUtility.doPostRequest(RegisteredIPs.monitoring_service_ip + RegisteredIPs.monitoring_service_ip + "/ReportJobStatus", "JobHandler", job, null, null, JSONObject.class);
	
	}
	
	
}
