package com.alibaba.fastjson.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:oxsean@gmail.com">sean yang</a>
 * @version V1.0, 12-10-17
 */
public class FieldUtils {
    private static final Map<String, Field> CACHE = new ConcurrentHashMap<String, Field>();

    public static void setValue(Object obj, Object value, String fieldName) {
        Class clazz = obj.getClass();
        String key = clazz.getName() + "#" + fieldName;
        Field field = CACHE.get(key);
        try {
            if (field == null) {
                field = getFiled(clazz, fieldName);
                CACHE.put(key, field);
            }
            field.set(obj, value);
        } catch (Exception ignored) {
        }
    }

    private static Field getFiled(Class clazz, String fieldName) {
        Class searchType = clazz;
        while (!Object.class.equals(searchType) && searchType != null) {
            Field[] fields = searchType.getDeclaredFields();
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                if (fieldName.equals(field.getName())) {
                    if (!Modifier.isPublic(field.getModifiers())) {
                        field.setAccessible(true);
                    }
                    return field;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }
}
