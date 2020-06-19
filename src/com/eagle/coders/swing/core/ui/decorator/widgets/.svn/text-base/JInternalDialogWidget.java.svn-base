/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import net.java.dev.designgridlayout.DesignGridLayout;
import nl.jj.swingx.gui.modal.JModalInternalFrame;

import com.eagle.coders.swing.core.ui.bindings.MapTableAdapter;
import com.eagle.coders.swing.core.ui.cache.UIDomainPropertyHolder;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionResponse;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.images.utils.ImageLoaderUtils;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;

/**
 * @author Anees
 *
 */
public class JInternalDialogWidget extends JModalInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ActionResponse actionResponse;
	
	private String componentID;
	
	private JComponent component;
	
	private JButton okButton, closeButton;
	
	public JInternalDialogWidget(final ActionResponse actionResponse, JModalInternalFrame frame, JComponent focusComponent, String title,
			IComponent component){
		
		super(frame, focusComponent, actionResponse.getActionType()+" : "+title, true, true,true,true);
		
		this.actionResponse = actionResponse;
		
		this.componentID = component.getComponentIdentity();
		
		setFrameIcon();
		
		setLayout(new BorderLayout());

		if(ActionTypes.ERROR_ACTION.equals(actionResponse.getActionType())){
			
			initError();
			
		}else{
			
			JComponent comp = init();
		}
		
		buildButtons();

		pack();
		
		setMinSize(300, 200);
		
	}
	
	public void setFrameIcon(){

		if(ActionTypes.SEARCH_ACTION.equals(actionResponse.getActionType())){
			
			Icon img = new ImageIcon(ImageLoaderUtils.loadImage("resarch_rslt.png"));
			
			super.setFrameIcon(img);
			
		}
//		TODO: I have to do for other actionTypes Images .. i will do it latter

	}
	
	/**
	 * 
	 */
	private void initError(){
		
		JPanel panel = new JPanel();
		
		DesignGridLayout layout = new DesignGridLayout(panel);
		
		Collection<String> errors = actionResponse.getErrors().values();
		
		for(String error : errors){
			
			layout.row().left().add(new JLabel(error));
		}
		
		add(panel);

	}
	
	/**
	 * 
	 * @return
	 */
	private JComponent init(){
		
		JPanel panel = new JPanel();
		
		DesignGridLayout layout = new DesignGridLayout(panel);

		List<UIDomainPropertyHolder> propertiesHolderList = new ArrayList<UIDomainPropertyHolder>();
		
		Map<Class<? extends Object>, List<Map<String, Object>>> result = actionResponse.getDataToReturn();

		Set<Class<? extends Object>> clzSet = result.keySet();
		
		String className = clzSet.iterator().next().getName();
		
		Class<? extends Object> objectClz = result.keySet().iterator().next();
		
		List<Map<String, Object>> mapResult = result.get(objectClz);
		
		component = UiWidgets.createJTable(objectClz, mapResult, null, false);
		
		TableWidget tableWidget =(TableWidget) component;
		
		JTable table = tableWidget.getTable();
		
		table.addMouseListener(new ClickActionAdapter(table, tableWidget, className));
		
		layout.row().center().add(component);
		
		add(panel, BorderLayout.CENTER);

		return component;
	}
	
//	TODO: temporary purpose
	private void buildButtons(){
		
		JPanel panel = new JPanel();
		
		DesignGridLayout layout = new DesignGridLayout(panel);
		
		okButton = new JButton("OK");
		
		okButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
		
				if(component instanceof TableWidget){
					
					TableWidget tableWidget =(TableWidget) component;
					
					JTable table = tableWidget.getTable();
					
					int row = table.getSelectedRow();

					MapTableAdapter mapTableAdapter = tableWidget.getMapTableAdapter();
					
					mapTableAdapter.getRow(row);
				}
				dispose();
			}
			
		});
		closeButton = new JButton("Close");
		
		layout.row().right().add(okButton, closeButton);
		
		add(panel, BorderLayout.SOUTH);
	}

	/**
	 * 
	 * @author Anees
	 *
	 */
	@SuppressWarnings("unused")
	private class ClickActionAdapter extends MouseAdapter{
		
		private JTable table;
		
		private TableWidget tableWidet;
		
		private String clazzName;
		
		public ClickActionAdapter(final JTable table, final TableWidget tableWidget, String objectName){
		
			this.table = table;
			
			this.tableWidet = tableWidget;
			
			this.clazzName = objectName;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {

			if(SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2){
				
				int row = table.getSelectedRow();
				
				Map object =(Map)tableWidet.getMapTableAdapter().getRow(row);
				
				IDialogToFormAdapter idialogToFormAdapter =
					new IDialogToFormAdapter(JInternalDialogWidget.this, JInternalDialogWidget.this.componentID, clazzName);
				
				idialogToFormAdapter.injectDataIntoForm(object);
				
				dispose();
				
			}else if(SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1){
			
//				TODO: adding to the list based on Rules
			}
		}
	}
}
