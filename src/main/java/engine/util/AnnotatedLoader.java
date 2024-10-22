package engine.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnotatedLoader {
    public Set<Class<?>> load(Class<? extends Annotation> anno) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream("game");

        assert stream != null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(this::getClass)
                .filter(clazz -> clazz.isAnnotationPresent(anno))
                .collect(Collectors.toSet());
    }

    private Class<?> getClass(String className) {
        try {
            return Class.forName("game" + "." + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException error) {
            throw new RuntimeException(error);
        }
    }
}
