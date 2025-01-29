package ru.test.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public class TestController {

    @GetMapping("/test")
    public Info test() {
        return new Info("test", 1, List.of("a", "b", "c"), new SubInfo(1));
    }

    @PostMapping("/test")
    public String test1() {
        return "test1";
    }

    @GetMapping("/with-path-param/{id}")
    public void getWithPathParam(@PathVariable int id) {
        System.out.println(id);
    }

    @GetMapping("/with-query-param")
    public String getQueryParam(@RequestParam int id, @RequestParam String name) {
        System.out.println(id);
        return name;
    }

    @PostMapping("/with-body-param")
    public SubInfo postBodyParam(@RequestBody SubInfo subInfo) {
        System.out.println(subInfo);
        return subInfo;
    }

//    @PostMapping(value = "/with-form-param", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String postFormParam(@RequestPart MultipartFile subInfo) {
//        System.out.println(subInfo);
//        return subInfo.getName();
//    }
}
