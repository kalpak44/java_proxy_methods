import javassist.util.proxy.MethodHandler;

import java.lang.reflect.Method;

/**
 * Created by Pavel on 02.03.2017.
 */
public class MyMethodHandler implements MethodHandler {

    @Override
    public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
        System.out.println("Handling " + thisMethod + " via the method handler");
        final MyAnnotation myAnnotation = thisMethod.getAnnotation(MyAnnotation.class);
        if (myAnnotation != null) {
            System.out.println("found: " + myAnnotation.toString());
        }
        return proceed.invoke(self, args);
    }
}
