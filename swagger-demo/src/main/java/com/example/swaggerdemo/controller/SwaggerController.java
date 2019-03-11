package com.example.swaggerdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:com.example.swaggerdemo.controller
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/07/26  16:31
 */
@RestController
@Api(tags = "测试一")
public class SwaggerController {

    @GetMapping("/hello")
    @ApiOperation("hello方法")
    public String hello(@ApiParam(value = "入参")@RequestParam String hello){
        return hello;
    }
}
