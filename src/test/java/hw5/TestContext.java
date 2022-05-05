package hw5;

import java.util.HashMap;

public class TestContext {
    private static TestContext instance;
    private final HashMap<String, Object> context = new HashMap<>();

    private TestContext() {
    }

    public TestContext putTestObject(String key, Object value) {
        context.put(key, value);
        return this;
    }

    public <T> T getTestObject(String key) {
        return (T) context.get(key);
    }

    public void clear() {
        instance = null;
        context.clear();
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
