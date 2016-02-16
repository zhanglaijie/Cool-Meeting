package filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {

  /**
   * 
    * Title：doFilter
    * Description: 所有请求都走此过滤器来判断用户是否登录
    * user: shaojian.yu
    * date:  2014 2014年11月3日
    * @param servletRequest
    * @param servletResponse
    * @param filterChain
    * @throws IOException
    * @throws ServletException
    * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
   */
  @Override
  public void doFilter(ServletRequest servletRequest,
      ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    // 获得在下面代码中要用的request,response,session对象
    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
    HttpSession session = httpRequest.getSession(true);
    
    String path =httpRequest.getRequestURI();

    // 从session中获取用户信息
    String ename = (String) session.getAttribute("ename");
    System.out.println(path.toString());
    if(path.toString().equals("/MeetingSystem/login.jsp")){
    	filterChain.doFilter(servletRequest, servletResponse); 
    	return;
    }
    if(path.toString().equals("/MeetingSystem/Login")){
    	filterChain.doFilter(servletRequest, servletResponse); 
    	return;
    }
    
    if (null == ename || "".equals(ename)) {
      // 用户存在,可以访问此地址
    	httpResponse.sendRedirect("login.jsp");
    	return;
    } else {
    	filterChain.doFilter(servletRequest, servletResponse); 
      return;
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