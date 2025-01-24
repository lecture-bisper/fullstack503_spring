package bitc.fullstack503.outsidedir.util;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//  @EnableScheduling : 스프링 프레임워크에 지정한 형식대로 스케줄링을 하기 위한 어노테이션
//  많은 개수의 스케줄링이 필요할 경우 SchedulingConfigurer 를 상속 받아 Thread pool 을 사용해야 함

//  @Scheduled(옵션) : 반복 동작할 스케줄 시간을 지정하기 위한 어노테이션
//  initialDelay : 지정한 시간이 지난 후 반복 동작이 시작
//  fixedDelay : 이전에 실행된 내용이 종료된 시간부터 지정한 시간이 지난 후 동작
//  fixedRate : 이전에 실행된 내용이 시작된 시간부터 지정한 시간이 지난 후 동작
//  cron : cron 문자열 방식으로 지정된 시간마다 동작
//  <초> <분> <시> <일> <월> <요일> 로 표현하고 년은 생략 가능
//  초 : 0 ~ 59, 분 : 0 ~ 59, 시 : 0 ~ 23, 일 : 1 ~ 31, 월 : 1 ~ 12, 요일 : 1 ~ 7(1 = 일, 2 = 월, 7 = 토)
//  * * * * * * : 매 초 마다 동작
//  */10 * * * * * : 10초 마다 동작
//  30 * * * * * : 매분의 30초 정각마다 동작
//  * */10 * * * * : 매 10분 마다 동작
//  * 10 * * * * : 매 시간의 10분 정각마다 동작
//  0 0 0 * * * : 매일 0시 0분 0초 마다 동작
//  0 0 0 * * 2-6 : 매월 매일 월요일 ~ 금요일까지 0시 0분 0초에 동작

@Component
@EnableScheduling
public class MySchedule {
  private int cronCount = 0;
  private int delayCount = 0;
  private int rateCount = 0;

  @Scheduled(cron = "*/3 * * * * *")
  public void scheduleCron() {
    System.out.println("cronCount : " + cronCount + ", 스레드 : " + Thread.currentThread().getName());
    cronCount++;
  }

  @Scheduled(fixedDelay = 5000)
  public void scheduleFixedDelay() {
    System.out.println("delayCount : " + delayCount + ", 스레드 : " + Thread.currentThread().getName());
    delayCount++;
  }

  @Scheduled(fixedDelay = 10000)
  public void scheduleFixedRate() {
    System.out.println("rateCount : " + rateCount + ", 스레드 : " + Thread.currentThread().getName());
    rateCount++;
  }
}












