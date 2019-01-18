package com.example.rocketmqdemo1.exception;

import com.example.rocketmqdemo1.constant.ErrorCode;

/**
 * Title:com.example.rocketmqdemo1.exception.RocketMQException
 * Description:
 * Copyright: Copyright (c) 2019
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2019/01/09  13:49
 */
public class RocketMQException extends AppException{

    private static final long serialVersionUID = 1L;


    /**
     * 无参构造函数
     */
    public RocketMQException() {
        super();
    }
    public RocketMQException(Throwable e) {
        super(e);
    }
    public RocketMQException(ErrorCode errorType) {
        super(errorType);
    }

    public RocketMQException(ErrorCode errorCode, String ... errMsg) {
        super(errorCode, errMsg);
    }
    /**
     * 封装异常
     * @param errorCode
     * @param errMsg
     * @param isTransfer 是否转换异常信息，如果为false,则直接使用errMsg信息
     */
    public RocketMQException(ErrorCode errorCode, String errMsg,Boolean isTransfer) {
        super(errorCode, errMsg,isTransfer);
    }

    public RocketMQException(ErrorCode errCode, Throwable cause,String ... errMsg) {
        super(errCode,cause, errMsg);
    }
}