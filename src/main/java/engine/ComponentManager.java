package engine;

import engine.estereotype.Component;
import engine.util.AnnotatedLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentManager {
    private final Map<Class<?>, List<?>> components;

    private ComponentManager() {
        this.components = new HashMap<>();
        AnnotatedLoader loader = new AnnotatedLoader();
        var componentClasses = loader.load(Component.class);

        for (var componentClass : componentClasses) {
            System.out.println(componentClass.getName());
            components.put(componentClass, new ArrayList<>());
        }
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getComponents(Class<T> clazz) {
        return (List<T>) components.get(clazz);
    }

    @SuppressWarnings("unchecked")
    public <T> void addComponent(T component) {
        List<T> componentList = (List<T>) components.get(component.getClass());
        componentList.add(component);
    }

    private static ComponentManager INSTANCE;

    public static ComponentManager get() {
        if (INSTANCE == null) {
            INSTANCE = new ComponentManager();
        }
        return INSTANCE;
    }
}
