package com.open.ehcache;

import com.open.ehcache.service.EhcacheTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @date 2019年6月4日14:02:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring1.xml"})
public class EhcacheTest1 {

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
            if(i > 5){
                i = 1;
                break;
            }
        }

        Thread.sleep(5000);

        while (true) {
            ehcacheTestService.put(name + i, i++ + "segi");
            if(i > 5) break;
        }

        while (true){

        }

    }
}
  