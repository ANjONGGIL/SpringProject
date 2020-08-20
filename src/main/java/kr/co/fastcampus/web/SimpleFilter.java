package kr.co.fastcampus.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        filterName = "simpleFilter",
        urlPatterns = "simple"
)
@Slf4j
public class SimpleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest
            , ServletResponse servletResponse
            , FilterChain filterChain) throws IOException, ServletException {

        log.info("Filter - Hello world!");
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        String username = (String) session.getAttribute("username");
        if (username == null){
            log.info("new user");
            session.setAttribute("username","anjonggil");
        }else {
            log.info("user->"+username);
        }
        filterChain.doFilter(servletRequest,servletResponse);
        var writer = servletResponse.getWriter();
        writer.println("filter - Hello world");
    }
}
