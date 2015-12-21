package com.daicham.divelog.service;

import com.daicham.divelog.App;
import com.daicham.divelog.domain.Log;
import com.daicham.divelog.domain.Logs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        log.setPlace("Izu");
        service.register(log);

        Logs logs = service.findAll();
        assertThat(logs, is(notNullValue()));
        assertThat(logs.size(), is(1));
        assertThat(logs.get(0).getPlace(), is("Izu"));
    }

    @Test
    public void testUpdate() {
        Log log = new Log();
        log.setPlace("Izu");
        service.register(log);
        long id = log.getId();
        assertThat(id, is(greaterThan(0L)));
        log = service.findById(id);
        log.setPlace("chiba");
        service.update(log);

        log = service.findById(id);
        assertThat(log, is(notNullValue()));
        assertThat(log.getPlace(), is("chiba"));
    }

    @Test
    public void testDelete() {
        Log log = new Log();
        log.setPlace("Izu");
        service.register(log);
        long id = log.getId();
        assertThat(id, is(greaterThan(0L)));
        service.deleteById(id);
        log = service.findById(id);
        assertThat(log, is(nullValue()));
    }
}