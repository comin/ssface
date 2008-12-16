package com.softsimples.face.domain;

import com.softsimples.face.resource.Resource;
import com.softsimples.face.resource.ResourceType;
import java.io.Serializable;
import java.util.List;

public abstract class Domain implements Serializable {
    private static final long serialVersionUID = -2689674701064526682L;
    public void save() {
        LightPersistence lightPersistence = Resource.get(ResourceType.Persistence);
        List<Domain> sistema = lightPersistence.getSistema(this.getClass());
        sistema.add(this);
    };
    
    public static <DOMAIN> DOMAIN findAll(Class<? extends Domain> clazz) {
        LightPersistence lightPersistence = Resource.get(ResourceType.Persistence);
        return (DOMAIN)lightPersistence.getSistema(clazz);
    }
}
