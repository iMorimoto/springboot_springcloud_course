/**
 * 
 */
package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

/**
 * @author Irvin Ruiz
 * @date 17/02/2019
 */
public class ExceptionResponse {

	private LocalDateTime timestamp;

	private String message;

	private String details;

	public ExceptionResponse(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
