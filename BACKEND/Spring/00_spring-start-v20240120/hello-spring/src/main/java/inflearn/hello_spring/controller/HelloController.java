package inflearn.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody   // http에서 header와 body가 있는데 body에 데이터를 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;  // hello eonji
        // template 엔진과의 차이 = view 이런 거 없고 문자가 그대로 내려감
        // 페이지 소스 보기 해보면 다른 코드 없고 저 문자열만 있어
    }   // 쓸 일 거의 없음
    
    // 진짜는 지금부터
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }   // json으로 넘어감

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
