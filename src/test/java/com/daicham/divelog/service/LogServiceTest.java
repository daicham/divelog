package com.daicham.divelog.service;

import com.daicham.divelog.App;
import com.daicham.divelog.domain.Log;
import com.daicham.divelog.domain.Logs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalTime;

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
        log.setDate(LocalDate.of(2015, 12, 26));
        log.setLocation("Izu");
        log.setTimeIn(LocalTime.of(8, 52));
        log.setTimeOut(LocalTime.of(23, 30));
        log.setBarIn(200);
        log.setBarOut(50);
        log.setMaxDepth(40.0f);
        log.setAvgDepth(20.1f);
        log.setWeight(6);
        log.setAirTemp(30.2f);
        log.setSurfaceTemp(20.3f);
        log.setBottomTemp(20.4f);
        log.setVisibility(30);
        log.setNotes("Had fun!");
        service.register(log);

        Logs logs = service.findAll();
        assertThat(logs, is(notNullValue()));
        assertThat(logs.size(), is(1));
        log = logs.get(0);
        assertThat(log.getNo(), is(50));
        assertThat(log.getDate(), is(LocalDate.of(2015, 12, 26)));
        assertThat(log.getLocation(), is("Izu"));
        assertThat(log.getTimeIn(), is(LocalTime.of(8, 52)));
        assertThat(log.getTimeOut(), is(LocalTime.of(23, 30)));
        assertThat(log.getBarIn(), is(200));
        assertThat(log.getBarOut(), is(50));
        assertThat(log.getMaxDepth(), is(40.0f));
        assertThat(log.getAvgDepth(), is(20.1f));
        assertThat(log.getWeight(), is(6));
        assertThat(log.getAirTemp(), is(30.2f));
        assertThat(log.getSurfaceTemp(), is(20.3f));
        assertThat(log.getBottomTemp(), is(20.4f));
        assertThat(log.getVisibility(), is(30));
        assertThat(log.getNotes(), is("Had fun!"));
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