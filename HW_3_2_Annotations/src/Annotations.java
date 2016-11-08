import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Альберт on 24.10.2016.
 */
public class Annotations {

    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите тип ключа: 1 - Обычный ключ, 2 - Магнитная карта, 3 - Сканер отпечатка");
        String s = reader.readLine();
        Class kl;
        if (s.equals("1")) {
            kl = simplyKey.class;
        } else {
            if (s.equals("2")) {
                kl = magnetKey.class;
            } else {
                kl = fingerKey.class;
            }
        }
     //   simplyKey a;
       // a.name();

        ArrayList<Method> arList = new ArrayList<>();

        for (final Method name : OpenDoor.class.getDeclaredMethods()) {
            arList.add(name);
            Annotation declaredAnnotation = name.getDeclaredAnnotation(kl);
            if (declaredAnnotation != null) {
                name.invoke(OpenDoor.class,new Object[]{});
            }
        }

        for (int i = 0; i < arList.size(); i++) {
            //  System.out.println(arList.get(i).getName() +  " " + arList.get(i).isAnnotationPresent(simplyKey.class));
            //Method m = new Method(OpenDoor.class.(arList.get(i).getName()));
            // OpenDoor.insertHole();

            try {
                if (arList.get(i).isAnnotationPresent(kl)) {

                    Class[] paramTypes = new Class[]{};
                    Method met = OpenDoor.class.getMethod((arList.get(i).getName()), paramTypes);
                    Object[] argss = new Object[]{};
                    OpenDoor bv = new OpenDoor();
                    Double d = (Double) met.invoke(bv, argss);
                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
    }

    @Documented
    @Inherited
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface simplyKey {
        String name() default "1";
    }

    @Documented
    @Inherited
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface magnetKey {
        String name() default "1";
    }

    @Documented
    @Inherited
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface fingerKey {
        String name() default "1";
    }


}
