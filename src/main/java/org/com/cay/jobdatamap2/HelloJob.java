package org.com.cay.jobdatamap2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

public class HelloJob implements Job {

	private String message;
	private double mathJobValue;
	private boolean booleanTriggerValue;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getMathJobValue() {
		return mathJobValue;
	}

	public void setMathJobValue(double mathJobValue) {
		this.mathJobValue = mathJobValue;
	}

	public boolean isBooleanTriggerValue() {
		return booleanTriggerValue;
	}

	public void setBooleanTriggerValue(boolean booleanTriggerValue) {
		this.booleanTriggerValue = booleanTriggerValue;
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub

		// 打印当前执行时间
		System.out.println("当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println(jobKey.getGroup() + " : " + jobKey.getName());

		TriggerKey triggerKey = context.getTrigger().getKey();
		System.out.println(triggerKey.getGroup() + " : " + triggerKey.getName());

		System.out.println("jobDetail message: " + message);
		System.out.println("jobDetail value: " + mathJobValue);

		System.out.println("trigger message: " + message);
		System.out.println("trigger value: " + booleanTriggerValue);
		System.out.println("========================");
	}

}
