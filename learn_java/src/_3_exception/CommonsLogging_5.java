package _3_exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * [异常处理/Commons Logging]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264738932870688#0
 */
public class CommonsLogging_5 {
    public static void main(String[] args){
        Log log = LogFactory.getLog(Main.class);
        log.info("start...");
        log.warning("end.");
    }
}
