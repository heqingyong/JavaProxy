/** 
 * @projectName:JavaProxy 
 * @fileName:MyClassLoader.java 
 * @packageName:club.younge.proxy.self 
 * @date:2016年9月5日下午11:35:07 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */

package club.younge.proxy.self;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @className:MyClassLoader
 * @function: TODO ADD FUNCTION.
 * @reason: TODO ADD REASON.
 * @date: 2016年9月5日 下午11:35:07
 * @author Younge
 * @version
 * @since JDK 1.8
 * @see
 */
public class MyClassLoader extends ClassLoader {

	private File dir;

	public MyClassLoader(String path) {
		dir = new File(path);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		if (dir != null) {
			File classFile = new File(dir, name + ".class");
			if (classFile.exists()) {
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(classFile);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = fis.read(buffer)) != -1) {
						baos.write(buffer, 0, len);
					}

					return defineClass("club.younge.proxy.self." + name, baos.toByteArray(), 0, baos.size());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}

			}
		}
		return super.findClass(name);
	}
}
