package club.younge.proxy.self;
import java.lang.reflect.Method;
public class $Proxy0 implements club.younge.proxy.People{
MyInvocationHandler h;
public $Proxy0(MyInvocationHandler h) {
this.h = h;
}
public void sleep() throws Throwable {
Method md = club.younge.proxy.People.class.getMethod("sleep", new Class[]{});
this.h.invoke(this, md, null);
}
public void eat() throws Throwable {
Method md = club.younge.proxy.People.class.getMethod("eat", new Class[]{});
this.h.invoke(this, md, null);
}
public void sport() throws Throwable {
Method md = club.younge.proxy.People.class.getMethod("sport", new Class[]{});
this.h.invoke(this, md, null);
}

}