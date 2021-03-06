package com.hzgc.cloud.people.dao;

import com.hzgc.cloud.community.model.Count;
import com.hzgc.cloud.community.param.AffirmOperationDTO;
import com.hzgc.cloud.community.param.ImportantRecognizeDTO;
import com.hzgc.cloud.community.param.PeopleDTO;
import com.hzgc.cloud.people.model.People;
import com.hzgc.cloud.people.param.SearchPeopleDTO;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;

@CacheNamespace
public interface PeopleMapper {
    int deleteByPrimaryKey(String id);

    int insert(People record);

    int insertSelective(People record);

    People selectByPrimaryKey(String id);

    People selectByIdCard(String idCard);

    int updateByPrimaryKeySelective(People record);

    int updateByPrimaryKey(People record);

    List<People> searchPeople(SearchPeopleDTO param);

    List<Long> getCommunityIdsById(List<Long> communityIds);

    int countCommunityPeople(Long community);

    int countImportantPeople(Long community);

    int countCarePeople(Long community);

    List<People> searchCommunityPeople(Long community);

    List<People> searchImportantPeople(PeopleDTO param);

    List<People> searchCarePeople(Long community);

    List<People> searchNewPeople(Long community);

    List<People> searchOutPeople(Long community);

    People searchCommunityPeopleInfo(String id);

    People searchPeopleByIdCard(String idcard);

    Integer deleteCommunityByPeopleId(String id);

    Integer insertCommunityByPeopleId(AffirmOperationDTO param);

    List<String> getImportantPeopleId(List<Long> communityIds);

    List<String> getImportantRecognizeRecord(ImportantRecognizeDTO param);

    int countGridPeople(Long gridCode);

    List<Count> countFlagPeople(Long gridCode);
}