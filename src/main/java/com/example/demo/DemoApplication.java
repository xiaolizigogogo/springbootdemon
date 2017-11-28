package com.example.demo;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@RestController
@EnableKafka
public class DemoApplication {
	@Autowired
	private KafkaTemplate<String, String> template;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private MongoTemplate mongoTemplate;
	private final CountDownLatch latch = new CountDownLatch(4);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("testRabbit")
	public void rabbitTemplate(String... args) throws Exception {
		User person = new User();
		person.setAge(15);
		person.setName("zhangsan");
		person.setId("123");
		mongoTemplate.insert(person);
	}
	@RequestMapping("queryMondb")
	public void queryMondb(String... args) throws Exception {
		String personName=mongoTemplate.getCollectionName(User.class);
		User person = new User();
		person.setAge(15);
		person.setName("zhangsan");
		person.setId("123");
		mongoTemplate.insert(person);
	}


	@RequestMapping("test")
	public void run(String... args) throws Exception {
		this.template.send("myTopic", "foo1");
		this.template.send("myTopic", "foo2");
		this.template.send("myTopic", "foo3");
		this.template.send("myTopic", "hi", "foo4");
		this.template.send("myTopic2", "2", "foo5");
		log.info("All received");
	}

}
