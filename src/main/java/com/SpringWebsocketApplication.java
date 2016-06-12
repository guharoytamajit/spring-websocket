package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({WsConfig.class})
public class SpringWebsocketApplication  
{
	public static void main(String[] args) {
		SpringApplication.run(SpringWebsocketApplication.class, args);
	}

}
