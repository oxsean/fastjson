package com.alibaba.json.bvt.bug.keylist;

import java.util.List;

public interface KeyList<K, E extends Keyable<K>> extends List<E> {

    boolean containsKey(K key);

    E getByKey(K key);

    E removeByKey(K key);
}
