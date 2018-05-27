package com.base.test;

import com.base.model.Product;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//表示整合JUnit4进行测试
@ContextConfiguration(locations={"classpath:spring-mongo.xml"})//加载spring配置文件
public class MongoTest {

    private static String COLLECTIONNAME ="product_list";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testInsert(){

        Product product = new Product();
        product.setId(DateFormatUtils.format(new Date(),"yyyyMMddHHmmss"));
        product.setName("鸿茅药酒");
        product.setAddress("贵州");
        product.setNum("100");

        mongoTemplate.insert(product,COLLECTIONNAME);
    }

    @Test
    public void testGet(){
        List<Product> list =mongoTemplate.findAll(Product.class,COLLECTIONNAME);
        System.out.println(list);
    }
}
