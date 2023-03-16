package hello.exception;

import hello.exception.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        //1
        filterFilterRegistrationBean.setFilter(new LogFilter());
        //2
        filterFilterRegistrationBean.setOrder(1);
        //3
        filterFilterRegistrationBean.addUrlPatterns("/*");
        return filterFilterRegistrationBean;
    }
}
