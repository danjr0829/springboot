package ksmart.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Controller : 클라이언트의 요청과 응답을 담당하는 클래스(HTTP 통신)
 * 주의할 점 : class 바로 위에 작성해야함
 */

@Controller
public class MainController {

    /**
     * @GetMapping : HTTP GET 방식 주소 요청 시 특정 핸들러메소드 맵핑 시켜주는 어노테이션
     * @return String : 화면의 논리 경로
     */
    @GetMapping("/")
    public String mainPage() {
        return "index";
    }
}
