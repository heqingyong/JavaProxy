/** 
 * @projectName:JavaProxy 
 * @fileName:SelfTest.java 
 * @packageName:club.younge.test 
 * @date:2016年9月5日下午5:38:08 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */  
  
package club.younge.test;

import club.younge.proxy.Jason;
import club.younge.proxy.People;
import club.younge.proxy.self.MyProxy;
import club.younge.proxy.self.MyProxyHandler;

/** 
 * @className:SelfTest 
 * @function: TODO ADD FUNCTION.  
 * @reason:   TODO ADD REASON. 
 * @date:     2016年9月5日 下午5:38:08
 * @author   Younge 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class SelfTest {

	public static void main(String[] args) throws Throwable {
		People people = (People) MyProxy.newProxyInstance(People.class.getClassLoader(), People.class, new MyProxyHandler(new Jason()));
		people.eat();
		System.out.println("Game over!");

	}

}

