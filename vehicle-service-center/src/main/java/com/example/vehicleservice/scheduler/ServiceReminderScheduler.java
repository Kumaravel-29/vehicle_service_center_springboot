package com.example.vehicleservice.scheduler;
import org.springframework.scheduling.annotation.Scheduled; import org.springframework.stereotype.Component; import org.slf4j.Logger; import org.slf4j.LoggerFactory;
@Component public class ServiceReminderScheduler {private static final Logger log=LoggerFactory.getLogger(ServiceReminderScheduler.class); @Scheduled(cron="0 0 9 * * *") public void dailyReminderJob(){log.info("Daily service reminder scheduler executed");}}
