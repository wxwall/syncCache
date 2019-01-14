package com.ctrip.cache.ehcache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
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

    private String ehcache() {
        net.sf.ehcache.Cache userCache = cacheInit.getUserCache();
        userCache.put(new Element("key","小强1"));
        Element key = userCache.get("key");
        Object objectValue = key.getObjectValue();
        System.out.println(objectValue);
        return objectValue.toString();
    }


}