/**
 * 
 */
package com.eagle.coders.swing.core.ui.cache.session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eagle.coders.swing.core.ui.cache.session.type.SessionType;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionResponse;
import com.eaglescoders.userprofile.ejb.domain.UserDomain;

/**
 * @author Anees
 *
 */
public class ApplicationSession {
	
	private static ApplicationSession session;
	
	private ActionResponse actionResponse;
	
	private Map<String, ActionResponse> actionResponseSession;
	
	private ApplicationSession(){
		
		actionResponseSession = new HashMap<String, ActionResponse>();
	}
	
	public static ApplicationSession getSession(){
		
		if(null == session){
		
			session = new ApplicationSession();
		}
		return session;
	}
	
	/**
	 * 
	 * @param actionResponse
	 */
	public void store(final ActionResponse actionResponse){
		
		this.actionResponse = actionResponse;
		
		actionResponseSession.put(SessionType.USER_SESSION_INFO.getValue(), actionResponse);
	}
	
	/**
	 * 
	 * @return
	 */
	public ActionResponse getStoredSession(String key){
		
		if(null == key)
			return actionResponseSession.get(SessionType.USER_SESSION_INFO.getValue());
		else
			return actionResponseSession.get(key);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getUserFromSession(){
		
		ActionResponse actionResponse = actionResponseSession.get(SessionType.USER_SESSION_INFO.getValue());
		
		Map<Class<? extends Object>, List<Map<String, Object>>> session = actionResponse.getDataToReturn();
		
		List<Map<String, Object>> mapList = session.get(UserDomain.class);
		
		return mapList;
	}

}
