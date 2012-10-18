package com.alibaba.json.test.fulldeserialze;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:oxsean@gmail.com">sean yang</a>
 * @version V1.0, 12-10-17
 */

import java.io.Serializable;
import java.util.Arrays;

public final class CacheEntry implements Serializable {
    private static final long serialVersionUID = -1965811568498235538L;
    private final Object[] disassembledState;
    private final String subclass;
    private final boolean lazyPropertiesAreUnfetched;
    private final Object version;

    public String getSubclass() {
        return subclass;
    }

    public boolean areLazyPropertiesUnfetched() {
        return lazyPropertiesAreUnfetched;
    }

    public Object getVersion() {
        return version;
    }

    public CacheEntry(Object[] state, String subclass, boolean unfetched, Object version) {
        this.disassembledState = state;
        this.subclass = subclass;
        this.lazyPropertiesAreUnfetched = unfetched;
        this.version = version;
    }


    public Object[] getDisassembledState() {
        return disassembledState;
    }

    public String toString() {
        return "CacheEntry(" + subclass + ')' + Arrays.toString(disassembledState);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CacheEntry) {
            CacheEntry entry1 = (CacheEntry) obj;
            return Arrays.equals(disassembledState, entry1.getDisassembledState())
                    && subclass.equals(entry1.getSubclass())
                    && lazyPropertiesAreUnfetched == entry1.areLazyPropertiesUnfetched()
                    && version.equals(entry1.getVersion());
        }
        return false;
    }
}
