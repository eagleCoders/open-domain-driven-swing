/**
 * 
 */
package com.eagle.coders.swing.core.ui.frame;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;

import net.java.dev.designgridlayout.DesignGridLayout;
import net.java.dev.designgridlayout.IRowCreator;
import nl.jj.swingx.gui.modal.JModalInternalDialog;
import nl.jj.swingx.gui.modal.JModalInternalFrame;

import com.eagle.coders.swing.core.ui.decorator.conatiners.EaglePopupFactory;
import com.eagle.coders.swing.core.ui.decorator.widgets.CancelButtonWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.DeleteButtonWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.JInternalDialogWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.SearchButtonWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.SubmitButtonWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionResponse;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.decorator.widgets.listener.ActionListenerAssociator;
import com.eagle.coders.swing.core.ui.frame.component.popup.DataResultForm;
import com.eagle.coders.swing.core.ui.images.utils.ImageLoaderUtils;
import com.eagle.coders.swing.core.ui.interfaces.IButton;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;
import com.eagle.coders.swing.core.ui.interfaces.IDataResultForm;

/**
 * @author Anees
 *
 */
public class FormContainer<T extends IComponent> extends JPanel implements IFormContainer {
	
	private static final long serialVersionUID = 1L;

	private T component;
	
	private SearchButtonWidget<IComponent> searchButton;
	
	private SubmitButtonWidget<IComponent> createButton;
	
	private CancelButtonWidget<IComponent> cancelButton;
	
	private DeleteButtonWidget<IComponent> deleteButton;
	
	private IButton searchIButton, createIButton, cancelIButton, deleteIButton;
	
	private ActionListenerAssociator actionListenerAssociator;
	
	private PopupFactory popupFactory;
	
	private Popup popup;
	
	
	public FormContainer(T component){
		
		this.component = component;

		this.setLayout(new BorderLayout());
		
		this.setOpaque(false);
		
		popupFactory = PopupFactory.getSharedInstance();
		
		init();
	}
	
	private void init(){
	
		initButtons();
		
		createSearchPanel();

		createComponentPanel();

		createButtonPanel();
	}
	
	/**
	 * 
	 */
	private void initButtons(){
		
		searchButton = new SearchButtonWidget<IComponent>(component);

		createButton = new SubmitButtonWidget<IComponent>(component);

		cancelButton = new CancelButtonWidget<IComponent>(component);
		
		deleteButton = new DeleteButtonWidget<IComponent>(component);
		
		actionListenerAssociator = new ActionListenerAssociator(this, null, null ,searchButton, createButton,
				cancelButton, deleteButton);

	}
	
	/**
	 * 
	 */
	private void createSearchPanel(){
	
		JPanel searchPanel = new JPanel(new BorderLayout());
		
		JPanel panel = new JPanel();
		
		JPanel labelPanel = new JPanel();
		
		JLabel label = new JLabel(component.getFormTitle());
		
		
//		try{
//
//			String fileName = this.getClass().getClassLoader().getResource("com/eagle/coders/swing/core/ui/frame/AdineKirnberg-Script.ttf").getFile();
//			
//			File file = new File(fileName);
//			
//			FileInputStream in = new FileInputStream(file);
//			
//			Font font = Font.createFont(Font.TRUETYPE_FONT, in);
//			
//			font.deriveFont(32f);
//			
//			label.setFont(font);
//			
//		}catch(Exception e){
//			e.printStackTrace();
			label.setFont(label.getFont().deriveFont(20f));
//		}
		
		labelPanel.add(label);
		
		DesignGridLayout layout = new DesignGridLayout(panel);
		
		IRowCreator rowCreator = layout.row();
		
		searchPanel.add(searchButton, BorderLayout.EAST);
		
		rowCreator.grid().grid().add(labelPanel).grid().add(searchPanel);
		
		this.add(panel, BorderLayout.NORTH);
		
	}
	
	/**
	 * 
	 */
	private void createComponentPanel(){
		
		JPanel panel = new JPanel();
		
		DesignGridLayout layout = new DesignGridLayout(panel);

		layout.row().left().add(component.getPanel());

		JScrollPane scrollPane = new JScrollPane(panel);
		
//		this.add(panel, BorderLayout.CENTER);
		this.add(scrollPane, BorderLayout.CENTER);//TODO:
	}

	/**
	 * 
	 */
	private void createButtonPanel(){
		
		JPanel panel = new JPanel();
		
		DesignGridLayout layout = new DesignGridLayout(panel);
		
		layout.row().right().add(createButton, cancelButton,deleteButton);

		this.add(panel, BorderLayout.SOUTH);
	}
	
	/**
	 * 
	 */
	public String getComponentID(){
		
		return component.getComponentIdentity();
	}

	/**
	 * 
	 */
	@Override
	public void onFailure(JModalInternalFrame iFrame,ActionResponse actionResponse) {
		
		actionResponse.setActionType(ActionTypes.ERROR_ACTION);
		
		IDataResultForm resultForm = new DataResultForm<IComponent>(component, iFrame, actionResponse);
		
//		TODO: have to put into the cache | or other process still not configured
	}

	/**
	 * 
	 */
	@Override
	public void onSuccess(ActionResponse actionResponse) {
	}

	/**
	 * 
	 */
	@Override
	public void onAction4Popup(final JModalInternalFrame frame, ActionResponse actionResponse,
			ActionTypes actionType) {
		
		IDataResultForm resultForm = new DataResultForm<IComponent>(component, frame, actionResponse);
	
//		TODO: have to put into the cache | or other process still not configured
	}
	
	public T getComponent(){
		
		return component;
	}	
}