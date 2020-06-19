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
public class UiColumnComparator implements Comparator<UIDomainPropertyHolder> {

	@Override
	public int compare(UIDomainPropertyHolder o1, UIDomainPropertyHolder o2) {
//		if(o1.get)
//		return 0;
		return o1.getUiPositionColumn().compareTo(o2.getUiPositionColumn());
	}


}
