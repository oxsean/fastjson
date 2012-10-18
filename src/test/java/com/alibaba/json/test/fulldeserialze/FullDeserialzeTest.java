package com.alibaba.json.test.fulldeserialze;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.io.Serializable;
import java.util.Date;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:oxsean@gmail.com">sean yang</a>
 * @version V1.0, 12-10-18
 */
public class FullDeserialzeTest extends TestCase {
    public void testContractor() throws Exception {
        Serializable[] ss = new Serializable[]{1, "asd", new Date(1231234123), Status.DELETED};
        CacheEntry cacheEntry = new CacheEntry(ss, "asdasd", false, "asda");
        String out = JSON.toJSONString(cacheEntry, SerializerFeature.WriteClassName);
        System.out.println(out);
        CacheEntry cacheEntry1 = (CacheEntry) JSON.parse(out);
        System.out.println(cacheEntry1);
        Assert.assertEquals(cacheEntry, cacheEntry1);
    }
}
