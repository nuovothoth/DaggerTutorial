package webpost_test;

/*public class AA {
    private static AA aaInstance = new AA();
    private AA() {}

    public static AA getInstance() {
        return aaInstance;
    }
}*/

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
final class AA {
    @Inject
    public AA() {

    }
}
