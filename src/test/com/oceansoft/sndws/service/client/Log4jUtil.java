package test.com.oceansoft.sndws.service.client;

import org.apache.log4j.HTMLLayout;

/**
 * Created by wangg on 2017/1/19.
 */
public class Log4jUtil extends HTMLLayout{

    public String getContentType() {
        return "text/html;charset=GBK";
    }
}
