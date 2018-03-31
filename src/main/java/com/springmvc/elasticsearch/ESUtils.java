package com.springmvc.elasticsearch;/**
 * Created by yanrupeng on 2017/5/29.
 */

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * Description: wms5
 * User: yanrupeng
 * Date: 2017/5/29
 * Time: 23:59
 * To change this template use File | Settings | File and Code Templates.
 */
public class ESUtils {
    private static Logger logger = LoggerFactory.getLogger(ESUtils.class);
    private static TransportClient client = null;

    public static TransportClient getEsInstance() {
        try {
            Settings settings = Settings.builder().put("cluster.name", "es-cluster").build();
            client =
                    new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.1.11"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }

    public static String indexJSON(String index, String type, String id, String jsonStr) {
        if (client == null) {
            client = getEsInstance();
        }
        IndexResponse response = client.prepareIndex(index, type, id).setSource(jsonStr).get();
        return response.getResult().getLowercase();
    }

    public static void closeClient() {
        client.close();
    }

    public static void main(String[] args) {
        String json = "{" + "\"user\":\"kimchy1\"," + "\"postDate\":\"2017-01-30\"," + "\"message\":\"trying out Elasticsearch1\"" + "}";
        System.out.println(indexJSON("twitter", "tweet", "1", json));
        client.close();
    }
}
