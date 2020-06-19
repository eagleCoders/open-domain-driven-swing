/**
 * 
 */
package com.eagle.coders.swing.core.ui.controller.utils;

import java.util.Collection;

import org.openide.util.Lookup;
import org.openide.util.Lookup.Result;
import org.openide.util.Lookup.Template;

/**
 * @author Anees
 *
 */
public class FrameworkComponentLookupService {

	/**
	 * 
	 * @param interfaze
	 * @param lookupType
	 * @return
	 */
	public static Collection lookup(Class interfaze){
		
		try{
			
			Lookup lookup = Lookup.getDefault();
			Template cachingEnginesTemplate = new Template(interfaze);
			Result results = lookup.lookup(cachingEnginesTemplate);
			Collection cacheImpls = results.allInstances();
			
			
			return cacheImpls;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
