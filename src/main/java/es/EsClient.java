package es;

import com.carrotsearch.hppc.cursors.ObjectObjectCursor;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequest;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.ClusterState;
import org.elasticsearch.cluster.metadata.IndexMetaData;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * Created by chenjie on 17/4/22.
 */
public class EsClient {

    private static Properties elasticsearch_properties = new Properties();
    private static String HOST = "elasticsearch.host";
    private static String PORT = "elasticsearch.port";
    private static final String CLUSTER_NAME = "cluster.name";
    private static final String INEDX = "zootopia";
    private static final String DEFAULT_CLUSTER_NAME = "wg-zootopia-es-svc";

    private static Client client;

    static {
        Settings settings = Settings.settingsBuilder()
                .put("client.transport.sniff", true)
                .put("cluster.name", "searches").build();
        try {
            client = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.115.142"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {


        //匹配所有
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();


       /* SearchRequestBuilder sbuilder = client.prepareSearch("zootopia") //index name
               // .setTypes("tb_lde_restaurant_info") //type name
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
                /*.setQuery(QueryBuilders.termQuery("first_name", "Douglas"))      // Query
                .setPostFilter(QueryBuilders.rangeQuery("age").from(20).to(40))  // Filter
                .setFrom(0).setSize(60))*//*.setExplain(true);*/

       /* SearchRequestBuilder sbuilder = client.prepareSearch("zootopia").addField("feature_key");
        System.out.println(sbuilder.toString());
        SearchResponse response = sbuilder.execute().get();
        SearchHits searchHits = response.getHits();
        for (SearchHit searchHit: searchHits){
            System.out.println(searchHit.getFields().get("feature_key").getValue().toString());
        }*/

       /* List<String> typeList = new ArrayList<String>();

        GetMappingsResponse res = client.admin().indices().getMappings(new GetMappingsRequest().indices("zootopia")).get();
        ImmutableOpenMap<String, MappingMetaData> mapping = res.mappings().get("zootopia");
        for (ObjectObjectCursor<String, MappingMetaData> c : mapping) {
            typeList.add(c.key);
        }

        for (String str : typeList) {
            System.out.println(str);
        }*/

        // System.out.println(response.toString());


       // getAllColumnByType();//获取字段名,类型以及默认值

        //showSpecifiedValue();
        showAll();
        // searchSpecifiedValue2();//根据指定行获取数据
        //getTypes();
        //_index();

    }


    public static void getTypes() throws Exception {
        List<String> typeList = new ArrayList<String>();

        GetMappingsResponse res = client.admin().indices().getMappings(new GetMappingsRequest().indices("zootopia")).get();
        ImmutableOpenMap<String, MappingMetaData> mapping = res.mappings().get("zootopia");
        for (ObjectObjectCursor<String, MappingMetaData> c : mapping) {
            typeList.add(c.key);
        }

        for (String str : typeList) {
            System.out.println(str);
        }
    }

    public static void getAllColumnByType() {


        //client.prepareIndex("zootopia").
        Map<String, String> attributesMap = new HashMap<>();

        ClusterState cs = client.admin().cluster().prepareState().setIndices(INEDX).execute().actionGet().getState();
        IndexMetaData imd = cs.getMetaData().index(INEDX);
        MappingMetaData mdd = imd.mapping("tb_lpd_team_taker_proficiency_features");
        Map<String, Object> map = null;

        try {
            map = mdd.getSourceAsMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
        attributesMap = getList("", map);

        System.out.println("Field List:");
        Set<String> keys = attributesMap.keySet();
        for (String key : keys) {
            System.out.println(key + "====" + attributesMap.get(key));
        }
    }

    private static Map<String, String> getList(String fieldName, Map<String, Object> mapProperties) {
        Map<String, String> attributesMap = new HashMap<>();
        Map<String, Object> map = (Map<String, Object>) mapProperties.get("properties");
        Set<String> keys = map.keySet();

        for (String key : keys) {
            if (((Map<String, Object>) map.get(key)).containsKey("type")) {
                /*fieldList.add(fieldName + "" + key);
                System.out.println("=======" + ((Map<String, Object>) map.get(key)).get("type"));*/
                attributesMap.put(fieldName + "" + key, ((Map<String, Object>) map.get(key)).get("type").toString());
            }
        }
        return attributesMap;
    }


    public static void showSpecifiedValue() throws Exception {

        SearchRequestBuilder sbuilder = client.prepareSearch("zootopia") //index name
                .setTypes("tb_lde_restaurant_info") //type name
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
                /*.setQuery(QueryBuilders.termQuery("first_name", "Douglas"))      // Query
                .setPostFilter(QueryBuilders.rangeQuery("age").from(20).to(40))  // Filter
                .setFrom(0).setSize(60))*//*.setExplain(true);*/
        System.out.println(sbuilder.toString());
        SearchResponse response = sbuilder.execute().get();
        SearchHits searchHits = response.getHits();
        List<String> fieldList = new ArrayList<>();
        fieldList.add("taker_id");
        fieldList.add("feature_key");
        for (SearchHit hit : searchHits) {
            for (String column : fieldList) {
                System.out.println(column + hit.getSource().get("type"));
            }

        }
    }


    public static void searchSpecifiedValue() throws Exception {

        SearchRequestBuilder sbuilder = client.prepareSearch("zootopia") //index name
                .setTypes("tb_lpd_restaurant_peak_wait_avgaccept_feature")
                .setFetchSource(new String[]{"_id", "id", "restaurant_id", "feature_key"}, null)//type name
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)/*.addFields("id", "feature_id", "taker_id")*/;
                /*.setQuery(QueryBuilders.termQuery("first_name", "Douglas"))      // Query
                .setPostFilter(QueryBuilders.rangeQuery("age").from(20).to(40))  // Filter
                .setFrom(0).setSize(60))*//*.setExplain(true);*/
        System.out.println(sbuilder.toString());
        SearchResponse response = sbuilder.execute().get();
        SearchHits searchHits = response.getHits();
        List<String> fieldList = new ArrayList<>();
        fieldList.add("taker_id");
        fieldList.add("feature_key");
        for (SearchHit hit : searchHits) {
            System.out.println(hit.getSource().toString());

        }
    }


    public static void searchSpecifiedValue2() throws Exception {

        SearchRequestBuilder sbuilder = client.prepareSearch("zootopia") //index name
                .setTypes("tb_lpd_restaurant_peak_wait_avgaccept_feature")
                        //.setFetchSource(new String[]{"id", "restaurant_id", "feature_key"}, null)//type name
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).addFields("id", "restaurant_id", "feature_key");
                /*.setQuery(QueryBuilders.termQuery("first_name", "Douglas"))      // Query
                .setPostFilter(QueryBuilders.rangeQuery("age").from(20).to(40))  // Filter
                .setFrom(0).setSize(60))*//*.setExplain(true);*/
        System.out.println(sbuilder.toString());
        SearchResponse response = sbuilder.execute().get();
        SearchHits searchHits = response.getHits();
        List<String> fieldList = new ArrayList<>();
        fieldList.add("taker_id");
        fieldList.add("feature_key");
        fieldList.add("_id");
        for (SearchHit hit : searchHits) {
            System.out.println(hit.getFields().get("_id").getValue().toString());

        }
    }

    public static void showAll() {
        int count = 0;
        SearchResponse scrollResp = client.prepareSearch(INEDX)
                .setTypes("tb_lpd_restaurant_peak_wait_avgaccept_feature")
                .setScroll(new TimeValue(60000))
                .setSize(1000).get(); //max of 100 hits will be returned for each scroll
        do {
            for (SearchHit hit : scrollResp.getHits().getHits()) {
                // System.out.println("=="+hit.getSource());
                System.out.println(hit.getId());;
            }

            scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
        }
        while (scrollResp.getHits().getHits().length != 0); // Zero hits mark the end of the scroll and the while loop.
        System.out.println("======" + count);
    }


    public static void _index(){
      IndexResponse  indexResponse = client.prepareIndex(INEDX,"tb_lpd_restaurant_peak_wait_avgaccept_feature").setSource().execute().actionGet();
        System.out.println(indexResponse.getIndex()+":==="+indexResponse.getId().toString());
    }


}
