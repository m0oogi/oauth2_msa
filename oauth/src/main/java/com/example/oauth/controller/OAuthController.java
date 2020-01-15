package com.example.oauth.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OAuthController {
	
	@RequestMapping("/toDataPage")
	public void datapage(HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.sendRedirect("http://localhost:9099/dataPage");
	}
}
