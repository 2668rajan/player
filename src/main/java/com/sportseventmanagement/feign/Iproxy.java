package com.sportseventmanagement.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="Authentication", url="http://localhost:8083/api/auth")
public interface Iproxy {

	@GetMapping(value = "/validate")
	public boolean getvalidation(@RequestHeader(value = "Authorization", required = true) String token1);
}
