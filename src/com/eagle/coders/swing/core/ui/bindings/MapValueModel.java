/**
 * 
 */
package com.eagle.coders.swing.core.ui.bindings;

import java.awt.EventQueue;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

import com.eagle.coders.swing.core.ui.annotations.type.StringInputCaseType;
import com.eagle.coders.swing.core.ui.validation.ComponentConstraintAssociator;
import com.eagle.coders.swing.core.ui.validation.PropertyConstraintsHolder;
import com.jgoodies.binding.value.AbstractValueModel;

/**
 * @author Anees
 *
 */
public class MapValueModel extends AbstractValueModel {

	private static final long serialVersionUID = 1L;
	
	private Boolean dirty = false;
	
	private Boolean queryAble = true;

	protected Map map;
	
	protected Object key;
	
	private String nValue;
	
	private Map<JComponent, PropertyConstraintsHolder> componentConstraintMap;

	/**
	*
	* @param map
	* @param key
	*/
	public MapValueModel(Map map, Object key){
		
		this.key = key;
		
		this.map = map;
		
	}

	/**
	*
	*/
	public MapValueModel(){}

	/**
	*
	* @return
	*/
	public Object getKey() {
		return key;
	}
	/**
	*
	* @param key
	*/
	public void setKey(Object key) {
		
		Object oldKey = this.key;

		this.key = key;
		
		firePropertyChange("key", oldKey, key);
	}

	/**
	* Retrieve the value.
	*
	* @return the value.
	*/
	public Object getValue(){
		
		return map.get(key);
	}

	/**
	* Set the value.
	*
	* @param newValue the new value.
	*/
	public void setValue(final Object newValue){
		
		Object oldValue = map.get(key);

		map.put(key, newValue);

//		System.out.println("[MapValueModel] :: key :: "+key+" value :: "+ map);
		
		if(null == newValue || newValue.equals(""))
			setDirty(false);
		else
			setDirty(true); 
		
		fireValueChange(oldValue, newValue);
	}

	/**
	*
	* @param map
	*/
	public void setMap(Map map){
		
		Map oldMap = this.map;
		
		Object oldValue = oldMap.get(key);
		
		this.map = map;
		
		firePropertyChange("map", oldMap, map);
		
		fireValueChange(oldValue, getValue());
	}

	/**
	 * @return the dirty
	 */
	public Boolean getDirty() {
		return dirty;
	}

	/**
	 * @param dirty the dirty to set
	 */
	public void setDirty(Boolean dirty) {
		this.dirty = dirty;
	}

	/**
	 * @return the queryAble
	 */
	public Boolean getQueryAble() {
		return queryAble;
	}

	/**
	 * @param queryAble the queryAble to set
	 */
	public void setQueryAble(Boolean queryAble) {
		this.queryAble = queryAble;
	}
	
}