package com.sse.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

import com.sse.bean.Message;

@Controller
@RequestMapping("sse")
public class SSEController {
	private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public SseEmitter stream() throws IOException {

		SseEmitter emitter = new SseEmitter();

		emitters.add(emitter);
		// emitter.onCompletion(Runnable runnable)
		emitter.onCompletion(() -> emitters.remove(emitter));
		return emitter;
	}

//	@ResponseBody
	@RequestMapping(path = "/broadcast", method = RequestMethod.POST)
	public String sendMessage(@ModelAttribute@Valid Message message) {

		for (SseEmitter emitter : emitters) {

			SseEventBuilder sseEventBuilder = SseEmitter.event().data(
					message.getContent());
			try {
				if (!message.getMessageType().equals("both")) {
					sseEventBuilder.name(message.getMessageType());
				}
				emitter.send(sseEventBuilder);
			} catch (IOException e) {
				emitter.complete();
				emitters.remove(emitter);
				e.printStackTrace();
			}
		}
		return "redirect:http://localhost:8080/sse/home";
	}

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String home(@ModelAttribute Message message,Model model) throws IOException {
		model.addAttribute("messageTypes", new String[]{"spring","hibernate","both"});
		return "sse";
	}
	@RequestMapping(path = "/clienthome", method = RequestMethod.GET)
	public String clientHome(Model model) throws IOException {
		return "sseMessages";
	}

}
