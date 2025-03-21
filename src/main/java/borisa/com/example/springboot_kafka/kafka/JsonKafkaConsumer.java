package borisa.com.example.springboot_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import borisa.com.example.springboot_kafka.payload.User;

@Service
public class JsonKafkaConsumer {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics="firstTopic", groupId="myGroup")
	public void consume(User user) {
		LOGGER.info(String.format("Message received -> %s", user.toString()));
	}

}
