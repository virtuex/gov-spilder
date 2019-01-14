package org.virtue.zjzfcg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ZhaobiaoMain {
    static Logger logger = LoggerFactory.getLogger(ZhaobiaoMain.class);

    public static void main(String[] args) throws IOException {
        DbOpFactory instance = DbOpFactory.getInstance();
        instance.init();
        //先发送一次请求，来获取初始化数据
        ZhaobiaoAnalizer.getBindData(new ZhaobiaoSpiler().get(getUri(1)));
        for(int i=1;i<=ZhaobiaoConfig.totalPage;i++){
            List<Map<String,Object>> bindData = ZhaobiaoAnalizer.getBindData(new ZhaobiaoSpiler().get(getUri(i)));
            System.out.println("开始爬取第"+i+"页");
            for(Map<String,Object> map:bindData){
              instance.insert(map);
                System.out.println(String.valueOf(map));
            }
            System.out.println("第"+i+"页,爬取结束");
        }
        instance.close();
    }

    private static String getUri(int pageNum){
        String prefix = "http://manager.zjzfcg.gov.cn/cms/api/cors/getRemoteResults?pageSize=15&pageNo=";
        String subfix = "&sourceAnnouncementType=3001&url=http%3A%2F%2Fnotice.zcy.gov.cn%2Fnew%2FnoticeSearch";
        return prefix+pageNum+subfix;
    }

}
