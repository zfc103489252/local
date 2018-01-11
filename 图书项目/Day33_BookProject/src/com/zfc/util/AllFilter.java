package com.zfc.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AllFilter",urlPatterns = {})
public class AllFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Object username = request.getSession().getAttribute("username");
        if (username != null){
            chain.doFilter(req, resp);
            return;
        }
        request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
