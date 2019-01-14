package org.virtue.zjzfcg;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ZhaobiaoAnalizer {
   public static List<Map<String,Object>> getBindData(String jsonStr) throws IOException {
       ObjectMapper mapper = new ObjectMapper();
       Map<String, Object> tmpMap=mapper.readValue(jsonStr, Map.class);
       //获得总页数
       ZhaobiaoConfig.sizeOfPage = (int) tmpMap.get("pageSize");
       ZhaobiaoConfig.totalPage = (int) tmpMap.get("realCount")/ZhaobiaoConfig.sizeOfPage+1;
       return (List<Map<String,Object>>) tmpMap.get("articles");
   }

    public static void main(String[] args) {
        try {
            getBindData(new ZhaobiaoSpiler().get("http://manager.zjzfcg.gov.cn/cms/api/cors/getRemoteResults?pageSize=15&pageNo=1&sourceAnnouncementType=3001&url=http%3A%2F%2Fnotice.zcy.gov.cn%2Fnew%2FnoticeSearch"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
