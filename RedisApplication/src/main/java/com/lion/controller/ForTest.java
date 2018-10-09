package com.lion.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Jipengchao
 * @CreatedTime: 2018/10/8 11:20
 */

public class ForTest {
    public static void main(String[] args) {
       /* for (int i = 0; i < 3; i++) {
            System.out.println("数字"+i);;

        }*/
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("数字验证"+list.get(i));

        }
    }
}
