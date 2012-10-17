package com.alibaba.fastjson.util;

import org.objenesis.ObjenesisHelper;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:oxsean@gmail.com">sean yang</a>
 * @version V1.0, 12-10-17
 */
public class ObjenesisObjectInstantiator implements ObjectInstantiator {
    public Object newInstance(Class type) {
        return ObjenesisHelper.newInstance(type);
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
