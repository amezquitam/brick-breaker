package model.extra;

import org.junit.jupiter.api.Test;


public class TransformTest {
    @Test
    void testExtractFrom() {
        TestClass testClass = new TestClass(new Transform(new Vector2(0, 0), new Vector2(0, 0)));
        Transform transform = Transform.extractFrom(testClass);
        assertEquals(testClass.getTransform(), transform);
    }
}


class TestClass {
    private final Transform transform;

    public TestClass(Transform transform) {
        this.transform = transform;
    }

    public Transform getTransform() {
        return transform;
    }
}
