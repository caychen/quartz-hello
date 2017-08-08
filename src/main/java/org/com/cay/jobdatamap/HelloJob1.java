package org.com.cay.jobdatamap;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

public class HelloJob1 implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		//打印当前执行时间
		System.out.println("当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println(jobKey.getGroup() + " : " + jobKey.getName());
		
		TriggerKey triggerKey = context.getTrigger().getKey();
		System.out.println(triggerKey.getGroup() + " : " + triggerKey.getName());
		
		JobDataMap jobDetailJobDataMap = context.getJobDetail().getJobDataMap();
		JobDataMap triggerJobDataMap = context.getTrigger().getJobDataMap();
		
		System.out.println("jobDetail message: " + jobDetailJobDataMap.get("message"));
		System.out.println("jobDetail value: " + jobDetailJobDataMap.getDoubleValue("mathJobValue"));
		
		System.out.println("trigger message: " + triggerJobDataMap.get("message"));
		System.out.println("trigger value: " + triggerJobDataMap.get("booleanTriggerValue"));
		System.out.println("========================");
	}

}
