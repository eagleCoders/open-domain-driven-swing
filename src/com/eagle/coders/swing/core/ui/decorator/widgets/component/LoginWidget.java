/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.component;

import javax.swing.JPanel;

import com.eagle.coders.swing.core.ui.annotations.DomainObject;
import com.eagle.coders.swing.core.ui.annotations.DomainObjects;
import com.eagle.coders.swing.core.ui.annotations.DomainProperties;
import com.eagle.coders.swing.core.ui.annotations.ExceptDomainObjectPropertyPolicy;
import com.eagle.coders.swing.core.ui.annotations.type.DomainPerpertiesAllowType;
import com.eagle.coders.swing.core.ui.frame.component.builder.BaseComponentBuilder;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;
import com.eaglescoders.userprofile.ejb.domain.UserDomain;

/**
 * @author Anees
 *
 */
@DomainObjects(values = { @DomainObject(domainObject=UserDomain.class, position="1") })
@ExceptDomainObjectPropertyPolicy(domainObject=UserDomain.class, genralPolicy =DomainPerpertiesAllowType.DENY_ALL 
		,properties={@DomainProperties(property="username"), @DomainProperties(property = "password")})
public class LoginWidget extends BaseComponentBuilder {
	
	public static final String COMPONENT_ID = LoginWidget.class.getName();

//	private JPanel panel;
	
	@Override
	public String getComponentIdentity() {
		
		return COMPONENT_ID;
	}

	@Override
	public String getFormTitle() {
		// TODO Auto-generated method stub
		return "Login";
	}

//	@Override
//	public JPanel getPanel() {
//		// TODO Auto-generated method stub
//		return panel;
//	}
//
//	@Override
//	public void setPanel(JPanel panel) {
//		this.panel = panel;
//		
//	}

}
