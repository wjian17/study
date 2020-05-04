package com.company.forward.study.rest.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.company.forward.domain.rest.EpAlipayBillFlow;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface EpAlipayBillFlowMapper {

    int insert(EpAlipayBillFlow record);

    int insertSelective(EpAlipayBillFlow record);

    List<EpAlipayBillFlow> queryEpAlipayBillFlowList(@Param("flowNo") String flowNo);
}