import java.util.Collection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.openide.util.Lookup;
import org.openide.util.Lookup.Result;
import org.openide.util.Lookup.Template;

//import com.birosoft.liquid.LiquidLookAndFeel;
import com.eagle.coders.swing.core.ui.bindings.UIDomainBinderInterfaceController;
import com.eagle.coders.swing.core.ui.controller.utils.FrameworkComponentLookupService;
import com.eagle.coders.swing.core.ui.frame.FormContainer;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;

/**
 * 
 */

/**
 * @author Anees
 *
 */
public class TestingFormGeneration {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
//		UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		
//		LiquidLookAndFeel.setLiquidDecorations(true, "mac");

		UIManager.setLookAndFeel(
		"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		
		JFrame frame = new JFrame("Testing UI System....");
		
		List<IComponent> coll =(List) FrameworkComponentLookupService.lookup(IComponent.class);
		
		System.out.println(" coll :: is : "+ coll);
		IComponent comp = coll.get(0);
		
		UIDomainBinderInterfaceController<IComponent> binding = new UIDomainBinderInterfaceController<IComponent>(comp);
		
//		JPanel panel = comp.getPanel();
		
		FormContainer<IComponent> container = new FormContainer<IComponent>(comp);
		
		frame.getContentPane().add(container);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.setSize(800,800);
	}
		
}
