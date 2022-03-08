package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
//실습코드 2-16 RequestBody 예제 라이브러리 추가
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("test")  // 주소
public class TestController {
    @GetMapping
    public String testController() {
        return "Hello World!";
    }
    @GetMapping("/testGetMapping")
    public String testControllerWithPath(){
        return "Hello World! testGetMapping";   
    }
    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id){
        return "Hello World! ID " + id;
    }
    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id){
        return "Hello World! ID " + id;
    }
    @GetMapping("/test/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO){
        return "Hello World! ID " + testRequestBodyDTO.getId() + "Message : " + testRequestBodyDTO.getMessage();
    }
}

