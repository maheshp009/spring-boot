package com.ani.spring;

import com.ani.spring.controller.CustomerController;
import com.ani.spring.util.DateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

import java.time.LocalDate;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration // 👉 From where scanning needs to started
//@ComponentScan //
public class SpringIntroApplication {

	private void normalDemo() {
		DateUtil util1 = new DateUtil();
		long days = util1.diffFromToday(LocalDate.of(2000,1,1));
		System.out.println("Days Are " + days);

//		DateUtil util2 = new AdvanceDateUtil();

//		CustomerController controller1 = new CustomerController(util1);
//		CustomerController controller2 = new CustomerController(util2);
	}

	public static void main(String[] args) {
		// java -Dspring.profiles.active=prod -jar spring-intro-0.0.1-SNAPSHOT.jar
//		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
		ApplicationContext ctx = SpringApplication.run(SpringIntroApplication.class, args);

//		Arrays.stream(
//				ctx.getBeanDefinitionNames() // convert array to stream
//		).forEach(System.out::println);

//		DateUtil util = ctx.getBean(DateUtil.class);
//		long days = util.diffFromToday(LocalDate.of(1999,1,1));
//		System.out.println("Days Are "+days);
//
		CustomerController controller = ctx.getBean(CustomerController.class);
		controller.calculateAge();

	}
}
