/**
 * Created by Альберт on 24.10.2016.
 */
public class OpenDoor {

    @Annotations.simplyKey
    public static void insertHole () {
        System.out.println ("Вставил ключ");
        int i=1;
    }

    @Annotations.simplyKey
    public static void turnAround () {
        System.out.println ("Повернул ключ");
        int i=1;

    }

    @Annotations.simplyKey
    public static void removeKey () {
        System.out.println ("Вынул ключ");
        int i=1;

    }

    @Annotations.magnetKey
    public static void insertSlot () {
        System.out.println ("Вставил карту в слот");
        int i=1;

    }

    @Annotations.magnetKey
    public static void slideDown () {
        System.out.println ("Провел картой вниз");
        int i=1;

    }

    @Annotations.fingerKey
    public static void putFinger () {
        System.out.println ("Приложил палец");
        int i=1;

    }

}
