package com.slowhand.mongo.pilot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/friends")
@Controller
public class FriendController {
	@GetMapping("/list")
	public String list(@RequestParam String id) {
		return "list";
	}

}
