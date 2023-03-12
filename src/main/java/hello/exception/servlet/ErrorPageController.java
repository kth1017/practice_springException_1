package hello.exception.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrorPageController {

    @RequestMapping("/error-page/500")
    public String errorPage500(HttpServletRequest req, HttpServletResponse res){
        return "error-page/500";

    }

}
