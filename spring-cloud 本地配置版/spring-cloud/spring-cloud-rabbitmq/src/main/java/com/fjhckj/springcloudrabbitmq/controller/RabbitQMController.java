package com.fjhckj.springcloudrabbitmq.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息生产者
 */
//描述类
@Api(value = "RabbitMQ消息生产者")
@RestController
public class RabbitQMController {

    @Autowired
    private AmqpTemplate amqpTemplate;


    //描述方法
    @ApiOperation(value = "消息生成rest接口")
    //描述参数
    @ApiImplicitParams({
        @ApiImplicitParam(name = "message", value = "消息内容", required = true, dataTypeClass = String.class, paramType = "String"),
    })
    @RequestMapping(value = "sendMQ",method = RequestMethod.POST)
    public String sendMQ(String message){
        amqpTemplate.convertAndSend("testRabbitQueue", message);
        return "send"+message+"成功";
    }


}
