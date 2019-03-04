package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field1", "field2");

		return filteringMethod(someBean, filter);

	}

	@GetMapping("filtering-list")
	public MappingJacksonValue retrieveListOfSomeBeans() {
		List<SomeBean> asList = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value11", "value12", "value13"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field2", "field3");

		return filteringMethod(asList, filter);

	}

	private static MappingJacksonValue filteringMethod(Object object, SimpleBeanPropertyFilter filter) {
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(object);
		mapping.setFilters(filters);
		return mapping;
	}
}
