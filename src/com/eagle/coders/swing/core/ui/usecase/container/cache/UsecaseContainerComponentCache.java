/**
 * 
 */
package com.eagle.coders.swing.core.ui.usecase.container.cache;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JInternalFrame;

import nl.jj.swingx.gui.modal.JModalInternalFrame;

import com.eagle.coders.swing.core.ui.interfaces.INavigationBar;
import com.eagle.coders.swing.core.ui.interfaces.IToolbar;
import com.eagle.coders.swing.core.ui.interfaces.IUseCasesContainer;

/**
 * @author Anees
 *
 */
public class UsecaseContainerComponentCache {

	private static UsecaseContainerComponentCache instance;
	
	Map<String, IUseCasesContainer> usecaseContainerMap;
	
	Map<String, JInternalFrame> usecaseFrameContainerMap;
	
	Map<String, JInternalFrame> usecaseContainiFrameMap;
	
	Map<String, JModalInternalFrame> usecaseContainiModalFrameMap;
	
	Map<String, IToolbar> usecaseToolBarsCache;
	
	Map<String, INavigationBar> usecaseNavigationBarsCache;
	
	private UsecaseContainerComponentCache(){
		
		usecaseContainerMap = new HashMap<String, IUseCasesContainer>();
		
		usecaseFrameContainerMap = new HashMap<String, JInternalFrame>();
		
		usecaseContainiFrameMap = new HashMap<String, JInternalFrame>();
		
		usecaseContainiModalFrameMap = new HashMap<String, JModalInternalFrame>();
		
		usecaseToolBarsCache = new HashMap<String, IToolbar>();
		
		usecaseNavigationBarsCache = new HashMap<String, INavigationBar>();
	}
	
	public static UsecaseContainerComponentCache getInstance(){
		
		if(null == instance){
			instance = new UsecaseContainerComponentCache();
		}
		return instance;
	}

	/**
	 * @return the usecaseContainerMap
	 */
	public IUseCasesContainer getUsecaseFromContainerMap(String usecontainerID) {
		
		IUseCasesContainer useCaseContainer = null;
		
		if(usecaseContainerMap.containsKey(usecontainerID)){
			
			useCaseContainer = usecaseContainerMap.get(usecontainerID);
		}
		
		return useCaseContainer;
	}
	
	/**
	 * 
	 * @param usecontainerID
	 * @param useCaseContainer
	 */
	public void addUseCaseToCache(String usecontainerID, IUseCasesContainer useCaseContainer){
		
		if(!usecaseContainerMap.containsKey(usecontainerID)){
			
			usecaseContainerMap.put(usecontainerID, useCaseContainer);
		}
	}

	/**
	 * @param usecaseContainerMap the usecaseContainerMap to set
	 */
	public void setUsecaseContainerMap(
			Map<String, IUseCasesContainer> usecaseContainerMap) {
		this.usecaseContainerMap = usecaseContainerMap;
	}
	
	/**
	 * 
	 * @param componentID
	 * @return
	 */
	public JInternalFrame getUsecaseContaineriFrameMap(String componentID){
		
		if(usecaseContainiFrameMap.containsKey(componentID)){
			
			return usecaseContainiFrameMap.get(componentID);
		}
		return null;
	}
	
	/**
	 * 
	 * @param componentID
	 * @return
	 */
	public JModalInternalFrame getUsecaseContaineriModalFrameMap(String componentID){
		
		if(usecaseContainiModalFrameMap.containsKey(componentID)){
			
			return usecaseContainiModalFrameMap.get(componentID);
		}
		return null;
	}
	
	/**
	 * 
	 * @param componentID
	 * @param iModalFrame
	 */
	public void addUsecaseiModalFrameToCache(String componentID, JModalInternalFrame iModalFrame){
		
		if(!usecaseContainiModalFrameMap.containsKey(componentID)){
			
			usecaseContainiModalFrameMap.put(componentID, iModalFrame);
		}
	}
	
	public void removeUsecaseiModalFromCache(String componentID){
		
		if(usecaseContainiModalFrameMap.containsKey(componentID)){
			
			usecaseContainiModalFrameMap.remove(componentID);
		}
	}
	
	public Map<String, JModalInternalFrame> getUsecaseiModalFrom(){
		
		return usecaseContainiModalFrameMap;
	}
	
	/**
	 * 
	 * @param componentID
	 * @param iFrame
	 */
	public void addUsecaseiFrameToCache(String componentID, JInternalFrame iFrame){
		
		if(!usecaseContainiFrameMap.containsKey(componentID)){
			
			usecaseContainiFrameMap.put(componentID, iFrame);
		}
	}
	
	/**
	 * 
	 * @param usecontainerID
	 */
	public void removeUsecaseiFrameFromCache(String usecontainerID){
		
		if(usecaseContainiFrameMap.containsKey(usecontainerID)){
			
			usecaseContainiFrameMap.remove(usecontainerID);
		}
	}

	
	/**
	 * 
	 * @param usecontainerID
	 * @return
	 */
	public JInternalFrame getUsecaseContainerFrmeFromMap(String usecontainerID) {
		
		JInternalFrame useCaseContainer = null;
		
		if(usecaseFrameContainerMap.containsKey(usecontainerID)){
			
			useCaseContainer = usecaseFrameContainerMap.get(usecontainerID);
		}
		
		return useCaseContainer;
	}

	/**
	 * 
	 * @param usecontainerID
	 * @param useCaseContainerFrame
	 */
	public void addUsecaseFrameToCache(String usecontainerID, JInternalFrame useCaseContainerFrame){
		
		if(!usecaseFrameContainerMap.containsKey(usecontainerID)){
			
			usecaseFrameContainerMap.put(usecontainerID, useCaseContainerFrame);
		}
	}

	/**
	 * 
	 * @param usecontainerID
	 */
	public void removeUsecaseFrameFromCache(String usecontainerID){
		
		if(usecaseFrameContainerMap.containsKey(usecontainerID)){
			
			usecaseFrameContainerMap.remove(usecontainerID);
		}
	}
	
	public Map<String, JInternalFrame> getUsecaseFrameContainerMap(){
		
		return usecaseFrameContainerMap;
	}

	/**
	 * @return the usecaseToolBarsCache
	 */
	public Map<String, IToolbar> getUsecaseToolBarsCache() {
		return usecaseToolBarsCache;
	}

	/**
	 * @param usecaseToolBarsCache the usecaseToolBarsCache to set
	 */
	public void setUsecaseToolBarsCache(Map<String, IToolbar> usecaseToolBarsCache) {
		this.usecaseToolBarsCache = usecaseToolBarsCache;
	}

	/**
	 * @return the usecaseNavigationBarsCache
	 */
	public Map<String, INavigationBar> getUsecaseNavigationBarsCache() {
		return usecaseNavigationBarsCache;
	}
	
	/**
	 * 
	 * @param navigationBarID
	 * @return
	 */
	public INavigationBar getNavigationByID(String navigationBarID){
		
		if(usecaseNavigationBarsCache.containsKey(navigationBarID)){
			return usecaseNavigationBarsCache.get(navigationBarID);
		}
		return null;
	}
	
	/**
	 * 
	 * @param navigationBarID
	 * @param navigationBar
	 */
	public void addNavigationBarToCache(String navigationBarID, INavigationBar navigationBar){
		
		if(!usecaseNavigationBarsCache.containsKey(navigationBar)){
			
			usecaseNavigationBarsCache.put(navigationBarID, navigationBar);
		}
	}

	/**
	 * @param usecaseNavigationBarsCache the usecaseNavigationBarsCache to set
	 */
	public void setUsecaseNavigationBarsCache(
			Map<String, INavigationBar> usecaseNavigationBarsCache) {
		this.usecaseNavigationBarsCache = usecaseNavigationBarsCache;
	}
	
	
}
