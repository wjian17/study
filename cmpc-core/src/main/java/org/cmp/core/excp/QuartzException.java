package org.cmp.core.excp;

import org.cmp.core.error.CmpErrorCode;
import org.cmp.core.error.QuartzErrorCode;

/**
 * @author: wangjian
 * @date: 2021/01/18 8:57
 */
public class QuartzException extends CmpException {


    public QuartzException(CmpErrorCode parameterName, String parameterValue, String resourceType) {
        super(QuartzErrorCode.NOT_FOUND, new Object[]{parameterName, parameterValue, resourceType});
    }
}
