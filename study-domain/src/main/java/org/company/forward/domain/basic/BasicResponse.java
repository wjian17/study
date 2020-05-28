package org.company.forward.domain.basic;

import lombok.Data;

import java.io.Serializable;

@Data
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class BasicResponse implements Serializable {

    private String errorCode;

    private String errorMsg;

    private Object body;
}
