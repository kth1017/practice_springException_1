package hello.exception.servlet;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    에러 발생 url 컨트롤러
 */
@Controller
public class ServletExController {

    @GetMapping("/error-ex")
    public void errorEx(){
        throw new RuntimeException("예외발생");
    }
    @GetMapping("/error-404")
    public void error404(HttpServletResponse res) throws IOException {
        res.sendError(404, "404");
    }
    @GetMapping("/error-500")
    public void error500(HttpServletResponse res) throws IOException {
        res.sendError(500, "500");
    }

}
