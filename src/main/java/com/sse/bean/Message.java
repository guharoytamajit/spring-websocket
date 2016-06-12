package com.sse.bean;

public class Message {
	String messageType;
	String content;

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message [messageType=" + messageType + ", content=" + content
				+ "]";
	}

	public Message(String messageType, String content) {
		super();
		this.messageType = messageType;
		this.content = content;
	}

	public Message() {
		super();
	}

}
