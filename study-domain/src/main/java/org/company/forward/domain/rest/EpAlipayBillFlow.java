package org.company.forward.domain.rest;

import java.io.Serializable;
import java.util.Date;

public class EpAlipayBillFlow implements Serializable {
    private String flwono;

    private Long tranamt;

    private String tranDate;

    private String tranTime;

    private Date date;

    private Date time;

    private String chanlFlwo;

    private String paymentType;

    private String remark1;

    private String remark2;

    public String getFlwono() {
        return flwono;
    }

    public void setFlwono(String flwono) {
        this.flwono = flwono == null ? null : flwono.trim();
    }

    public Long getTranamt() {
        return tranamt;
    }

    public void setTranamt(Long tranamt) {
        this.tranamt = tranamt;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate == null ? null : tranDate.trim();
    }

    public String getTranTime() {
        return tranTime;
    }

    public void setTranTime(String tranTime) {
        this.tranTime = tranTime == null ? null : tranTime.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getChanlFlwo() {
        return chanlFlwo;
    }

    public void setChanlFlwo(String chanlFlwo) {
        this.chanlFlwo = chanlFlwo == null ? null : chanlFlwo.trim();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }
}