package com.fjhckj.springcloudsolr.solr.dao;

import com.fjhckj.springcloudcommonservice.utils.MyMapper;
import com.fjhckj.springcloudsolr.solr.entity.Solr;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SolrMapper extends MyMapper<Solr> {
}