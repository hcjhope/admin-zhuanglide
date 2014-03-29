package com.zhuanglide.core.db.datasource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 * @ClassName: DynamicDataSource 
 * @author wwj 
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static Logger logger = Logger.getLogger(DynamicDataSource.class);
    private DataSourceKey   dataSourceKey;
    @Override
    protected Object determineCurrentLookupKey() {
        String key = "";
        try{
            key = dataSourceKey.getKey();
            if(logger.isDebugEnabled()){
                logger.debug("get dynamic data source key ["+ key+"]");
            }
        }catch(Exception e){
            logger.error("get dynamic data soure key exception", e);
            throw new RuntimeException("get data source key fail", e);
        }
        return key;
    }
    
    public void setDataSourceKey(DataSourceKey dataSourceKey) {
        this.dataSourceKey = dataSourceKey;
    }
}
