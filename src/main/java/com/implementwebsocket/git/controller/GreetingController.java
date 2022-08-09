package com.implementwebsocket.git.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.implementwebsocket.git.pojo.Greetings;
import com.implementwebsocket.git.pojo.HelloMessage;

@Controller
public class GreetingController {
    
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greetings greet(HelloMessage message) {
		return new Greetings("Hello," + HtmlUtils.htmlEscape(message.getName()));
	}
}
