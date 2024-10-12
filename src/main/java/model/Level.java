package model;

import java.util.List;

public class Level {
    private final List<Brick> bricks;
    private final Bar bar;
    private final Ball ball;
    private final Background background;
    
    public Level(List<Brick> bricks, Bar bar, Ball ball, Background background) {
        this.bricks = bricks;
        this.bar = bar;
        this.ball = ball;
        this.background = background;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public Bar getBar() {
        return bar;
    }

    public Ball getBall() {
        return ball;
    }

    public Background getBackground() {
        return background;
    }
    
    
}
