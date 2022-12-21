package reflection;
import java.io.*;
/**
 * Laboratory work 5
 * <p>
 * the program demonstrates working with reflection
 * @author Julia Zyrianova
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        SomeBean sb = (new Injector()).inject(new SomeBean());
        sb.foo();
    }

}
