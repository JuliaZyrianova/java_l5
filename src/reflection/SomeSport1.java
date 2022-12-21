package reflection;
/**
 * A class that implements the sport interface
 * @see reflection.Sport
 * */
public class SomeSport1 implements Sport {

    @Override
    public void doSomething() {
        System.out.println("Football");
    }
}
