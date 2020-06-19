/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets;

import java.awt.Image;
import java.awt.Window;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionResponse;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.images.utils.ImageLoaderUtils;

import net.java.dev.designgridlayout.DesignGridLayout;
import nl.jj.swingx.gui.modal.JModalDialog;

/**
 * @author Anees
 *
 */
public class JExternalDialogWidget extends JModalDialog {
	
	private ActionResponse actionResponse;
	
	public JExternalDialogWidget(final ActionResponse actionResponse, final JModalDialog owner, String title){
		
		super(owner, title);
		
		this.actionResponse = actionResponse;
		
		setSize(owner.getWidth(), owner.getHeight());
		
		createDialogIcon();
		
		createDialog();
		
	}
	
	private void createDialogIcon(){
		
		if(ActionTypes.ERROR_ACTION.equals(actionResponse.getActionType())){
			
			String errorImage = ImageLoaderUtils.loadImage("d_error.png");
			
			Image img = new ImageIcon(errorImage).getImage();
			
			setIconImage(img);

		}
	}
	
	private void createDialog(){
		
		JPanel panel = new JPanel();
		
		DesignGridLayout layout = new DesignGridLayout(panel);
		
		Collection<String> errors = actionResponse.getErrors().values();
		
		for(String error : errors){
			
			layout.row().left().add(new JLabel(error));
		}
		
		add(panel);
	}

}
