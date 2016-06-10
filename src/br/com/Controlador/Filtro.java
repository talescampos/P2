package br.com.Controlador;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/Filtro")
public class Filtro implements Filter {

   
    public Filtro() {
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request ;
		String url = httpServletRequest .getRequestURI();
		HttpSession sessao = httpServletRequest .getSession();
		if(sessao.getAttribute("cliAutenticado")!=null||url.lastIndexOf("Login.jsp")>-1||
		url.lastIndexOf("autenticador") > -1 ){
		chain.doFilter(request, response);
	}else{
		((HttpServletResponse) response).sendRedirect("Login.jsp");
		
	}}

	public void init(FilterConfig fConfig) throws ServletException {
	
	
	
	}

}
