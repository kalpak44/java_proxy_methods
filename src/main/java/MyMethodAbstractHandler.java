import javassist.util.proxy.MethodHandler;

import java.lang.reflect.Method;

/**
 * Created by Pavel on 02.03.2017.
 */
public class MyMethodAbstractHandler implements MethodHandler {

    @Override
    public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
        System.out.println("Handling " + thisMethod + " via the method handler");
        return null;
    }
}
