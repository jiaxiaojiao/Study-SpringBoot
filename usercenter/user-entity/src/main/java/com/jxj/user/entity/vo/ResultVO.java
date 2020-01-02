package com.jxj.user.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO implements Serializable {
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

    public static ResultVO success(String data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(SUCCESS);
        resultVO.setMessage(SUCCESS_MSG);
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO error(Integer code, String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(message);
        return resultVO;
    }
}
