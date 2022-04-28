package com.delaiglesia.doctorhouseapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//este componente es solo para usar con el endpoint que devuelve las propiedades
@Component
@EnableConfigurationProperties
@Data
@ConfigurationProperties(prefix = "features")
public class ConfigProperties {

	private ControllerFeatureProperties controllers;

	@Data
	public static class ControllerFeatureProperties {
		private boolean doctor;
	}
}