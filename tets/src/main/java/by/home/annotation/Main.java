package by.home.annotation;

import by.home.annotation.customAnnotation.Analyz;
import by.home.annotation.domain.SomeObject;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws Exception {
        Analyz analyz = new Analyz();
        /*System.out.println("Hello World");
        List<SomeObject> someObjects = new ArrayList<SomeObject>();
        boolean add = someObjects.add(new SomeObject("Sasha", "Bogatov", 28, (long) 1, "1"));
        someObjects.add(new SomeObject("Sergey", "Razudalov", 28, (long) 2, "2"));
        someObjects.add(new SomeObject("Dmitriy", "Nagarev", 28, (long) 3, "3"));
        someObjects.add(new SomeObject("Valera", "Guzanov", 26, (long) 4, "4"));
        someObjects.forEach(System.out::println);*/
        System.out.println(analyz.analyz(SomeObject.class));
    }
}
