package ru.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/test1")
    @ResponseBody
    public Info test() {
        return new Info("test", 1, List.of("a", "b", "c"), new SubInfo(1));
    }

}
