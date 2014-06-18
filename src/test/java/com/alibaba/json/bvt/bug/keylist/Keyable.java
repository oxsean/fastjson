package com.alibaba.json.bvt.bug.keylist;

/**
 * A keyable object can provide an immutable key for this object.
 * <p/>
 * It is important for the key to not be mutable and that the key value itself
 * is not changed in the object. If this happens any AutoIndex, or Map using
 * this key will break.
 */
public interface Keyable<K> {

    /**
     * Gets the immutable key for this object.
     *
     * @return gets the immutable key for this object
     */
    K getKey();
}
