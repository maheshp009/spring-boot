package com.ani.restclient;

import com.ani.restclient.client.DemoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestClientAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RestClientAppApplication.class, args);

		DemoClient client = ctx.getBean(DemoClient.class);
		client.showMobileV2();
	}

}
