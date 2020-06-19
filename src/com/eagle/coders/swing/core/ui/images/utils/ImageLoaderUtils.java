/**
 * 
 */
package com.eagle.coders.swing.core.ui.images.utils;

import java.io.FileInputStream;

/**
 * @author Anees
 *
 */
public class ImageLoaderUtils {
	
	private static final String BASE_IMG_DIR = "com/eagle/coders/swing/core/ui/images/";
	
	/**
	 * 
	 * @return
	 */
	public static String loadImage(String imageName){
		
		return ImageLoaderUtils.class.getClassLoader().getResource("com/eagle/coders/swing/core/ui/images/"+imageName).getFile();
	}
	
	/**
	 * 
	 * @param imageName
	 * @param path
	 * @return
	 */
	public static String loadImage(String imageName, String path){
		
		if(null == path){
			return ImageLoaderUtils.class.getClassLoader().getResource(BASE_IMG_DIR+imageName).getFile();
		}else{
			return ImageLoaderUtils.class.getClassLoader().getResource(path+imageName).getFile();
		}
	}
}