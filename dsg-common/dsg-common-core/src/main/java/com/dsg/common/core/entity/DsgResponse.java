package com.dsg.common.core.entity;

import java.util.HashMap;

/**
 * @author MrBird
 */
public class DsgResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public DsgResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public DsgResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public DsgResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getMessage() {
        return String.valueOf(get("message"));
    }

    public Object getData() {
        return get("data");
    }
}
