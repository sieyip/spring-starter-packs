package com.sieyip.config;


import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class KafkaProducerConfiguration {
	
	@Value("${kafka.producerServer}")
	private String producerServer;
	
	@Value("${kafka.retriesConfig}")
	private String retriesConfig;
	
	@Value("${kafka.batchSizeConfig}")
	private String batchSizeConfig;
	
	@Value("${kafka.lingerMsConfig}")
	private String lingerMsConfig;
	
	@Value("${kafka.bufferMemoryConfig}")
	private String bufferMemoryConfig;

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	@Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, producerServer);
		props.put(ProducerConfig.RETRIES_CONFIG, retriesConfig);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSizeConfig);
		props.put(ProducerConfig.LINGER_MS_CONFIG, lingerMsConfig);
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemoryConfig);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<String, String>(producerFactory());
	}
}