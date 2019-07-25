package com.fjhckj.springcloudtest.utils.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonFactory;
import com.fjhckj.springcloudtest.utils.PropertiesUtils;
import com.fjhckj.springcloudtest.utils.okhttp.OkHttpUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "wx")
public class WxUtils {
    private static String appid = (String) PropertiesUtils.getCommonYml("wx.appid");
    private static String secret = (String)PropertiesUtils.getCommonYml("wx.secret");

    /**
     * 获取鉴权信息
     * 文档地址:https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183
     * request Type:GET
     * @return access_token
     */
    public static String access_token(){
        String url = "https://api.weixin.qq.com/cgi-bin/token";
        Map<String,String> param = new HashMap<>();
        param.put("appid",WxUtils.appid);
        param.put("secret",WxUtils.secret);
        param.put("grant_type","client_credential");
        String result = OkHttpUtil.get(url,param);
        Map map = JSONObject.parseObject(result, Map.class);
        return (String) map.get("access_token");
    }

    /**
     * 授权获取code
     * 文档地址:https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842
     * request Type:GET
     * @return
     */
    public static String getCode(String redirectUrl,String scope){
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize";
        Map<String,String> param = new HashMap<>();
        param.put("appid",WxUtils.appid);
        param.put("redirect_uri",redirectUrl);
        param.put("response_type","code");
        param.put("state",scope);
        param.put(null,"#wechat_redirect");
        String result = OkHttpUtil.get(url,param);
        return result;
    }
    public static void main(String[] args) {
        String token = access_token();
    }
}
