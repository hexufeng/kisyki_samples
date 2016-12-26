package com.kisyki.os_schedule;

import java.util.List;

/**
 * author: biscuit
 * Date: 12/26/16
 */
public class Printer {

  public static void print(Processer processer, String str) {
    System.out.print(processer.getData().getId() + "|" + processer.getData().getName() + "|" + str);
  }

  public static void println(Processer processer, String str) {
    System.out.println(processer.getData().getId() + "|" + processer.getData().getName() + "|" + str);
  }

  public static void println(List<ServiceRecord> records) {
    records.forEach(record -> {
      System.out.println("----------------------" + record.getProcesserId() + "|"
          + record.getProcesserName() + "---------------------");
      record.getPeriods().forEach(servicePeriod -> {
        System.out.println(servicePeriod.getBeginTime() + "-------" + servicePeriod.getEndTime());
      });
      System.out.println("process start at " + record.getStartTime());
      System.out.println("process terminate at " + record.getCompleteTime());

    });
  }
}
