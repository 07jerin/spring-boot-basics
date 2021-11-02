package com.jerin.basic.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResourceLoader {

	@Value("${external.service.url}")
	private String url;

	public String getUrl() {
		return url;
	}
}
