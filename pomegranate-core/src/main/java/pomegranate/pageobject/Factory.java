package pomegranate.pageobject;

import java.util.HashMap;

public class Factory {

    private static HashMap<Class, Object> pageObjects = new HashMap<>();

    public static <T extends PageObject> T reuse(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        if (pageObjects.containsKey(clazz)) {
            Object storedPageObject = pageObjects.get(clazz);
            return (T)storedPageObject;
        } else {
            T newPageObject = clazz.newInstance();
            pageObjects.put(clazz, newPageObject);
            return newPageObject;
        }
    }
}
