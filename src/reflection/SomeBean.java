package reflection;

public class SomeBean {
    @AutoInjectable
    private Sport field1;

    @AutoInjectable
    private Art field2;

    public void foo(){
        field1.doSomething();
        field2.doSomeOther();
    }
}
