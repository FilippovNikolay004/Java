package practice;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Mammals.class)
@interface Mammal {
    String sound();
    int color() default 0xFFFFFF;
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Mammals {
    Mammal[] value();
}

@Mammal(color = 0xFFA844, sound = "uuuu uuuu uuuu")
@Mammal(sound = "mmm mmm mmm")
class Giraffe {
    // some code here
}

public class Program {
    public static void main(String[] args) {
        Class<Giraffe> gc = Giraffe.class;

        System.out.println("Все аннотации (сырые):");
        for (Annotation a : gc.getAnnotations()) {
            System.out.println(" - " + a.annotationType().getSimpleName() + " -> " + a);
        }

        System.out.println("\nАннотации Mammal (развёрнутые):");
        Mammal[] mammalAnns = gc.getAnnotationsByType(Mammal.class);
        int i = 1;
        for (Mammal m : mammalAnns) {
            System.out.println("Mammal #" + (i++));
            System.out.println("  color: 0x" + Integer.toHexString(m.color()).toUpperCase());
            System.out.println("  sound: " + m.sound());
        }
    }
}
