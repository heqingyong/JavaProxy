/** 
 * @projectName:JavaProxy 
 * @fileName:Jason.java 
 * @packageName:club.younge.proxy 
 * @date:2016年9月4日上午11:31:55 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */  
  
package club.younge.proxy;  
/** 
 * @className:Jason 
 * @function: TODO ADD FUNCTION.  
 * @reason:   TODO ADD REASON. 
 * @date:     2016年9月4日 上午11:31:55
 * @author   Younge 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class Jason implements People{

	@Override
	public void eat() {
		System.out.println("Jason is eating now.");
		
	}

	@Override
	public void sleep() {
		System.out.println("Jason is sleeping now.");
		
	}

	@Override
	public void sport() {
		System.out.println("Jason is sporting now.");
		
	}

}

