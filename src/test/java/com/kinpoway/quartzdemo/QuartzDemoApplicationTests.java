package com.kinpoway.quartzdemo;

import com.kinpoway.quartzdemo.entity.Person;
import com.kinpoway.quartzdemo.mapper.PersonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class QuartzDemoApplicationTests {

    @Resource
    private PersonMapper personMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void mybatisTest() {
        Person person = new Person();
        person.setName("张三");
        person.setSex(0);
        person.setAge(18);
        int insert = personMapper.insert(person);
        assert insert > 0;
    }

}
