package com.eagle.coders.swing.core.ui.decorator.widgets;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.CellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.dom4j.Element;

import net.java.dev.designgridlayout.DesignGridLayout;

import com.eagle.coders.swing.core.ui.annotations.type.UIComponentType;
import com.eagle.coders.swing.core.ui.bindings.MapTableAdapter;
import com.eagle.coders.swing.core.ui.cache.UIDomainPropertyHolder;
import com.jgoodies.binding.adapter.SingleListSelectionAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;

/**
 * 
 * @author Anees
 * 
 */
public class TableWidget extends JPanel {

	private JTable jTable;

	private JScrollPane jTableScrollPanel;

	private List<UIDomainPropertyHolder> uiDomainPropertyHolderList;

	private SortedMap<Integer, String> uiDomainMap;

	private Map<String, String> colNameTypeMap;

	private Map<Integer, String> colTypeMap;

	private Map<String, Object> rowDataMap;

	private List<Map<String, Object>> inCompingRowDataMap;

	private ArrayListModel<Map<String, Object>> mapValueList;

	private List<String> namesList;

	private JButton addRow, removeRow;

	private JPanel tableBtnPanel;

	private MapTableAdapter mapTableAdapter;
	
	private List<Map<String, Object>> childTableData;

	public TableWidget() {

	}

	/**
	 * 
	 * @param uiDomainPropertyHolderList
	 */
	public TableWidget(List<UIDomainPropertyHolder> uiDomainPropertyHolderList,
			List<Map<String, Object>> inCompingRowDataMap, ArrayListModel<Map<String, Object>> mapValueList, boolean isEditable) {

		super();

		this.uiDomainPropertyHolderList = uiDomainPropertyHolderList;

		uiDomainMap = new TreeMap<Integer, String>();

		colTypeMap = new HashMap<Integer, String>();

		colNameTypeMap = new HashMap<String, String>();

		if (null == inCompingRowDataMap)
			rowDataMap = new HashMap<String, Object>();
		else {

			this.inCompingRowDataMap = inCompingRowDataMap;
		}
		
		addRow = new JButton("Add");
		addRow.addActionListener(new AddRowAction());

		removeRow = new JButton("Remove");
		removeRow.addActionListener(new RemoveRowAction());

		removeRow.setEnabled(false);

		tableBtnPanel = new JPanel();

		DesignGridLayout layout = new DesignGridLayout(tableBtnPanel);

		layout.row().right().add(addRow, removeRow);

		init();

		namesList = createTableColumnList();
		
		if(null != mapValueList){
			this.mapValueList = mapValueList;
		}else
			mapValueList = new ArrayListModel<Map<String,Object>>();
		

		if (null != inCompingRowDataMap && this.inCompingRowDataMap.size() > 0) {

			for (Map<String, Object> mapValue : inCompingRowDataMap) {
				mapValueList.add(mapValue);
			}
		}

		SelectionInList selectionList = new SelectionInList(
				(ListModel) mapValueList);

		createJTable(namesList, selectionList, isEditable);
	}

	/**
	 * 
	 * @param uiDomainPropertyHolderList
	 * @param tableNode
	 */
	public void createTable(
			List<UIDomainPropertyHolder> uiDomainPropertyHolderList,
			Element tableNode) {

		this.uiDomainPropertyHolderList = uiDomainPropertyHolderList;

		uiDomainMap = new TreeMap<Integer, String>();

		colTypeMap = new HashMap<Integer, String>();

		init();

		createTableColumnNode(tableNode);
	}

	/**
	 * 
	 */
	private void init() {

		for (UIDomainPropertyHolder uiDomainHolder : uiDomainPropertyHolderList) {

			if (null != uiDomainHolder.getTableDisplayPosition()) {
				uiDomainMap.put(uiDomainHolder.getTableDisplayPosition(),
						uiDomainHolder.getUiPropertyLabel());

				colTypeMap.put(uiDomainHolder.getTableDisplayPosition(),
						uiDomainHolder.getUiPropertyType());
			}

		}
	}

	/**
	 * 
	 * @param tableNode
	 */
	private void createTableColumnNode(Element tableNode) {

		Set<Integer> keys = uiDomainMap.keySet();

		for (Integer key : keys) {

			Element tableColumn = tableNode.addElement("column");

			tableColumn.addAttribute("position", key.toString());

			tableColumn.addAttribute("label", uiDomainMap.get(key));

			tableColumn.addAttribute("colType", colTypeMap.get(key));

			// TODO: for data-type node i will do it latter

		}

	}

	/**
	 * 
	 * @return
	 */
	private List<String> createTableColumnList() {

		List<String> namesList = new ArrayList<String>();

		Set<Integer> keys = uiDomainMap.keySet();

		for (Integer key : keys) {

			namesList.add(uiDomainMap.get(key));

			String columnType = colTypeMap.get(key);

			colNameTypeMap.put(uiDomainMap.get(key), columnType);
		}

		return namesList;
	}

	/**
	 * 
	 * @param namesList
	 * @param selectionList
	 */
	public void createJTable(List<String> namesList,
			SelectionInList selectionList, boolean isEditable) {

		String namesArray[] = (String[]) namesList.toArray(new String[namesList
				.size()]);

		mapTableAdapter = new MapTableAdapter(selectionList, namesArray);

		mapTableAdapter.setEditable(isEditable);

		mapTableAdapter.setColNameTypeMap(colNameTypeMap);

		jTable = new JTable(mapTableAdapter);

		MultiRenderer multiRenderer = new MultiRenderer();

		multiRenderer.registerRenderer(Boolean.class, jTable
				.getDefaultRenderer(Boolean.class));
		
		multiRenderer.registerRenderer(Date.class, new DateRenderer());
		
		multiRenderer.registerRenderer(Number.class, jTable
				.getDefaultRenderer(Number.class));
		
		MultiEditor multiEditor = new MultiEditor();
		
		multiEditor.registerEditors(Boolean.class, new DefaultCellEditor(new JCheckBox()));
		
		multiEditor.registerEditors(Number.class, new DefaultCellEditor(new JFormattedTextField()));
		
		multiEditor.registerEditors(String.class, new DefaultCellEditor(new JTextField()));
		
		multiEditor.registerEditors(Date.class, new DateCellEditor());

		 TableColumnModel tcm = jTable.getColumnModel();
				
		 int columnCount = mapTableAdapter.getColumnCount();

		 for(int i =0; i < columnCount ; i++){
			 
			 TableColumn tableColumn = tcm.getColumn(i);
			 
			 tableColumn.setCellRenderer(multiRenderer);
			 
			 tableColumn.setCellEditor(multiEditor);
		 }
		// jTable.set

		jTable.setSelectionModel(new SingleListSelectionAdapter(selectionList
				.getSelectionIndexHolder()));

		jTableScrollPanel = new JScrollPane(jTable);

		// jTableScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// jTableScrollPanel.setVerticalScrollBarPolicy(jTableScrollPanel.VERTICAL_SCROLLBAR_ALWAYS);

		FormLayout formLayout = new FormLayout(
				new ColumnSpec[] { new ColumnSpec("300dlu:grow(1.0)") },
				new RowSpec[] { new RowSpec("70dlu"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC });

		setLayout(formLayout);

		add(jTableScrollPanel, new CellConstraints(1, 1));

		if (null == this.inCompingRowDataMap) // TODO: this is temporary .. have
			// to make some framework to
			// handle this effect
			add(tableBtnPanel, new CellConstraints(1, 3));

	}

	/**
	 * 
	 */
	private class AddRowAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			Map<String, Object> map = new HashMap<String, Object>();

			for (String name : namesList) {

				String type = colNameTypeMap.get(name);

				if (type.equals(UIComponentType.COMPNENT_TEXTFIELD.getValue())) {

					map.put(name, new String());

				} else if (type.equals(UIComponentType.COMPNENT_COMBOBOX
						.getValue())) {

					map.put(name, new Vector());

				} else if (type.equals(UIComponentType.COMPONENT_CHECKBOX
						.getValue())) {

					map.put(name, new Boolean(true));

				} else if (type.equals(UIComponentType.COMPONENT_DATE
						.getValue())) {

					map.put(name, new Date());
				}

				// map.put(name, null);
			}

			removeRow.setEnabled(true);

			mapValueList.add(map);
		}

	}
	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private class MultiEditor extends AbstractCellEditor implements TableCellEditor {

		private Map<Class, TableCellEditor> registeredEditors = new HashMap<Class, TableCellEditor>();

		TableCellEditor delegate = null;

		@Override
		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			
			
			if (value != null) {
				delegate = getDelegate(value.getClass());
			}

			return delegate.getTableCellEditorComponent(table, value, isSelected, row, column);
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			if (null != delegate)
				return delegate.getCellEditorValue(); //TODO:
			else 
				return new String();
		}
		
		/**
		 * 
		 * @param type
		 * @param renderer
		 */
		public void registerEditors(Class type, TableCellEditor renderer) {
			registeredEditors.put(type, renderer);
		}
		
		/**
		 * 
		 * @param type
		 * @return
		 */
		private TableCellEditor getDelegate(Class type) {
			TableCellEditor delegate = null;
			while (type != null && delegate == null) {
				delegate = registeredEditors.get(type);
				type = type.getSuperclass();
			}
			return delegate;
		}

	}
	
	private class DateCellEditor extends AbstractCellEditor implements TableCellEditor {

		private JDateChooser dateChooser ;
		
		public DateCellEditor(){
			
			dateChooser = new JDateChooser();
			
			dateChooser.setOpaque(false);
			
		}
		
		
		@Override
		public Object getCellEditorValue() {
			return dateChooser.getDate();
		}

		@Override
		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			// TODO Auto-generated method stub
			return dateChooser;
		}
		
	}

	/**
	 * 
	 * @author Anees
	 *
	 */
	private class MultiRenderer implements TableCellRenderer {

		private TableCellRenderer defaultRenderer = new DefaultTableCellRenderer();

		private Map<Class, TableCellRenderer> registeredRenderers = new HashMap<Class, TableCellRenderer>();

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			TableCellRenderer delegate = null;
			if (value != null) {
				delegate = getDelegate(value.getClass());
			}

			if (delegate == null) {
				delegate = defaultRenderer;
			}

			return delegate.getTableCellRendererComponent(table, value,
					isSelected, hasFocus, row, column);
		}

		/**
		 * 
		 * @param type
		 * @param renderer
		 */
		public void registerRenderer(Class type, TableCellRenderer renderer) {
			registeredRenderers.put(type, renderer);
		}

		/**
		 * 
		 * @param type
		 * @return
		 */
		private TableCellRenderer getDelegate(Class type) {
			TableCellRenderer delegate = null;
			while (type != null && delegate == null) {
				delegate = registeredRenderers.get(type);
				type = type.getSuperclass();
			}
			return delegate;
		}
	}
	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private class DateRenderer extends JDateChooser implements TableCellRenderer{

		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			// TODO Auto-generated method stub
			return new JDateChooser();
		}
		
		
	}

	/**
	 * 
	 * @author Anees
	 * 
	 */
	private class RemoveRowAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int size = mapValueList.getSize();

			if (size == 1)
				removeRow.setEnabled(false);

			// if(size > 1)
			mapValueList.remove(size - 1);
			// else
		}

	}

	/**
	 * 
	 * @return
	 */
	public JTable getTable() {

		return jTable;
	}

	/**
	 * 
	 * @return
	 */
	public MapTableAdapter getMapTableAdapter() {

		return mapTableAdapter;
	}
}