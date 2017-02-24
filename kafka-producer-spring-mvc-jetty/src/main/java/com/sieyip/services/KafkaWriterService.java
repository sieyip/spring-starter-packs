package com.sieyip.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaWriterService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${kafka.partitions}")
	private int partitions;

	public void writeToTopic(String topic, String key, String message) {
		kafkaTemplate.send(topic, key, message);

	}
}
