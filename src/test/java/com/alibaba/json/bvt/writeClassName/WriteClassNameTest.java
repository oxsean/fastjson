package com.alibaba.json.bvt.writeClassName;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class WriteClassNameTest extends TestCase {

    public void test_list() throws Exception {
        A a = new A();
        a.setB(new B());
        String text = JSON.toJSONString(a, SerializerFeature.WriteClassName);
        System.out.println(text);
        Assert.assertEquals("{\"@type\":\"com.alibaba.json.bvt.writeClassName.WriteClassNameTest$A\",\"b\":{}}", text);
        
        A a1 = (A) JSON.parse(text);
        
        Assert.assertNotNull(a1.getB());
    }

    private static class A {

        private B b;

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }

    }

    private static final class B {
        
    }
}
