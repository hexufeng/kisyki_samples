package com.kisyki.os_schedule;

import java.util.ArrayList;
import java.util.List;

/**
 * author: biscuit
 * Date: 12/26/16
 *
 * First Come First Serve
 */
public class FCFSScheduler {
  public static List<ServiceRecord> execute(List<Processer> processers) {
    List<ServiceRecord> result = new ArrayList<>();
    int timer = 0;
    for (Processer processer : processers) {
      processer.start(timer);
      processer.ready(timer);
      processer.running(timer);
      timer += processer.getData().getExecuteTime();
      ServiceRecord record = processer.terminate(timer);

      result.add(record);
    }

    return result;
  }
}
