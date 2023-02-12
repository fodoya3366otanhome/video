package com.trial.video.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.trial.video.entities.Greeting;
import com.trial.video.entities.HelloMessage;

@RestController
public class VideoRestController {

	@MessageMapping("/hello")
	  @SendTo("/topic/greetings")
	  public Greeting greeting(HelloMessage message) throws Exception {
	    Thread.sleep(1000); // simulated delay
	    return new Greeting( HtmlUtils.htmlEscape(message.getName()));
	  }
	
}
