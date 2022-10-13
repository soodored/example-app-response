package com.example.exampleappresponse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private Integer customCode;
    private String description;


    private List<ErrorDto> errorDetails;
    private Object custom;

    public TestDto(Integer customCode, String description) {
        this.customCode = customCode;
        this.description = description;
    }

    public TestDto(Integer customCode, String description, List<ErrorDto> errorDetails) {
        this.customCode = customCode;
        this.description = description;
        this.errorDetails = errorDetails;
    }
}
