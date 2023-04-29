package kim.jerok.practice_spring_12.filter;

import javax.servlet.*;
import java.io.IOException;

public class BlackListFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // x-www-form-urlencoded -> username=jerok
        String username = request.getParameter("username");
        if (username.equals("black")) {
            // DS보다 먼저 작동한다.
            response.setContentType("text/plain; charset=utf-8");
            response.getWriter().println("당신은 블랙리스트입니다.");
            return;
        }
        chain.doFilter(request, response);
    }

}
