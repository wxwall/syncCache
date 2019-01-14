package com.ctrip.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author xiaowei.wu
 * @Date 2019/1/14 17:45
 */
@Component
public class CacheInit implements InitializingBean {

    Cache userCache;

    @Override
    public void afterPropertiesSet() throws Exception {
        CacheManager cacheManager = CacheManager.create("src/main/resources/ehcache.xml");
        userCache = cacheManager.getCache("userCache");
    }

    public Cache getUserCache() {
        return userCache;
    }
}
