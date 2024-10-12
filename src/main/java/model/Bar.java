package model;

import model.extra.Sound;
import model.extra.Transform;

public class Bar {
    private final Transform transform;
    private final Sound sound;

    public Bar(Transform transform, Sound sound) {
        this.transform = transform;
        this.sound = sound;
    }

    public Transform getTransform() {
        return transform;
    }

    public Sound getSound() {
        return sound;
    }
}
