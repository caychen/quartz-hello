package org.com.cay.crontrigger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		System.out.println("当前执行时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
//		Trigger trigger = context.getTrigger();
//		System.out.println("开始时间：" + trigger.getStartTime());
//		System.out.println("结束时间：" + trigger.getEndTime());
		System.out.println("===============================");
	}

}

