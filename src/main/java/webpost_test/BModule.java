package webpost_test;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class BModule {
    @Provides
    String provideName() {
        return "Charles";
    }

//    @Provides
//    @Singleton
//    BB provideBB(AA aa) {
//        return new BB(aa);
//    }
}
