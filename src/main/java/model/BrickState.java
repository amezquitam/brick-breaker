package model;

public class BrickState {
    private final Integer maxCollisionTimes;
    private Integer collisionTimes;
    private Float velocity;

    public BrickState(Integer maxCollisionTimes, Integer collisionTimes) {
        this.maxCollisionTimes = maxCollisionTimes;
        this.collisionTimes = collisionTimes;
        this.velocity = 0.0F;
    }

    public void increment() {
        collisionTimes++;
    }

    public boolean isBroken() {
        return maxCollisionTimes <= collisionTimes;
    }

    public void accelerateY(Float dv) {
        this.velocity += dv;
    }

    public Float getVelocity() {
        return velocity;
    }

    public Integer getCollisionTimes() {
        return collisionTimes;
    }

    public Integer getMaxCollisionTimes() {
        return maxCollisionTimes;
    }
}
