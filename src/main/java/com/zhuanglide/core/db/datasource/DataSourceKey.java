package com.zhuanglide.core.db.datasource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 数据源连接key
 * @ClassName: DataSourceKey 
 * @author wwj 
 */
public class DataSourceKey {
    private static final Logger logger = Logger.getLogger(DataSourceKey.class);

    private static final ThreadLocal<String> data_source_key = new ThreadLocal<String>();
    private String writeKey;        //写key
    private List<String> readKeyList = Collections.synchronizedList(new ArrayList<String>()); //写key
    private Random random = new Random();       //用于随机分配不同的读key
    
    public void setReadKeyList(List<String> readKeyList){
        this.readKeyList.addAll(readKeyList);  
    }
    
    public void setWriteKey(String writeKey) {
        this.writeKey = writeKey;
    }
    
    /**
     * 设置写key
     */
    public void setWriterKey(){
        if(logger.isDebugEnabled()){
            logger.debug("add data source write key["+writeKey+"]");
        }
        data_source_key.set(writeKey);
    }
    
    /**
     * 设置读key
     */
    public void setReadKey(){
        String readKey = readKeyList.get(random.nextInt(readKeyList.size()));
        if(logger.isDebugEnabled()){
            logger.debug("add data source read key["+readKey+"]");
        }
        data_source_key.set(readKey);
    }
    
    //设置其他的key
    public void setKey(String key) {
        if(StringUtils.isEmpty(key)) {
            throw new RuntimeException("the data source key is empty");
        }
        data_source_key.set(key);
        if(logger.isDebugEnabled()){
            logger.debug("add data source other key["+key+"]");
        }
    }
    
    /**
     * 获取读key 
     */
    public String getKey() {
        if(data_source_key.get() == null) {
            throw new RuntimeException("the data source key is null,please set data_source_key before get");
//        	setReadKey();
        }
        String readkey = data_source_key.get();
        if(logger.isDebugEnabled()){
            logger.debug("get data source Key[" + readkey + "]");
        }
        return readkey;
    }
    
    
    public String getWriteKey() {
        return writeKey;
    }
    
    
    public void clearKey() {
        data_source_key.remove();
    }
    
}
