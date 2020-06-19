/**
 * 
 */
package com.eagle.coders.swing.core.ui.bindings;

import java.awt.event.MouseListener;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.ListModel;
import javax.swing.table.TableColumn;

import com.eagle.coders.swing.core.ui.annotations.type.UIComponentType;
import com.jgoodies.binding.adapter.AbstractTableAdapter;

/**
 * @author Anees
 *
 */
public class MapTableAdapter extends AbstractTableAdapter {

	private static final long serialVersionUID = 1L;
	
	private boolean isEditable = true;
	
	private Map<String, String> columnNameTypeMap;

	private String[] columnNames;

	public MapTableAdapter (ListModel listModel, String[] columnNames) {
		
		super(listModel, columnNames);
		
		this.columnNames = columnNames;
		
		columnNameTypeMap = new HashMap<String, String>();
	}

	
	/**
	 * 
	 * @param columnNameTypeMap
	 */
	public void setColNameTypeMap(final Map<String, String> columnNameTypeMap ){
		
		this.columnNameTypeMap = columnNameTypeMap;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		Map dataMap = (Map) getRow(rowIndex);
		
		String name = columnNames[columnIndex];
		
		Object value = null;
		
		if(dataMap.containsKey(name)){
			
			value = dataMap.get(name);
		}

		if(isEditable){
			
			if(value instanceof List<?>){
				
				JComboBox combobox = new JComboBox();
				
			}
			return true;
			
		}else
			return false;
	}

	/**
	 * 
	 */
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		Map dataMap = (Map) getRow(rowIndex);
		
		String name = columnNames[columnIndex];
		
		dataMap.put(name, aValue);
	}
	/**
	 * 
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Map dataMap = (Map) getRow(rowIndex);
		
		String name = columnNames[columnIndex];
		
		Object value = null;
		
		if(dataMap.containsKey(name)){
		
			value = dataMap.get(name);
		}
		
		return value;
	}
	
	/**
	 * 
	 * @param isEditable
	 */
	public void setEditable(boolean isEditable){
		
		this.isEditable = isEditable;
	}
	
}
