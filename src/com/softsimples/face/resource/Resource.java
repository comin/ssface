package com.softsimples.face.resource;

import java.util.HashMap;

public class Resource {

    private static final HashMap<ResourceType, Object> resources = new HashMap<ResourceType, Object>();

    public Resource() {}

    public static void add(ResourceType key, Object value) {
        resources.put(key, value);
    }

    public static Object remove(ResourceType key) {
        return resources.remove(key);
    }

    public static void removeAll() {
        resources.clear();
    }

    public static <T> T get(ResourceType key) {
        return (T) resources.get(key);
    }
}
