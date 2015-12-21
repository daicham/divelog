package com.daicham.divelog.service;

import com.daicham.divelog.App;
import com.daicham.divelog.domain.Log;
import com.daicham.divelog.domain.Logs;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
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
        service.regsit(log);

        Logs logs = service.findAll();
        assertThat(logs, is(notNullValue()));
        assertThat(logs.size(), is(1));
        assertThat(logs.get(0).getPlace(), is("Izu"));
    }

    @Test
    @Ignore
    public void testUpdate() {
        Log log = new Log();
        log.setPlace("Izu");
        service.regsit(log);

        log = service.findById(1); //FIXME: Don't use magic number
        log.setPlace("chiba");
        service.update(log);

        log = service.findById(1);
        assertThat(log, is(notNullValue()));
        assertThat(log.getPlace(), is("chiba"));
    }

    @Test
    @Ignore
    public void testDelete() {
        Log log = new Log();
        log.setPlace("Izu");
        service.regsit(log);

        service.deleteById(1); //FIXME: Don't use magic number
        log = service.findById(1);
        assertThat(log, is(nullValue()));
    }
}