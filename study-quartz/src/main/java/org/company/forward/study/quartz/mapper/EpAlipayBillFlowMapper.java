package org.company.forward.study.quartz.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.company.forward.domain.rest.EpAlipayBillFlow;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EpAlipayBillFlowMapper {

    int insert(EpAlipayBillFlow record);

    int insertSelective(EpAlipayBillFlow record);

    @Cacheable(cacheNames = "mybatis")
    List<EpAlipayBillFlow> queryEpAlipayBillFlowList(@Param("flowNo") String flowNo);
}