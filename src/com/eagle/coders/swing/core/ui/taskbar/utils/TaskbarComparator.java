/**
 * 
 */
package com.eagle.coders.swing.core.ui.taskbar.utils;

import java.util.Comparator;

import com.eagle.coders.swing.core.ui.interfaces.ITaskBar;

/**
 * @author Anees
 *
 */
public class TaskbarComparator implements Comparator<ITaskBar> {

	@Override
	public int compare(ITaskBar o1, ITaskBar o2) {
		
		if(o1.getTaskBarComponentPosition() < o2.getTaskBarComponentPosition())
			return 1;
		else if (o1.getTaskBarComponentPosition() > o2.getTaskBarComponentPosition())
			return -1;
		return 0;
	}	

}
