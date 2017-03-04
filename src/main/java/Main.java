import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * Created by Pavel on 02.03.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {


        final MyClass myClass = new MyClass();

        /* reflect proxy example */
        final MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyClass.class.getClassLoader(),
                MyClass.class.getInterfaces(),
                new MyInvocationHandler(myClass));

        proxy.myMethod();



        /* javassist proxy example  (without abstract classes and interfaces)*/

        final ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(MyClass.class);

        final MyMethodHandler methodHandler = new MyMethodHandler();
        final MyClass myClassProxy = (MyClass) factory.create(new Class<?>[0], new Object[0], methodHandler);
        myClassProxy.myMethod();



         /* javassist proxy example  (with abstract method filter)*/

        factory.setSuperclass(MyClassAbstract.class);
        factory.setFilter(
                method -> Modifier.isAbstract(method.getModifiers())
        );

        MyClassAbstract myClassAbstractProxy = (MyClassAbstract) factory
                .create(new Class<?>[0], new Object[0], new MyMethodAbstractHandler());
        myClassAbstractProxy.myMethod();

    }

}

