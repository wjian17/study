package org.company.forward.domain.basic;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasicResponse implements Serializable {

    private String errorCode;

    private String errorMsg;

    private Object body;
}
