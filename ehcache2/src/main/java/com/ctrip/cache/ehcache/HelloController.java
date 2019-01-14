package com.ctrip.cache.ehcache;

import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class HelloController {


    @Autowired
    CacheInit cacheInit;

    @RequestMapping("/hello")
    public String index() {
        return ehcache();
    }
    /**
     * 原生ehcache
     * @return
     */
    private String ehcache() {
        net.sf.ehcache.Cache userCache = cacheInit.getUserCache();
        Element key = userCache.get("key");
        Object objectValue = key.getObjectValue();
        System.out.println(objectValue);
        return objectValue.toString();
    }


}