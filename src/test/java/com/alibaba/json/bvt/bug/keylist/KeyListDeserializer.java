package com.alibaba.json.bvt.bug.keylist;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.CollectionDeserializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Set;


public class KeyListDeserializer extends CollectionDeserializer implements AutowiredObjectDeserializer {
    public static final KeyListDeserializer instance = new KeyListDeserializer();

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        KeyList list = new ArrayKeyList();
        Type itemType;
        if (type instanceof ParameterizedType) {
            itemType = ((ParameterizedType) type).getActualTypeArguments()[1];
        } else {
            itemType = Object.class;
        }
        parser.parseArray(itemType, list, fieldName);
        return (T) list;
    }

    @Override
    public Set<Type> getAutowiredFor() {
        return Collections.<Type>singleton(KeyList.class);
    }
}