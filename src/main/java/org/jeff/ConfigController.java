package org.jeff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*; 
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.jeff.config.UpsService;

@Controller
@EnableAutoConfiguration
public class ConfigController {

	@Autowired
	UpsService upsService;
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

	@RequestMapping("/config")
    @ResponseBody
    String config() {
        return "service uri: " + upsService.getUri(); 
    }
}
