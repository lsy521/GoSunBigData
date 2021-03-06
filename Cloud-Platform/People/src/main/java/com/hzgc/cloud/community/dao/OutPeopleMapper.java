package com.hzgc.cloud.community.dao;

import com.hzgc.cloud.community.model.CountCommunityPeople;
import com.hzgc.cloud.community.model.OutPeople;
import com.hzgc.cloud.community.param.AffirmOperationDTO;
import com.hzgc.cloud.community.param.NewAndOutPeopleCountDTO;
import com.hzgc.cloud.community.param.NewAndOutPeopleSearchDTO;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;

@CacheNamespace
public interface OutPeopleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OutPeople record);

    int insertSelective(OutPeople record);

    OutPeople selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutPeople record);

    int updateByPrimaryKey(OutPeople record);

    int countOutPeople(Long communityId);

    List<CountCommunityPeople> countTotalOutPeople(NewAndOutPeopleCountDTO param);

    List<CountCommunityPeople> countConfirmOutPeople(NewAndOutPeopleCountDTO param);

    List<OutPeople> searchCommunityOutPeople(NewAndOutPeopleSearchDTO param);

    Integer updateIsconfirm(AffirmOperationDTO param);

    int delete(String peopleid);
}