package com.springEs.EsWebserviceDemo.config;

import org.elasticsearch.client.Client;

import java.net.InetAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.io.File;
import java.io.IOException;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.cisco.springEs.EsWebserviceDemo.repository")
public class ElasticConfiguration {


    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws IOException {
    	ElasticsearchOperations client=null;
        File tmpDir = File.createTempFile("elastic", Long.toString(System.nanoTime()));
        System.out.println("Temp directory: " + tmpDir.getAbsolutePath());
        Settings.Builder elasticsearchSettings =
                Settings.settingsBuilder()
                        .put("http.enabled", "true") // 1
                        .put("index.number_of_shards", "1")
                        .put("path.data", new File(tmpDir, "data").getAbsolutePath()) // 2
                        .put("path.logs", new File(tmpDir, "logs").getAbsolutePath()) // 2
                        .put("path.work", new File(tmpDir, "work").getAbsolutePath()) // 2
                        .put("path.home", tmpDir); // 3

           client = (ElasticsearchOperations) ((TransportClient)client).addTransportAddress(
                 new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9200));
        //System.out.println("Added " + esHost + " with port " + esPort + " as a transport address");

        return client;
    }
}
