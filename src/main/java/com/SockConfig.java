package com;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Configuration
@EnableWebSocket
public class SockConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new MyWebSocketHandler(), "/sockregister").withSockJS();
	}

	class MyWebSocketHandler extends TextWebSocketHandler {
		private List<WebSocketSession> sessions = new CopyOnWriteArrayList<WebSocketSession>();

		@Override
		public void afterConnectionClosed(WebSocketSession session,
				CloseStatus status) throws Exception {

		}

		@Override
		public void afterConnectionEstablished(WebSocketSession session)
				throws Exception {
			sessions.add(session);
		}

		@Override
		protected void handleTextMessage(WebSocketSession session,
				TextMessage message) throws Exception {
			for (WebSocketSession socketSession : sessions) {
				socketSession.sendMessage(message);
			}
		}

		@Override
		public void handleTransportError(WebSocketSession session,
				Throwable exception) throws Exception {
			
			super.handleTransportError(session, exception);
		}
		
		

	}
}
