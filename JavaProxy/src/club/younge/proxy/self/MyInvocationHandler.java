/** 
 * @projectName:JavaProxy 
 * @fileName:MyInvocationHandler.java 
 * @packageName:club.younge.proxy.self 
 * @date:2016年9月5日下午5:30:26 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */

package club.younge.proxy.self;

import java.lang.reflect.Method;

/**
 * @className:MyInvocationHandler
 * @function: TODO ADD FUNCTION.
 * @reason: TODO ADD REASON.
 * @date: 2016年9月5日 下午5:30:26
 * @author Younge
 * @version
 * @since JDK 1.8
 * @see
 */
public interface MyInvocationHandler {
	public Object invoke(Object obj, Method method, Object[] objArray) throws Throwable;
}
