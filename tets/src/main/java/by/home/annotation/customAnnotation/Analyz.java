package by.home.annotation.customAnnotation;

import java.lang.reflect.Field;

public class Analyz {
    public String analyz(Class<?> clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        int pass = 0;
        int fail = 0;
        for (Field field : fields) {
            if (field.isAnnotationPresent(SearchFind.class)) {
                try {
                    pass++;
                } catch (Exception e) {
                    fail++;
                }
            }
        }
        return pass + " " + fail;
    }
}
