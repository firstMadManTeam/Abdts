package com.abdts.common.util;

import org.apache.solr.client.solrj.impl.HttpSolrServer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author pzy
 */
public class SolrUtil {

    private static String solrURL = null;

    private static Properties properties = new Properties();

    private static InputStream is = null;

    private static HttpSolrServer solrServer = null;

    static {
        try {
            ClassLoader classLoader = SolrUtil.class.getClassLoader();
            is = classLoader.getResourceAsStream("solr.properties");
            properties.load(is);
            solrURL = properties.getProperty("solrUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HttpSolrServer getSolrServer(String core) {
        return solrServer = new HttpSolrServer(solrURL + core);
    }


}
