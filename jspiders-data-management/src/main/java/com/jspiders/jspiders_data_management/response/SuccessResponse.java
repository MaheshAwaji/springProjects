package com.jspiders.jspiders_data_management.response;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class SuccessResponse {
	private String message;
	private String token;
	private HttpStatus status;
	private Object data;
	private LocalTime timestamp;
	

}
