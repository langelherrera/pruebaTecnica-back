package com.example.demo.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
    private int status;
    private String message;

}
