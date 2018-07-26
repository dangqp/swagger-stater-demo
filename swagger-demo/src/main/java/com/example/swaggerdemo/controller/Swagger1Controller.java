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
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/07/26  16:31
 */
@RestController
@Api(tags = "测试2")
public class Swagger1Controller {

    @GetMapping("/go")
    @ApiOperation("go方法")
    public String hello(@ApiParam(value = "hello参数")@RequestParam String hello,@ApiParam(value = "go参数") @RequestParam String go ){
        return hello + "----" +go;
    }
}
