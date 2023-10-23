package webpost_test;

import javax.inject.Inject;
import javax.inject.Singleton;


public class Main {
    @Inject AA aa;
    @Inject BB bb;
    @Inject CC cc;

    static MyComponent myComponent = DaggerMyComponent.create();

    public Main() {
//        DaggerMyComponent.create().inject(this);
        myComponent.inject(this);
    }

    public static void main(String[] args) {
        Main main1 = new Main();
        Main main2 = new Main();

        System.out.println("main1.aa = " + main1.aa);
        System.out.println("main2.aa = " + main2.aa);
//        System.out.println("myComponent.aa = " + myComponent.makeAA() + "\n");

        System.out.println("main1.bb = " + main1.bb);
        System.out.println("main2.bb = " + main2.bb + "\n");

        System.out.println("main1.cc = " + main1.cc);
        System.out.println("main2.cc = " + main2.cc + "\n");
    }
}
