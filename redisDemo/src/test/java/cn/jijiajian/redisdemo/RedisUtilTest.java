package cn.jijiajian.redisdemo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author J
 * @time 2017/11/1 22:07
 * @description
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {

    @Autowired
    private RedisUtil<DemoEntity> redisUtil;

    @Autowired
    private RedisUtil<String> stringRedisUtil;

    @Test
    public void testListOp() {
        DemoEntity demoEntity1 = new DemoEntity();
        demoEntity1.setId(1);
        demoEntity1.setName("小米");

        DemoEntity demoEntity2 = new DemoEntity();
        demoEntity2.setId(2);
        demoEntity2.setName("小2");

        DemoEntity demoEntity3 = new DemoEntity();
        demoEntity3.setId(3);
        demoEntity3.setName("小3");

        List<DemoEntity> entityList = new ArrayList<>();
        entityList.add(demoEntity1);
        entityList.add(demoEntity2);

        //新建一个列表
        redisUtil.buildList("demoList", entityList);
//        stringRedisUtil.addList("demoList","2333");
        redisUtil.addList("demoList", demoEntity3);


        List<DemoEntity> entityList1 = redisUtil.getList("demoList");
        System.out.println(entityList1);


        stringRedisUtil.set("demoEntity","eee");
        redisUtil.set("demoEntity",demoEntity1);
        System.out.println(redisUtil.get("demoEntity"));

    }
}