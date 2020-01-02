package com.jxj.user.openapi.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultDTO implements Serializable {
    private Integer code;
    private String message;
    private String data;

    public static final Integer SUCCESS = 200;
    public static final String SUCCESS_MSG = "成功";

    public static final Integer EXCEPTION = 50001;
    public static final String EXCEPTION_MSG = "异常";

    public static final Integer ERROR_PARAM = 50002;
    public static final String ERROR_PARAM_MSG = "参数错误";

    public static final Integer ERROR = 50404;
    public static final String ERROR_MSG = "未知错误";

    public static ResultDTO success(String data){
        ResultDTO result = new ResultDTO();
        result.setCode(SUCCESS);
        result.setMessage(SUCCESS_MSG);
        result.setData(data);
        return result;
    }

    public static ResultDTO error(Integer code, String message){
        ResultDTO result = new ResultDTO();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
