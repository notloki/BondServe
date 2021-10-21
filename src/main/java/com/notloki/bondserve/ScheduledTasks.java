package com.notloki.bondserve;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@EnableScheduling
public class ScheduledTasks {

    @Autowired
    ResultRepository resultRepository;
    @Autowired
    BondApi bondApi;

    ScheduledTasks(ResultRepository resultRepository) {}


    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final String DAILY_AT_6AM = "0 0 11 * * * ";
    private static final String DAILY_AT_MIDNIGHT = "0 0 19 * * *";


    @Scheduled(cron = DAILY_AT_6AM)
            public void scheduledStart() {
        BondLauncher bondLauncher = new BondLauncher();
        List<Result> resultList = null;
        resultList = bondLauncher.startBond();
        resultRepository.saveAll(resultList);

    }



    @Scheduled(cron = DAILY_AT_MIDNIGHT)
    public void endOfDay() {
        Ref.hasBondsBeenCheckedToday = false;
    }
}
