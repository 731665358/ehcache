package com.open.ehcache;

import com.open.ehcache.service.EhcacheTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @date 2019年6月4日13:58:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring2.xml"})
public class EhcacheTest2 {

    @Autowired
    private EhcacheTestService ehcacheTestService;

    @Test
    public void test() throws InterruptedException {
        String name = "segi";

        int i = 1;

        while (true){
            String o = ehcacheTestService.getName(name + i);
            System.out.println(i + " : " + o);
            i++;
            Thread.sleep(1000);
            if(i > 5) i = 1;
        }
    }
}
