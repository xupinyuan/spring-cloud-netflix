package com.fjhckj.springcloudsolr.solr.service;

import com.fjhckj.springcloudsolr.solr.dao.SolrMapper;
import com.fjhckj.springcloudsolr.solr.entity.Solr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolrService {
    @Autowired
    private SolrMapper solrMapper;

    public List<Solr> findList(Solr solr){
        List<Solr> solrList = solrMapper.select(solr);
        return solrList;
    }


}
