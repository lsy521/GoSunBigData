package com.hzgc.charts.dao;


import com.hzgc.charts.domain.Car;
import com.hzgc.charts.domain.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


/**
 * created by liang on 2018/12/12
 */
public interface PersonRepository extends ElasticsearchRepository<Person, String> {

    List<Person> findByTimestampBetween(String startTime, String endTime);
}
