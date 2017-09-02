package com.trinary.vnjy.rest.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.trinary.security.SimpleCORSFilter;

@WebFilter(urlPatterns={"/*"})
public class CorsFilter extends SimpleCORSFilter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EXECUTING FILTER");
		super.doFilter(req, res, chain);
	}
}