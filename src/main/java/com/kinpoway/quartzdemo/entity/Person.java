package com.kinpoway.quartzdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_person")
public class Person {
    private Long id;
    private String name;
    private Integer sex;
    private Integer age;
}
