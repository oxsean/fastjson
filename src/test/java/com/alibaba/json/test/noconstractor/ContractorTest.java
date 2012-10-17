package com.alibaba.json.test.noconstractor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.sql.Timestamp;

public class ContractorTest extends TestCase {

    public void test_list() throws Exception {
        A a = new A(new Timestamp(System.currentTimeMillis()));
        String text = JSON.toJSONString(a, SerializerFeature.WriteClassName);
        System.out.println(text);
        
        A a1 = (A) JSON.parse(text);
        
        Assert.assertNotNull(a1.getB());
    }
}
