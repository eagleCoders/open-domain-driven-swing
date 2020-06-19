/**
 * 
 */
package com.eagle.coders.swing.core.ui.taskbar.fisheye;

import java.util.Map;

/**
 * @author Anees
 *
 */
public class FishEyeComponent {
	
	private static FishEyeComponent instance;
	
	private FishEyeComponent(){}
	
	public static FishEyeComponent getInstance(){
		
		if(null == instance)
			instance = new FishEyeComponent();
		
		return instance;
	}
	
//	public JPanel createTaskBar(Map<Integer, String> )

}
