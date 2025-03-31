package inflearn.spring.hello_spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("ssafy")
    public String ssafy(Model model) {
        model.addAttribute("data", "ssafy");
        return "ssafy";
    }

}
