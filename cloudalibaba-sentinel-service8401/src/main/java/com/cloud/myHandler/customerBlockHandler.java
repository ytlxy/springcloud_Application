package com.cloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.entities.CommonResult;

public class customerBlockHandler {
    public static CommonResult handlerException(BlockException e){
        return new CommonResult(4444,"按客户自定义,global handlerException----1");
    }
    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(4444,"按客户自定义,global handlerException----2");
    }
}
