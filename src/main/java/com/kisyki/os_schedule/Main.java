package com.kisyki.os_schedule;

import java.util.Collections;
import java.util.List;

import static com.kisyki.os_schedule.Printer.*;

/**
 * author: biscuit
 * Date: 12/26/16
 */
public class Main {

  public static void main(String[] args) {
    final List<Processer> processers = ProcesserBuilder.getProcessers();

    /**
     * sort processers by it's arriveTime
     */
    Collections.sort(processers, (p1, p2) -> {
      int c = p1.getData().getArriveTime() - p2.getData().getArriveTime();
      if (c == 0) return 0;
      if (c > 0) return 1;
      else return -1;
    });

    println(FCFSScheduler.execute(processers));
    println(SJNScheduler.execute(processers));
    println(PriorityScheduler.execute(processers));
    println(SRTScheduler.execute(processers));
    println(RRScheduler.execute(processers));
  }

}
