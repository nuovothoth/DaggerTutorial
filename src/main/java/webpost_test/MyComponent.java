package webpost_test;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AModule.class, BModule.class})
public interface MyComponent {
    //provision 메소드
//    AA makeAA();

    //member-injection 메소드
    void inject(Main target);

}
