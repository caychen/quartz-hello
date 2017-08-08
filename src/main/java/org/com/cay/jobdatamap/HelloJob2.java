package org.com.cay.jobdatamap;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

public class HelloJob2 implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		//打印当前执行时间
		System.out.println("当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println(jobKey.getGroup() + " : " + jobKey.getName());
		
		TriggerKey triggerKey = context.getTrigger().getKey();
		System.out.println(triggerKey.getGroup() + " : " + triggerKey.getName());
		
		JobDataMap jobDataMap = context.getMergedJobDataMap();//调用getMergedJobDataMap获取JobDataMap，如果有相同的key，那么后面的value值会覆盖前面的value值
		System.out.println("jobDetail message: " + jobDataMap.get("message"));
		System.out.println("jobDetail value: " + jobDataMap.getDoubleValue("mathJobValue"));
		
		System.out.println("trigger message: " + jobDataMap.get("message"));
		System.out.println("trigger value: " + jobDataMap.get("booleanTriggerValue"));
		System.out.println("========================");
	}

}
