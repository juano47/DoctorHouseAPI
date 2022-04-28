package com.delaiglesia.doctorhouseapi.controller;

import com.delaiglesia.doctorhouseapi.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeaturesConfigController {

	@Autowired
	private ConfigProperties properties;

	@GetMapping("/feature-flags")
	public ConfigProperties getProperties() {
		return properties;
	}
}