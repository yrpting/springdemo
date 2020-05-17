package com.springdemo.test;

import com.alibaba.fastjson.JSON;
import com.springmvc.model.User;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void testStream() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("yan1");
        user.setSex((byte) 1);
        list.add(user);
        user = new User();
        user.setId(2);
        user.setName("yan2");
        user.setSex((byte) 2);
        list.add(user);
        user = new User();
        user.setId(3);
        user.setName("yan3");
        user.setSex((byte) 2);
        list.add(user);
        List<String> collect = list.parallelStream().map((u -> u.getName())).collect(Collectors.toList());
        User user3 = list.parallelStream().reduce(((user1, user2) -> {
            User u = new User();
            u.setId(user1.getId() + user2.getId());
            return u;
        })).get();
        System.out.println(JSON.toJSONString(collect));
        System.out.println(user3);
        UserStatistic result = list.parallelStream().map(user1 -> {
            UserStatistic statistic = new UserStatistic();
            if (user1.getSex() == (byte) 1) {
                statistic.setBoyCnt(1);
            } else {
                statistic.setGirlcnt(1);
            }
            return statistic;
        }).reduce(((userStatistic, userStatistic2) -> {
            userStatistic.setGirlcnt(userStatistic.getGirlcnt() + userStatistic2.getGirlcnt());
            userStatistic.setBoyCnt(userStatistic.getBoyCnt() + userStatistic2.getBoyCnt());
            return userStatistic;
        })).get();
        System.out.println(JSON.toJSONString(result));
    }

    class UserStatistic {
        private Integer boyCnt = 0;
        private Integer girlcnt = 0;

        public Integer getBoyCnt() {
            return boyCnt;
        }

        public void setBoyCnt(Integer boyCnt) {
            this.boyCnt = boyCnt;
        }

        public Integer getGirlcnt() {
            return girlcnt;
        }

        public void setGirlcnt(Integer girlcnt) {
            this.girlcnt = girlcnt;
        }
    }
}
