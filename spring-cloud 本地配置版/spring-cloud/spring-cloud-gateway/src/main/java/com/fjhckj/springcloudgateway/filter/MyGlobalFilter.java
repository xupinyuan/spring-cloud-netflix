package com.fjhckj.springcloudgateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义全局过滤器
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取参数
        String token =  exchange.getRequest().getQueryParams().getFirst("token");
        if (StringUtils.isBlank(token)) {
            ServerHttpResponse response = exchange.getResponse();
            Map<String,Object> resuMap = new HashMap<>();
            resuMap.put("status", -1);
            resuMap.put("massage", "鉴权失败");
            //转化为json 并转为字节数组
            ObjectMapper objectMapper = new ObjectMapper();
            byte[] data = new byte[0];
            try {
                data = objectMapper.writeValueAsBytes(resuMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            // 输出错误信息到页面
            DataBuffer buffer = response.bufferFactory().wrap(data);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //filter执行的优先级,值越小则优先级越大
        return 0;
    }
}