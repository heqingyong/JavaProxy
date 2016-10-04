/** 
 * @projectName:JavaProxy 
 * @fileName:MyProxy.java 
 * @packageName:club.younge.proxy.self 
 * @date:2016��9��5������5:34:24 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */

package club.younge.proxy.self;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * @className:MyProxy
 * @function: TODO ADD FUNCTION.
 * @reason: TODO ADD REASON.
 * @date: 2016��9��5�� ����5:34:24
 * @author Younge
 * @version
 * @since JDK 1.8
 * @see
 */
public class MyProxy {
	private static String rt = "\r\n";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object newProxyInstance(ClassLoader classLoader, Class interfs,
			MyInvocationHandler invocationHandler) {
		try {
			Method[] methods = interfs.getMethods();
			
			// 1.����һ��JAVA�ļ��������ķ�ʽ����һ��JAVA�ļ�������JAVA�ļ�String����
			String proxyClass = "package club.younge.proxy.self;" + rt + "import java.lang.reflect.Method;" + rt
					+ "public class $Proxy0 implements " + interfs.getName() + "{" + rt + "MyInvocationHandler h;" + rt
					+ "public $Proxy0(MyInvocationHandler h) {" + rt + "this.h = h;" + rt + "}"
					+ getMethodStr(methods, interfs) + rt + "}";
			
			// 2.�������ļ�
			String fileName = "E:/GitLocal/Java/JavaProxy/JavaProxy"  //�����ע���ļ�·���Ƿ���ȷ��������Ĺ���Ŀ¼
					+ "/src/club/younge/proxy/self/$Proxy0.java";
			File file = new File(fileName);
			FileWriter fileWriter = new FileWriter(file);

			fileWriter.write(proxyClass);
			fileWriter.flush();
			fileWriter.close();
			
			// 3. ����JAVA�ļ�
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager stdFileMgr = compiler.getStandardFileManager(null, null, null);
			Iterable units = stdFileMgr.getJavaFileObjects(fileName);
			CompilationTask task = compiler.getTask(null, stdFileMgr, null, null, null, units);
			task.call();
			stdFileMgr.close();
			//file.delete(); //�����ɽ����ļ�ɾ���������JDK��̬����һ����Ч��
			
			// 4.��class�ֽ�����ص��ڴ���  ////�����ע���ļ�·���Ƿ���ȷ��������Ĺ���Ŀ¼
			MyClassLoader classLoader2 = new MyClassLoader("E:/GitLocal/Java/JavaProxy/JavaProxy"
					+ "/src/club/younge/proxy/self/");
			Class proxy0Class = classLoader2.findClass("$Proxy0");
			Constructor constructor = proxy0Class.getConstructor(MyInvocationHandler.class);
			Object object = constructor.newInstance(invocationHandler);
			return object;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("rawtypes")
	private static String getMethodStr(Method[] methods, Class interfs) {
		StringBuilder builder = new StringBuilder();
		builder.append(rt);
		for (Method method : methods) {
			builder.append("public void ").append(method.getName()).append("() throws Throwable {").append(rt)
					.append("Method md = ").append(interfs.getName()).append(".class.getMethod(\"")
					.append(method.getName()).append("\", new Class[]{});").append(rt)
					.append("this.h.invoke(this, md, null);").append(rt).append("}").append(rt);
		}
		return builder.toString();
	}
}
