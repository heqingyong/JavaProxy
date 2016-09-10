/** 
 * @projectName:JavaProxy 
 * @fileName:ProxyHandler.java 
 * @packageName:club.younge.proxy.jdk 
 * @date:2016年9月4日上午11:34:57 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */  
  
package club.younge.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import club.younge.proxy.People;

/** 
 * @className:ProxyHandler 
 * @function: TODO ADD FUNCTION.  
 * @reason:   TODO ADD REASON. 
 * @date:     2016年9月4日 上午11:34:57
 * @author   Younge 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class ProxyHandler implements InvocationHandler {

	private People people;
	public ProxyHandler(People people) {
		this.people = people;
	}
	@Override
	public Object invoke(Object obj, Method method, Object[] objArray) throws Throwable {
		
		before();
		method.invoke(people, objArray);
		after();
		return null;
	}
	
	private void before(){
		System.out.println("Before eat you should washes hands!");
	}
	
	private void after(){
		System.out.println("After eat you should do some work!");
	}

}

