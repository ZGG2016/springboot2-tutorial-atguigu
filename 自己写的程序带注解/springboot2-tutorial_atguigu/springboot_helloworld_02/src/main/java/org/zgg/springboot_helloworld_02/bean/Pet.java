package org.zgg.springboot_helloworld_02.bean;

import lombok.Data;
import lombok.ToString;


@ToString
@Data
public class Pet {
    private String name;
    private Double weight;
}
