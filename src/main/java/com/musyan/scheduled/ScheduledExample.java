package com.musyan.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledExample {

    @Scheduled(cron = "0 44 15 * * *")
    public void write1To10(){
        for(int i=0;i<10;i++){
            System.out.print(i+" ");
        }


    }
}
