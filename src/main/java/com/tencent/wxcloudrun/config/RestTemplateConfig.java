package com.tencent.wxcloudrun.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author liupenghui
 * @date 2022/1/14
 * restTemplate使用httpclient连接池
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_FORM_URLENCODED));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        restTemplate.setRequestFactory(requestFactory());
        return restTemplate;
    }

    /**
     * 连接池配置
     */
    @Bean
    public ClientHttpRequestFactory requestFactory(){
        // 设置协议http和https对应的处理socket链接工厂的对象，防止httpclient https请求需要证书验证
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        //最大连接数
        connectionManager.setMaxTotal(100);
        //同路由并发数
        connectionManager.setDefaultMaxPerRoute(10);

        RequestConfig requestConfig = RequestConfig.custom()
                //等待响应超时时间
                .setSocketTimeout(3 * 1000)
                //连接超时时间
                .setConnectTimeout(3 * 1000)
                //从连接池取连接的超时时间
                .setConnectionRequestTimeout(3 * 1000)
                .build();

        CloseableHttpClient httpClient =  HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).setConnectionManager(connectionManager).build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        return requestFactory;
    }

}
