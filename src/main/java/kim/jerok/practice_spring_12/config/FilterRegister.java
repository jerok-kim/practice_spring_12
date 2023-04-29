package kim.jerok.practice_spring_12.config;

import kim.jerok.practice_spring_12.filter.BlackListFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegister {
    
    @Bean
    public FilterRegistrationBean<?> myFilterRegistration() {
        FilterRegistrationBean<BlackListFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new BlackListFilter());
        registration.addUrlPatterns("/login/*");
        registration.setOrder(1);  // 필터 순서 설정
        return registration;
    }
    
}
