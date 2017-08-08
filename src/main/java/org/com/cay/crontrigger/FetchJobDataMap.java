
package org.com.cay.crontrigger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

//获取JobDataMap的第二种方法
public class FetchJobDataMap {

	public static void main(String[] args) throws SchedulerException {
		// TODO Auto-generated method stub
		// 打印当前执行时间
		System.out.println("当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		// 创建一个JobDetail实例，将该实例与HelloJob Class绑定
		// 指定唯一标识符和所属的组名
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity("myJob", "group1")
				.build();

		//使用CronTrigger
		CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
				.withIdentity("cronTrigger1", "group1")
				.withSchedule(
						CronScheduleBuilder
						//.cronSchedule("* * * * * ?")//每秒触发一次
						//.cronSchedule("0 15 10 * * ?")//每天10点15分触发一次
						//.cronSchedule("0/5 * 14,16 * * ?")//每天14点到14点59分，16点到16点59分，每5秒触发一次
						//.cronSchedule("0 15 10 ? * 2-6")//每月周一至周五的10点15分触发一次
						//.cronSchedule("* * * L * ?")//每月最后一天
						.cronSchedule("* * * ? * 6#3")//每月第三个周五
				).build();
		
		// 创建Scheduler实例
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();

		// 将jobDetail和trigger关联起来
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();

	}

}

