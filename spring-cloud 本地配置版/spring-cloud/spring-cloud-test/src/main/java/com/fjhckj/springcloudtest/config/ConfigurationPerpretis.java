package com.fjhckj.springcloudtest.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "test")
@Component
public class ConfigurationPerpretis {
    private String aa = "ll";
    private List<String> bb;

    public List<String> getBb() {
        return bb;
    }

    public void setBb(List<String> bb) {
        this.bb = bb;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }
}
