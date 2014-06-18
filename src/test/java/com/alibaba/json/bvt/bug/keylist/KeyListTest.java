package com.alibaba.json.bvt.bug.keylist;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import org.junit.Assert;


public class KeyListTest extends TestCase {

    public static final String TEXT = "{\"books\":[{\"key\":\"asd\",\"name\":\"asd\",\"title\":\"zxc\"},{\"key\":\"asd1\",\"name\":\"asd1\",\"title\":\"zxcxx\"}],\"name\":\"c1\"}";

    public void testSerialize() {
        Catalog catalog = new Catalog();
        catalog.setName("c1");
        KeyList<String, Book> list = new ArrayKeyList<String, Book>();
        list.add(new Book("asd", "zxc"));
        list.add(new Book("asd1", "zxcxx"));
        catalog.setBooks(list);
        Assert.assertEquals(JSON.toJSONString(catalog), TEXT);
    }

    public void testDeserializer() {
        Assert.assertEquals(JSON.parseObject(TEXT, Catalog.class).getBooks().size(), 2);
    }
}
