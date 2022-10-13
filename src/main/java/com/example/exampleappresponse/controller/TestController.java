package com.example.exampleappresponse.controller;

import com.example.exampleappresponse.dto.ErrorDto;
import com.example.exampleappresponse.dto.TestDto;
import com.example.exampleappresponse.dto.TestObj;
import com.example.exampleappresponse.dto.UserResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/get/200")
    public ResponseEntity<UserResponce> test200() {
        return new ResponseEntity<>(new UserResponce(1, "test"), HttpStatus.OK);
    }

    @GetMapping("/get/error/with/body")
    public ResponseEntity<TestDto> test400() {
        List<ErrorDto> list = Arrays.asList(
                new ErrorDto("name", "test message"),
                new ErrorDto("pass", "test message"),
                new ErrorDto("field", "test message"),
                new ErrorDto("field", "test message")
        );
        return new ResponseEntity<>(
                new TestDto(400,
                        "Test message",
                        list),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get/error/without/body")
    public ResponseEntity<TestDto> test500() {
        return new ResponseEntity<>(
                new TestDto(500,
                        "Test message"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/get/error/with/custom/body")
    public ResponseEntity<TestDto> test5001() {
        List<ErrorDto> list = Arrays.asList(
                new ErrorDto("name", "test message"),
                new ErrorDto("pass", "test message"),
                new ErrorDto("field", "test message"),
                new ErrorDto("field", "test message")
        );
        return new ResponseEntity<>(
                new TestDto(500,
                        "Test message",
                        list,
                        new TestObj("1", "2", "test", "test2")),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
