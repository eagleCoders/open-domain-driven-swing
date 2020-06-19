/**
 * 
 */
package com.eagle.coders.swing.core.ui.taskbar.utils;

import java.util.Comparator;

import com.eagle.coders.swing.core.ui.cache.UIDomainPropertyHolder;

/**
 * @author Anees
 *
 */
public class UiRowComparator implements Comparator<UIDomainPropertyHolder> {

	@Override
	public int compare(UIDomainPropertyHolder o1, UIDomainPropertyHolder o2) {
		
		if(o1.getUiPositionRow() > o2.getUiPositionRow())
			return 1;
		else if (o1.getUiPositionRow() < o2.getUiPositionRow())
			return -1;
		else
			return 0;
	}

}
