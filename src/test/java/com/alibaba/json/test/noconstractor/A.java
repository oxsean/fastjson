package com.alibaba.json.test.noconstractor;

import java.sql.Timestamp;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:oxsean@gmail.com">sean yang</a>
 * @version V1.0, 12-10-17
 */
public class A {

    private Timestamp b;
    private long c;

    public A(Timestamp b,long c) {
        this.b = b;
        this.c=c;
    }

    public Timestamp getB() {
        return b;
    }

    public long getC() {
        return c;
    }
}