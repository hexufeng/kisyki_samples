package com.kisyki.os_schedule;

import java.util.ArrayList;

import static com.kisyki.os_schedule.Printer.*;

/**
 * author: biscuit
 * Date: 12/26/16
 */
public class Processer {
  private PData data;
  private ServiceRecord record;
  private ServiceRecord.ServicePeriod period;

  public Processer(PData data) {
    this.data = data;
    record = new ServiceRecord();
    record.init(this);
  }

  public void start(int nowTime) {
    println(this, "start!");
    record.setStartTime(nowTime);
  }

  public void ready(int nowTime) {
    println(this, "ready!");
    period = new ServiceRecord.ServicePeriod();
    period.setBeginTime(nowTime);
  }

  public void running(int nowTime) {
    println(this, "running!");
  }

  public void waiting(int nowTime) {
    println(this, "waiting!");
    period.setEndTime(nowTime);
  }

  public ServiceRecord terminate(int nowTime) {
    println(this, "terminate!");
    period.setEndTime(nowTime);
    record.getPeriods().add(period);
    record.setCompleteTime(nowTime);
    return this.record;
  }

  public PData getData() {
    return data;
  }

  public void setData(PData data) {
    this.data = data;
  }

  public static class PData {
    private Long id;
    private String name;
    private int arriveTime; //processer arrive time
    private int executeTime;  //processer complete spending all running time

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getArriveTime() {
      return arriveTime;
    }

    public void setArriveTime(int arriveTime) {
      this.arriveTime = arriveTime;
    }

    public int getExecuteTime() {
      return executeTime;
    }

    public void setExecuteTime(int executeTime) {
      this.executeTime = executeTime;
    }
  }
}
