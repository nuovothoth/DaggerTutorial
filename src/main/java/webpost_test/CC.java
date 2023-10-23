package webpost_test;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CC {
    AA aa;
    BB bb;

    @Inject
    public CC(AA aa, BB bb) {
        this.aa = aa;
        this.bb = bb;
    }
}
