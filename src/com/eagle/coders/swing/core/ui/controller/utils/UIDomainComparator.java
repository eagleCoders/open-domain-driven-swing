/**
 * 
 */
package com.eagle.coders.swing.core.ui.controller.utils;

import java.util.Comparator;

/**
 * @author Anees
 *
 */
public class UIDomainComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 > 02)
			return 1;
		else if (o1 < 02)
			return -1;
		return 0;
	}


}
