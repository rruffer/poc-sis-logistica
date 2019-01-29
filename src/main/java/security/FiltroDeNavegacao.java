package security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.LogonMB;
import model.User;

//@WebFilter(urlPatterns={"/restricted/*", "/faces/*"})
@WebFilter("/pages/private/*")
public class FiltroDeNavegacao implements Filter{
	
	@Inject
	LogonMB logon;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
//		System.out.println(req.getServletPath()); 
		
		User usuario = logon.getUser();
		
		if(usuario == null){
			
			res.sendRedirect(req.getContextPath() + "/pages/public/login.xhtml");
			
			return;
			
		}else{
			
			chain.doFilter(request, response);
			
		}
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
