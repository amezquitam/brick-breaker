package model;

import model.extra.Transform;

public class Bar {
    final Transform transform;

    public Bar(Transform transform) {
        this.transform = transform;
    }

    public Transform getTransform() {
        return transform;
    }
}
