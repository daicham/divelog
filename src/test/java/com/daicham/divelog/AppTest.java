package com.daicham.divelog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author daicham
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest(randomPort = true)
public class AppTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void testHome() {
        RestTemplate template = new TestRestTemplate();
        ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/", String.class);
        assertThat(HttpStatus.OK, is(response.getStatusCode()));
        assertThat("Hello World", is(response.getBody()));
    }
}
