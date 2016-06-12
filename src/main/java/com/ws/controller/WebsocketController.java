package com.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ws")
public class WebsocketController {

	@RequestMapping(value="home",method=RequestMethod.GET)
	public String home(){
		return "wsMessages";
	}
}
