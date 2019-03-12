package com.in28minutes.microservices.limitsservices.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LimitConfiguration {

	private int minimum;
	private int maximum;
	
}
