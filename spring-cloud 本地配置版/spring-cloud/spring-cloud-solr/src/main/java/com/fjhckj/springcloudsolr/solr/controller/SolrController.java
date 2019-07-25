package com.fjhckj.springcloudsolr.solr.controller;

import com.fjhckj.springcloudsolr.solr.entity.Solr;
import com.fjhckj.springcloudsolr.solr.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("solr")
public class SolrController {
    @Autowired
    private SolrService solrService;

    @GetMapping(value = "list")
    public List<Solr> findList(Solr solr){
        List<Solr> solrList = solrService.findList(solr);
        return solrList;
    }
}
