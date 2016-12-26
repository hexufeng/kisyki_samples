package com.kisyki.os_schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * author: biscuit
 * Date: 12/26/16
 */
public class ProcesserBuilder {


  public static List<Processer> getProcessers() {
    List<Processer> result = new ArrayList<>();
    System.out.println("End with '\\e' and input Processer's info split with blank like " +
        "this(Name is string, others are int):\n Name ArraiveTime ExecuteTime");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    Long id = 0L;
    String input = "";
    try {
      while (!(input = in.readLine()).equals("\\e")) {
        String[] infos = input.split(" ");
        if (infos.length < 3) {
          System.out.println("input error! please conform that you have inputted Name, ArriveTime, " +
              "ExecuteTime which are types of string, int, int");
          System.exit(0);
        }
        Processer.PData data = new Processer.PData();
        data.setId(id++);
        data.setName(infos[0]);
        data.setArriveTime(Integer.valueOf(infos[1]));
        data.setExecuteTime(Integer.valueOf(infos[2]));
        Processer processer = new Processer(data);
        result.add(processer);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (NumberFormatException  e) {
      System.out.println("input error! please conform that you have inputted Name, ArriveTime, " +
          "ExecuteTime which are types of string, int, int");
      System.exit(0);
    }

    return result;
  }
}
