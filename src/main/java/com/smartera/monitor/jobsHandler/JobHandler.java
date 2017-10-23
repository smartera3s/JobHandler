package com.smartera.monitor.jobsHandler;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

import com.smartera.socialhub.HttpUtility;


public class JobHandler {
	
	private static Job job	=	null;
	private static JobHandler instance	=	null;
	private static String reportDestination	=	null;
	
	public JobHandler reportTo(String reportDestination){
		JobHandler.instance.reportDestination	=	reportDestination;
		return JobHandler.instance;
	}
	
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
	
	
	public Job startNewJob(String jobId, String jobStory) throws Exception{
		
		JobHandler.job	=	new Job(jobId, jobStory);
		JobHandler.report(JobStatus.PROCESSING);
		
		return JobHandler.job;
	}
	
	public Job startNewJob(String jobId, String jobStory, HashMap<String, Object> jobDetails) throws Exception{
		
		JobHandler.job	=	new Job(jobId, jobStory, jobDetails);
		JobHandler.report(JobStatus.PROCESSING);
		
		return JobHandler.job;
	}

	public static void	completeJob() throws Exception{
			
		JobHandler.report(JobStatus.SUCESS);
	}
	
	public static void reportFailedJob() throws Exception{
		JobHandler.report(JobStatus.FAIL);
		
	}
	
	private static void report(String jobStatus) throws Exception{
		
		if(reportDestination == null) throw new Exception("Undefind report destination, use reportTo() to set the destination");
		//report to monitor service ReportJobStatusServlet
		JobHandler.getCurrentJob().updateStatus(jobStatus);
		JSONObject job 	=	JobHandler.getCurrentJob().toJson();
		
		HashMap<String, Object> params	=	new HashMap<String, Object>();
		params.put("service_name", "JobHandler");
		params.put("job", job);

		JSONObject headers =  new JSONObject();

		JSONObject response = HttpUtility.doPostRequest(reportDestination , "monitoringservice", params, headers, null, JSONObject.class);
	
	}
	
	
	
	
}
