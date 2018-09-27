package proxy;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Create by xuantang
 * @date on 8/26/18
 */
public class DynamicProxy {

    private String name;
    public DynamicProxy() {}

    public DynamicProxy(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy("Sss");
        try {
            Constructor<? extends DynamicProxy> constructor = dynamicProxy.getClass().getConstructor(String.class);

            DynamicProxy dynamicProxy1 = constructor.newInstance("ss");
            System.out.println(dynamicProxy1.name);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        AddService service = new AddServiceImpl();
        AddServiceHandler addServiceHandler = new AddServiceHandler(service);
        AddService proxy = addServiceHandler.getProxy();
        Assert.assertEquals(3, proxy.add(1, 2));

        System.out.println(service.getClass().getClassLoader());


        System.out.println(Object.class.getClassLoader());

        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }

    @Test
    public void dynamicProxyTest() {
        AddServiceImpl service = new AddServiceImpl();
        AddServiceHandler addServiceHandler = new AddServiceHandler(service);
        AddService proxy = addServiceHandler.getProxy();
        Assert.assertEquals(3, proxy.add(1, 2));
    }
}
