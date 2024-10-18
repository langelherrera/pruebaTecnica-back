package com.example.demo.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerQuery {

    private String type;

    private String id;
}
