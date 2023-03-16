package hello.exception;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
    public void hello(){
    }
}
