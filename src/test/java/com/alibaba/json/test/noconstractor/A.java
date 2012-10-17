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

    public Timestamp b;

    public A(Timestamp b) {
        this.b = b;
    }

    public Timestamp getB() {
        return b;
    }
}