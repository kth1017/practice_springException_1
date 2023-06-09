package hello.exception.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*
    에러 페이지 매핑 컨트롤러(직접 접근x)
 */
@Slf4j
@Controller
public class ErrorPageController {

    public static final String ERROR_EXCEPTION = "javax.servlet.error.exception";
    public static final String ERROR_EXCEPTION_TYPE = "javax.servlet.error.exception_type";
    public static final String ERROR_MESSAGE = "javax.servlet.error.message";
    public static final String ERROR_STATUS_CODE ="javax.servlet.error.status_code";
    @RequestMapping("/error-page/500")
    public String errorPage500(HttpServletRequest req, HttpServletResponse res){
        printErrorInfo(req);
        return "error-page/500";

    }

    @RequestMapping(value = "/error-page/500", produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> errorPage500Api(HttpServletRequest
                                                                       request, HttpServletResponse response) {
        log.info("API errorPage 500");
        Map<String, Object> result = new HashMap<>();

        Exception ex = (Exception) request.getAttribute(ERROR_EXCEPTION);
        result.put("status", request.getAttribute(ERROR_STATUS_CODE));
        result.put("message", ex.getMessage());

        Integer statusCode = (Integer)
                request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        return new ResponseEntity(result, HttpStatus.valueOf(statusCode));
    }

    private void printErrorInfo(HttpServletRequest request) {
        log.info("ERROR_EXCEPTION: {}", request.getAttribute(ERROR_EXCEPTION));
        log.info("ERROR_EXCEPTION_TYPE: {}", request.getAttribute(ERROR_EXCEPTION_TYPE));
        log.info("ERROR_MESSAGE: {}", request.getAttribute(ERROR_MESSAGE));
        log.info("ERROR_STATUS_CODE: {}", request.getAttribute(ERROR_STATUS_CODE));
        log.info("dispatcherType={}", request.getDispatcherType());



    }

}
