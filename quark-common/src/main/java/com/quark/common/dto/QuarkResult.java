package com.quark.common.dto;


import com.quark.common.enums.StateEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * Rest响应数据
 */
@Data
public class QuarkResult implements Serializable {

    /**
     * 响应业务状态
     */
    private Integer status;

    /**
     * 返回的数据
     */
    private Object data;

    /**
     * 错误信息
     */
    private String error;

    /**
     * 返回总页数
     */
    private long pageSize;

    /**
     * 本页返回数量
     */
    private Integer total;

    /**
     * 请求成功
     * @param status
     */
    public QuarkResult(Integer status) {
        this.status = status;
    }

    /**
     * 请求成功并携带数据
     * @param status
     * @param data
     */
    public QuarkResult(Integer status, Object data) {
        this.status = status;
        this.data = data;
    }

    /**
     * 请求成功被携带参数与页数
     * @param status
     * @param data
     * @param pageSize
     * @param total
     */
    public QuarkResult(Integer status, Object data, long pageSize, Integer total) {
        this.status = status;
        this.data = data;
        this.pageSize = pageSize;
        this.total = total;
    }

    /**
     * 请求失败
     * @param status
     * @param error
     */
    public QuarkResult(Integer status, String error) {
        this.status = status;
        this.error = error;
    }

    public static QuarkResult ok(){
        return new QuarkResult(StateEnum.SUCCESS.getState());
    }

    public static QuarkResult ok(Object data){
        return new QuarkResult(StateEnum.SUCCESS.getState(),data);
    }

    public static QuarkResult warn(String warn){return new QuarkResult(StateEnum.WARN.getState(),warn);}

    public static QuarkResult error(String error){
        return new QuarkResult(StateEnum.ERROR.getState(),error);
    }

    public static QuarkResult ok(Object data,long pageSize,Integer total){
        return new QuarkResult(StateEnum.SUCCESS.getState(),data,pageSize,total);
    }
}
