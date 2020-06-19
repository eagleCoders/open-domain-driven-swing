/**
 * 
 */
package com.eagle.coders.swing.core.ui.frame.container.builder;

import java.util.Collection;

import com.eagle.coders.swing.core.ui.controller.utils.FrameworkComponentLookupService;
import com.eagle.coders.swing.core.ui.interfaces.IUseCasesContainer;
import com.eagle.coders.swing.core.ui.usecase.container.cache.UsecaseContainerComponentCache;

/**
 * @author Anees
 *
 */
public class UseCaseContainerLoader {

	private static Collection<IUseCasesContainer> usecaseContainerList ;
	
	UsecaseContainerComponentCache usecaseContainerCache;

	/**
	 * 
	 */
	public static void loadAndCacheUsecaseContainer(){
		
		usecaseContainerList = FrameworkComponentLookupService.lookup(IUseCasesContainer.class);
		
		for(IUseCasesContainer container : usecaseContainerList){
			
			UsecaseContainerComponentCache.getInstance().addUseCaseToCache(container.getUseCaseContainerID(), container);
		}
		
	}
}
