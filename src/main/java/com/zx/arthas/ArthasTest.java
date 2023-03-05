package com.zx.arthas;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class ArthasTest {

    public static void main(String[] args) throws InterruptedException {
        ArthasTest arthasTest = new ArthasTest();
        arthasTest.justRun();
    }

    void  justRun() throws InterruptedException {
        while(Instant.now().isBefore(Instant.now().plus(1, ChronoUnit.DAYS))) {
            System.out.println("running");
            TimeUnit.SECONDS.sleep(1);
        }
    }
    void seeThread() {
        Thread t = new Thread(() -> {
            System.out.println("this is a thread");
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setName("XIAO PANG JIANG JUN!");
        t.start();
    }

    private User getUser(Integer userId,String userName) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        return user;
    }

    static class User{
        private Integer userId;
        private String  userName;
        private Integer age;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
