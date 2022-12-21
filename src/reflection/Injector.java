package reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * class Injector implements dependency injection into any object that contains fields,
 * marked with the annotation @AutoInjectable
 * @see AutoInjectable
 */

public class Injector {

    private static Properties properties=new Properties();

    /**
     * function inject
     *using reflection mechanisms, it searches for fields marked with this annotation
     *  (some interface is used as the field type), and initializes these fields with instances of classes
     * that are specified as an implementation of the corresponding interface in some settings file
     * @param object object of any class
     * @return object with initialized fields with annotation
     */
    public static <Type> Type inject(Type object) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        load_properties_file();

        //FileInputStream im=new FileInputStream("injector.properties"); //"C:\\Users\\julia\\IdeaProjects\\l5_java\\injector.properties"
        //properties.load(im);

        Field[] fields=object.getClass().getDeclaredFields();
        for(Field f:fields){
            AutoInjectable a = f.getAnnotation(AutoInjectable.class);
            if(a != null){
                //System.out.println(f.getName());
                f.setAccessible(true);
                String f_class_name=f.getType().getName();
                Object o=Class.forName(properties.getProperty(f_class_name)).newInstance( );
                f.set(object,o);
            }
        }
        return object;
    }

    /**
     * function of initializing the configuration object
     */
    private static void load_properties_file() {
        try {
            FileInputStream im = new FileInputStream("injector.properties");
            properties.load(im);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

