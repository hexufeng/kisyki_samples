package com.kisyki.os_schedule;


import java.util.ArrayList;
import java.util.List;

/**
 * author: biscuit
 * Date: 12/26/16
 */
public class ServiceRecord {
  private Long processerId;
  private String processerName;
  private int startTime;
  private int completeTime;
  private List<ServicePeriod> periods;

  public void init(Processer processer) {
    this.setPeriods(new ArrayList<>());
    this.setProcesserName(processer.getData().getName());
  }

  public int getStartTime() {
    return startTime;
  }

  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  public int getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(int completeTime) {
    this.completeTime = completeTime;
  }

  public List<ServicePeriod> getPeriods() {
    return periods;
  }

  public void setPeriods(List<ServicePeriod> periods) {
    this.periods = periods;
  }

  public String getProcesserName() {
    return processerName;
  }

  public void setProcesserName(String processerName) {
    this.processerName = processerName;
  }

  public Long getProcesserId() {
    return processerId;
  }

  public void setProcesserId(Long processerId) {
    this.processerId = processerId;
  }

  public static class ServicePeriod {
    private int beginTime;
    private int endTime;

    public int getBeginTime() {
      return beginTime;
    }

    public void setBeginTime(int beginTime) {
      this.beginTime = beginTime;
    }

    public int getEndTime() {
      return endTime;
    }

    public void setEndTime(int endTime) {
      this.endTime = endTime;
    }
  }
}
