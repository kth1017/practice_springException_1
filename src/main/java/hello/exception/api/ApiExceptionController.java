package hello.exception.api;

import hello.exception.exception.BadRequestException;
import hello.exception.exception.UserException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiExceptionController {

//    @GetMapping("/api/members/{id}")
    public MemberDto getMember1(@PathVariable("id") String id) {

        // 예외 발생시 api가 예외 html을 던짐 > x
        if (id.equals("ex")) {
            throw new RuntimeException("잘못된 member");
        }

        return new MemberDto(id, "hello" + id);
    }
    @GetMapping("/api/members/{id}")
    public MemberDto getMember2(@PathVariable("id") String id) {
        if (id.equals("ex")) {
            throw new RuntimeException("잘못된 사용자");
        }

        if (id.equals("bad")) {
            throw new IllegalArgumentException("잘못된 입력 값");
        }

        if (id.equals("user-ex")) {
            throw new UserException("사용자 오류");
        }

        return new MemberDto(id, "hello " + id);
    }

    @GetMapping("/api/res-status-ex1")
    public String resStatusEx(){
        throw new BadRequestException();
    }

    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String memberId;
        private String name;
    }
}
