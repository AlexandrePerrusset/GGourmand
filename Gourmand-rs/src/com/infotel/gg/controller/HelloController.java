
package com.infotel.gg.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/hello/{nom}")
	public String sayHello(@PathVariable("nom") String name){
		return "Salut les jeune, je suis " +name;
	}

}
