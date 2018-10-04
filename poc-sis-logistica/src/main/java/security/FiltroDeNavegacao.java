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

import model.User;

@WebFilter(urlPatterns={"/restricted/*", "/faces/*"})
public class FiltroDeNavegacao implements Filter{
	
	@Inject
	LogonMB logon;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Passei!!!");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		System.out.println(req.getRequestURL());
//		System.out.println(req.getServletPath()); 
		
		User usuario = logon.getUser();
		//User usuario = login != null ? login.getUser():null;
		
		if(usuario == null){
			
			res.sendRedirect(req.getContextPath() + "/login.xhtml");
			
			return;
			
		}else{
			
//			String pagina = req.getServletPath().replace("/restricted/", "");
			
			
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
