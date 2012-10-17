package com.alibaba.fastjson.util;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:oxsean@gmail.com">sean yang</a>
 * @version V1.0, 12-10-17
 */
public class ObjectInstantiatorFactory {
    private static ObjectInstantiator instantiator = null;

    static {
        try {
            Class.forName("org.objenesis.ObjenesisHelper");
            instantiator = new ObjenesisObjectInstantiator();
        } catch (ClassNotFoundException ignored) {
        }
    }

    private ObjectInstantiatorFactory() {
    }

    public static ObjectInstantiator getObjectInstantiator() {
        return instantiator;
    }
}
