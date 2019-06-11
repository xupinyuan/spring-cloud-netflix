package com.fjhckj.springcloudrabbitmq;

import com.fjhckj.springcloudrabbitmq.controller.RabbitQMController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCloudRabbitmqApplication.class)
public class SpringCloudRabbitmqApplicationTests {

    @Autowired
    private RabbitQMController rabbitQMController;

    @Test
    public void test1() {
        for(int i=1 ; i<100000 ; i++){
            rabbitQMController.sendMQ("我是消息"+i);
        }
    }

}
