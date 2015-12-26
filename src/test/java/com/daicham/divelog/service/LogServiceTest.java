package com.daicham.divelog.service;

import com.daicham.divelog.App;
import com.daicham.divelog.domain.Log;
import com.daicham.divelog.domain.Logs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Time;
import java.util.Date;

import static org.exparity.hamcrest.date.DateMatchers.sameDay;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author daicham
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class LogServiceTest {

    @Autowired
    private LogService service;

    @Test
    public void testInsert() {
        Log log = new Log();
        log.setNo(50);
        log.setDate(new Date());
        log.setTimeIn(new Time(123456));
        log.setTimeOut(new Time(987654));
        log.setBarIn(200);
        log.setBarOut(50);
        log.setMaxDepth(40);
        log.setAvgDepth(20);
        log.setWeight(6);
        log.setAirTemp(30);
        log.setSurfaceTemp(20);
        log.setBottomTemp(20);
        log.setVisibility(30);
        log.setNotes("Had fun!");
        log.setLocation("Izu");
        service.register(log);

        Logs logs = service.findAll();
        assertThat(logs, is(notNullValue()));
        assertThat(logs.size(), is(1));
        log = logs.get(0);
        assertThat(log.getLocation(), is("Izu"));
        assertThat(log.getNo(), is(50));
        assertThat(log.getDate(), sameDay(new Date()));
    }

    @Test
    public void testUpdate() {
        Log log = new Log();
        log.setLocation("Izu");
        service.register(log);
        long id = log.getId();
        assertThat(id, is(greaterThan(0L)));
        log = service.findById(id);
        log.setLocation("chiba");
        service.update(log);

        log = service.findById(id);
        assertThat(log, is(notNullValue()));
        assertThat(log.getLocation(), is("chiba"));
    }

    @Test
    public void testDelete() {
        Log log = new Log();
        log.setLocation("Izu");
        service.register(log);
        long id = log.getId();
        assertThat(id, is(greaterThan(0L)));
        service.deleteById(id);
        log = service.findById(id);
        assertThat(log, is(nullValue()));
    }
}