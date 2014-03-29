package com.zhuanglide.core.db.interceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.PatternMatchUtils;

import com.zhuanglide.core.db.datasource.DataSourceKey;


/**
 * 动态数据源拦截器
 * @ClassName: DataSourceInterceptor 
 * @author wwj 
 */
public class DataSourceInterceptor implements MethodInterceptor {
	private static final Log logger = LogFactory.getLog(DataSourceInterceptor.class);
    // 方法和使用数据源key的对应关系
    private Map<String, String> attributes = new HashMap<String, String>();
    
    // 数据源key的存储控制器
    private DataSourceKey dataSourceKey;

    /**
     * 是否匹配
     * @param methodName
     * @param mappedName
     * @return
     */
    private boolean isMatch(String methodName, String mappedName) {
        return PatternMatchUtils.simpleMatch(mappedName, methodName);
    }


    public void setDataSourceKey(DataSourceKey dataSourceKey) {
        this.dataSourceKey = dataSourceKey;
    }
    
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }


	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
        //获得方法名
        final String methodName = invocation.getMethod().getName();
        String matchKey = null;   //匹配的data source key
        for(Entry<String, String> attr : attributes.entrySet()) {
            String mappedkey = attr.getKey();
            if(isMatch(methodName, mappedkey)) {
                matchKey = attr.getKey();
            }
        }
        
        String key = "";
        if(null != matchKey){
            key =  attributes.get(matchKey);
            if(logger.isDebugEnabled()){
            	logger.debug(invocation.getClass().getName()+"."+invocation.getMethod().getName()+" match key="+key);
            }
        }
        
        if("READ".equalsIgnoreCase(key)) {
            dataSourceKey.setReadKey();
        } else if("WRITE".equalsIgnoreCase(key)) {
            dataSourceKey.setWriterKey();
        } else {
            dataSourceKey.setKey(key);
        }
        return invocation.proceed();
    }

}
