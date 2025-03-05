package borisa.com.example.springboot_kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import borisa.com.example.springboot_kafka.kafka.JsonKafkaProducer;
import borisa.com.example.springboot_kafka.payload.User;

@RestController
@RequestMapping("api/v1/kafkawithjson")
public class JsonMessageController {

	
	private JsonKafkaProducer jsonKafkaProducer;

	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
		super();
		this.jsonKafkaProducer = jsonKafkaProducer;
	}
	
	@PostMapping("/publishJson")
	public ResponseEntity<String> publish(@RequestBody User user){
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json message has been sent to kafka broker/topic");
				
	}
	
}
