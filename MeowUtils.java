//2
public class MeowUtils {

    public static void makeAllMeow(Meowable... meowables) {
        for (Meowable m : meowables) {
            m.meow();
        }
    }
}