/** 
 * @projectName:JavaProxy 
 * @fileName:MyProxyHandler.java 
 * @packageName:club.younge.proxy.self 
 * @date:2016年9月5日下午5:31:06 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */  
  
package club.younge.proxy.self;

import java.lang.reflect.Method;

import club.younge.proxy.People;

/** 
 * @className:MyProxyHandler 
 * @function: TODO ADD FUNCTION.  
 * @reason:   TODO ADD REASON. 
 * @date:     2016年9月5日 下午5:31:06
 * @author   Younge 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class MyProxyHandler implements MyInvocationHandler{
	private People people;
	public MyProxyHandler(People people) {
		this.people = people;
	}
	@Override
	public Object invoke(Object obj, Method method, Object[] objArray) throws Throwable {
		before();
		people.eat();
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

