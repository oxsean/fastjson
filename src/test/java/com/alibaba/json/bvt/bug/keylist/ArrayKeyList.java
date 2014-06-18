package com.alibaba.json.bvt.bug.keylist;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ArrayKeyList<K, E extends Keyable<K>> extends ArrayList<E> implements KeyList<K, E> {
    private static final long serialVersionUID = -2164299517672361322L;
    private transient Map<K, Integer> keys = new HashMap<K, Integer>();

    public ArrayKeyList(int initialCapacity) {
        super(initialCapacity);
    }

    public ArrayKeyList() {
    }

    public ArrayKeyList(Collection<? extends E> c) {
        super(c);
        rebuildKeys();
    }

    @Override
    @SuppressWarnings("unchecked")
    public int indexOf(Object o) {
        if (o instanceof Keyable) {
            Integer key = keys.get(((Keyable<K>) o).getKey());
            if (key != null) {
                return key;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return indexOf(o);
    }

    @Override
    public E set(int index, E element) {
        E oldElement = get(index);
        if (oldElement != null) {
            keys.remove(oldElement.getKey());
        }
        E ret = super.set(index, element);
        keys.put(element.getKey(), index);
        return ret;
    }

    @Override
    public boolean add(E element) {
        boolean ret = true;
        Integer index = keys.get(element.getKey());
        if (index != null) {
            super.set(index, element);
        } else {
            ret = super.add(element);
            keys.put(element.getKey(), size() - 1);
        }
        return ret;
    }

    @Override
    public void add(int index, E element) {
        Integer oldIndex = keys.get(element.getKey());
        if (oldIndex != null) {
            super.set(oldIndex, element);
        } else {
            super.add(index, element);
            rebuildKeys(index);
        }
    }

    @Override
    public E remove(int index) {
        E ret = super.remove(index);
        rebuildKeys(index);
        keys.remove(ret.getKey());
        return ret;
    }

    @Override
    public boolean remove(Object o) {
        if (o != null) {
            int index = indexOf(o);
            if (index > -1) {
                remove(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        super.clear();
        keys.clear();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (add(e) && !modified) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean modified = false;
        int from = index;
        for (E element : c) {
            Integer oldIndex = keys.get(element.getKey());
            if (oldIndex != null) {
                super.set(oldIndex, element);
            } else {
                super.add(index++, element);
            }
            if (!modified) {
                modified = true;
            }
        }
        rebuildKeys(from);
        return modified;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
        rebuildKeys(fromIndex);
    }

    @Override
    public boolean containsKey(K key) {
        return keys.containsKey(key);
    }

    @Override
    public E getByKey(K key) {
        Integer index = keys.get(key);
        return index == null ? null : get(index);
    }

    @Override
    public E removeByKey(K key) {
        Integer index = keys.get(key);
        if (index != null) {
            E element = get(index);
            remove(index.intValue());
            return element;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public Object clone() {
        ArrayKeyList<K, E> v = (ArrayKeyList<K, E>) super.clone();
        v.rebuildKeys();
        return v;
    }

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        is.defaultReadObject();
        rebuildKeys();
    }

    void rebuildKeys() {
        rebuildKeys(0);
    }

    void rebuildKeys(int from) {
        for (int i = from, len = size(); i < len; i++) {
            keys.put(get(i).getKey(), i);
        }
    }
}
