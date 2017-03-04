import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Pavel on 02.03.2017.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Handling : " + method.getName() + "via the InvocationHandler");
        final MyAnnotation myAnnotation = object.getClass().getMethod(method.getName(), method.getParameterTypes())
                .getAnnotation(MyAnnotation.class);
        if(myAnnotation !=null){
            System.out.println("found: "+ myAnnotation.getClass().getSimpleName());
        }

        method.getName();
        return method.invoke(object, args);
    }
}
