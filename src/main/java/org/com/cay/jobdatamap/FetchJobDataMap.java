package org.com.cay.jobdatamap;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

//获取JobDataMap的第一种方法
public class FetchJobDataMap {

	public static void main(String[] args) throws SchedulerException {
		// TODO Auto-generated method stub
		// 创建一个JobDetail实例，将该实例与HelloJob Class绑定
		// 指定唯一标识符和所属的组名
		JobDetail jobDetail = JobBuilder.newJob(HelloJob2.class)
				.withIdentity("myJob", "group1")
				.usingJobData("message", "Hello myJob1")
				.usingJobData("mathJobValue", Math.PI)
				.build();

		// 创建Trigger实例，定义该job立即执行，并且每隔2秒重复执行一次
		// 指定唯一标识符和所属组名，此处的组名与上面的组名名字虽然是一样的，但是两个类不同，所以其实不属于同一个组
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger", "group1")
				.usingJobData("message", "Hello myTrigger1")
				.usingJobData("booleanTriggerValue", true)
				.startNow()
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(2)
						.repeatForever()
				).build();

		// 创建Scheduler实例
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();

		// 将jobDetail和trigger关联起来
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();

	}

}
