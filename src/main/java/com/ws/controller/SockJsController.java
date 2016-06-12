package com.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("sock")
public class SockJsController {

	@RequestMapping(value="home",method=RequestMethod.GET)
	public String home(){
		return "sockMessages";
	}
}
