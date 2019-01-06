package com.restful.up.service.httpClientUtils;


import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;



    /**
     * @ClassName: HttpClientUtil
     * @Description: TODO(HttpClient工具类)
     * @author wangxy
     * @date 2018年5月8日 下午5:23:39
     * @version 1.0
     */
    @Logger
    public class HttpClientUtil {
        LogManager log = LogManager.getLogManager();
        // 默认字符集
        private static final String ENCODING = "UTF-8";

        /**
         * @Title: sendPost
         * @Description: TODO(发送post请求)
         * @param url 请求地址
         * @param headers 请求头
         * @param data 请求实体
         * @param encoding 字符集
         * @author wangxy
         * @return String
         * @date 2018年5月10日 下午4:36:17
         * @throws
         */
        public static String sendPost(String url,Map<String, String> headers, JSONObject data, String encoding) {
            System.out.println("进入post请求方法...");
            System.out.println("请求入参：URL= " + url);
            System.out.println("请求入参：headers=" + JSON.toJSONString(headers));
            System.out.println("请求入参：data=" + JSON.toJSONString(data));
            // 请求返回结果
            String resultJson = null;
            // 创建Client
            CloseableHttpClient client = HttpClients.createDefault();
            // 创建HttpPost对象
            HttpPost httpPost = new HttpPost();

            try {
                // 设置请求地址
                httpPost.setURI(new URI(url));
                // 设置请求头
                if (headers != null) {
                    Header[] allHeader = new BasicHeader[headers.size()];
                    int i = 0;
                    for (Map.Entry<String, String> entry: headers.entrySet()){
                        allHeader[i] = new BasicHeader(entry.getKey(), entry.getValue());
                        i++;
                    }
                    httpPost.setHeaders(allHeader);
                }
                // 设置实体
                httpPost.setEntity(new StringEntity(JSON.toJSONString(data)));
                // 发送请求,返回响应对象
                CloseableHttpResponse response = client.execute(httpPost);
                // 获取响应状态
                int status = response.getStatusLine().getStatusCode();
                if (status == HttpStatus.SC_OK) {
                    // 获取响应结果
                    resultJson = EntityUtils.toString(response.getEntity(), encoding);
                } else {
                    System.out.println("响应失败，状态码：" + status);
                }

            } catch (Exception e) {
//                System.out.println("发送post请求失败", e);
            } finally {
                httpPost.releaseConnection();
            }
            return resultJson;
        }

        /**
         * @Title: sendPost
         * @Description: TODO(发送post请求，请求数据默认使用json格式，默认使用UTF-8编码)
         * @param url 请求地址
         * @param data 请求实体
         * @author wangxy
         * @return String
         * @date 2018年5月10日 下午4:37:28
         * @throws
         */
        public static String sendPost(String url, JSONObject data) {
            // 设置默认请求头
            Map<String, String> headers = new HashMap<>();
            headers.put("content-type", "application/json");

            return sendPost(url, headers, data, ENCODING);
        }

        /**
         * @Title: sendPost
         * @Description: TODO(发送post请求，请求数据默认使用json格式，默认使用UTF-8编码)
         * @param url 请求地址
         * @param params 请求实体
         * @author wangxy
         * @return String
         * @date 2018年5月10日 下午6:11:05
         * @throws
         */
        public static String sendPost(String url,Map<String,Object> params){
            // 设置默认请求头
            Map<String, String> headers = new HashMap<>();
            headers.put("content-type", "application/json");
            // 将map转成json
            JSONObject data = JSONObject.parseObject(JSON.toJSONString(params));
            return sendPost(url,headers,data,ENCODING);
        }

        /**
         * @Title: sendPost
         * @Description: TODO(发送post请求，请求数据默认使用UTF-8编码)
         * @param url 请求地址
         * @param headers 请求头
         * @param data 请求实体
         * @author wangxy
         * @return String
         * @date 2018年5月10日 下午4:39:03
         * @throws
         */
        public static String sendPost(String url, Map<String, String> headers, JSONObject data) {
            return sendPost(url, headers, data, ENCODING);
        }

        /**
         * @Title: sendPost
         * @Description:(发送post请求，请求数据默认使用UTF-8编码)
         * @param url 请求地址
         * @param headers 请求头
         * @param params 请求实体
         * @author wangxy
         * @return String
         * @date 2018年5月10日 下午5:58:40
         * @throws
         */
        public static String sendPost(String url,Map<String,String> headers,Map<String,String> params){
            // 将map转成json
            JSONObject data = JSONObject.parseObject(JSON.toJSONString(params));
            return sendPost(url,headers,data,ENCODING);
        }

        /**
         * @Title: sendGet
         * @Description: TODO(发送get请求)
         * @param url 请求地址
         * @param params 请求参数
         * @param encoding 编码
         * @author wangxy
         * @return String
         * @date 2018年5月14日 下午2:39:01
         * @throws
         */
        public static String sendGet(String url,Map<String,Object> params,String encoding){
            System.out.println("进入get请求方法...");
            System.out.println("请求入参：URL= " + url);
            System.out.println("请求入参：params=" + JSON.toJSONString(params));
            // 请求结果
            String resultJson = null;
            // 创建client
            CloseableHttpClient client = HttpClients.createDefault();
            // 创建HttpGet
            HttpGet httpGet = new HttpGet();
            try {
                // 创建uri
                URIBuilder builder = new URIBuilder(url);
                // 封装参数
                if(params != null){
                    for (String key : params.keySet()) {
                        builder.addParameter(key, params.get(key).toString());
                    }
                }
                URI uri = builder.build();
                System.out.println("请求地址："+ uri);
                // 设置请求地址
                httpGet.setURI(uri);
                // 发送请求，返回响应对象
                CloseableHttpResponse response = client.execute(httpGet);
                // 获取响应状态
                int status = response.getStatusLine().getStatusCode();
                if(status == HttpStatus.SC_OK){
                    // 获取响应数据
                    resultJson = EntityUtils.toString(response.getEntity(), encoding);
                }else{
                    System.out.println("响应失败，状态码：" + status);
                }
            } catch (Exception e) {
               // System.out.println("发送get请求失败",e);
            } finally {
                httpGet.releaseConnection();
            }
            return resultJson;
        }
        /**
         * @Title: sendGet
         * @Description: TODO(发送get请求)
         * @param url 请求地址
         * @param params 请求参数
         * @author wangxy
         * @return String
         * @date 2018年5月14日 下午2:32:39
         * @throws
         */
        public static String sendGet(String url,Map<String,Object> params){
            return sendGet(url,params,ENCODING);
        }
        /**
         * @Title: sendGet
         * @Description: TODO(发送get请求)
         * @param url 请求地址
         * @author wangxy
         * @return String
         * @date 2018年5月14日 下午2:33:45
         * @throws
         */
        public static String sendGet(String url){
            return sendGet(url,null,ENCODING);
        }
        public  static void main(String[] args){

            Map<String,Object> paramMap1 = new HashMap<String, Object>();
            String url = "http://4883-wauri-sl-apiall.hotel.test.sankuai.com/getOwOtaList/iphone/4/kxmb_mt";
            String ss = "date=2018-12-13&abTest=SAKABTestRule_a&hasSlfOfRoundTrip=0&isShareFlight=false&trafficsource=_bmthomecate&utm_medium=iphone&isMilitaryRequest=0&cityId=1&login=0&userid=0&fromid=kxmb_mt_ios&cabinType=1&uuid=E53D023D6E22588B1521791576E41C2591BE065FD66DEF1CD69363CD0A203DCC&queryId=ba174f69-93ed-47af-8cca-d34927540a8d&arrCityCode=SHA&departAirportCode=PEK&priceToken=a58819161530006855&utm_content=E53D023D6E22588B1521791576E41C2591BE065FD66DEF1CD69363CD0A203DCC&departTime=2018-12-13%2020:30&src=kxmb_mt&utm_campaign=AgroupBgroupGhomepage_category7_20066__a1__c__e0H0&ci=1&deviceid=E53D023D6E22588B1521791576E41C2591BE065FD66DEF1CD69363CD0A203DCC&utm_term=9.4.0&filter=[{%22typeId%22:%22%22,%22itemId%22:%22%22},{%22typeId%22:%22%22,%22itemId%22:%22%22}]&flightInfoId=CA1589&msid=E0293814-FCC3-4F3F-BC40-6121EE2B3EC22018-06-26-17-50848&version_name=9.4.0&flightNo=CA1589&ABbaozhuang=a&category=iphone&__reqTraceID=D36612D4-6945-426C-80FD-B6E1DEB0BC81&utm_source=Alpha&depCityCode=PEK";

            paramMap1.put( "11",ss );
            String result =  HttpClientUtil.sendGet( url, paramMap1);
            System.out.println( result );
        }

}
