package com.daicham.divelog.web;

import com.daicham.divelog.App;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author daicham
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest(randomPort = true)
public class LogControllerTest {
    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mock;

    @Before
    public void setUp() {
        mock = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testIndex() throws Exception {
        mock.perform(get("/logs"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("message"));
    }
}