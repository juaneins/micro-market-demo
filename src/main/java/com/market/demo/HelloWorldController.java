/**
 * 
 */
package com.market.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author juaneins_uio
 *
 */
@RestController
@RequestMapping("/greetings")
public class HelloWorldController {

	@GetMapping("/hello")
	public String greetings() {
		return "Never stop learning!";
	}
}
