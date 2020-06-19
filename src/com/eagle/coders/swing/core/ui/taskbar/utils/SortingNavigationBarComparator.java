/**
 * 
 */
package com.eagle.coders.swing.core.ui.taskbar.utils;

import java.util.Comparator;

import com.eagle.coders.swing.core.ui.interfaces.INavigationBar;

/**
 * @author Anees
 *
 */
public class SortingNavigationBarComparator implements Comparator<INavigationBar> {

	@Override
	public int compare(INavigationBar o1, INavigationBar o2) {
		
		if(o1.getNavigationBarComponentPosition() > o2.getNavigationBarComponentPosition()){
			return 1;
		}else if (o1.getNavigationBarComponentPosition() < o2.getNavigationBarComponentPosition()){
			return -1;
		}
		return 0;
	}

}
