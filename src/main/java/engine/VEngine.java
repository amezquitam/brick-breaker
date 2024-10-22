package engine;

public class VEngine {
    private final ComponentManager componentManager;

    public VEngine() {
        this.componentManager = ComponentManager.get();
    }
}
