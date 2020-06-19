/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

import net.java.dev.designgridlayout.DesignGridLayout;
import nl.jj.swingx.gui.modal.JModalFrame;

import com.eagle.coders.swing.core.ui.controller.UIFrameworkAdvisor;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.decorator.widgets.dashboard.DashBoardContainer;
import com.eagle.coders.swing.core.ui.decorator.widgets.listener.ActionListenerAssociator;
import com.eagle.coders.swing.core.ui.generator.FrameworkGeneratorAdaptor;
import com.eagle.coders.swing.core.ui.images.utils.ImageLoaderUtils;
import com.eagle.coders.swing.core.ui.main.MainApp;
import com.eagle.coders.swing.core.ui.usecase.container.FrameUsecaseContainersAdvisor;
import com.eaglecoder.cbs.ui.clock.AnalogClock;

/**
 * @author Anees
 * 
 */
public class UIMainDecorator {

	private static UIMainDecorator instance;

	private DigitalClock clock;
	
	private JModalFrame frame;
	
	private JSplitPane mainContainer;

	private UIMainDecorator() {}

	/**
	 * 
	 * @return
	 */
	public static UIMainDecorator getInstance() {

		if (null == instance)
			instance = new UIMainDecorator();

		return instance;
	}

	/**
	 * 
	 */
	public void decorate(final JModalFrame frame) throws Exception {
		
		this.frame = frame;

		final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

		final UIFrameworkAdvisor advisor = UIFrameworkAdvisor.getInstance();

		final FrameworkGeneratorAdaptor<UIFrameworkAdvisor, UIMainDecorator> frameworkGenerator = new FrameworkGeneratorAdaptor<UIFrameworkAdvisor, UIMainDecorator>(
				advisor, this);

		final FrameworkGeneratorAdaptor<UIFrameworkAdvisor, UIMainDecorator> framework = frameworkGenerator
				.generate();

		mainContainer = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		int i = (int) dimension.getHeight();
		int j = (int) dimension.getWidth();

		int topHeight = i - 60;
		int topWidth = j-200;

		JPanel topPanel = new JPanel(new BorderLayout());

		clock = new DigitalClock();

		clock.start();

		JDesktopPane desktop = new JDesktopPane();

		topPanel.add(clock.getClock(), BorderLayout.CENTER);

		mainContainer.setDividerLocation(topHeight);

		mainContainer.setDividerSize(0);

		loadDashBoardContainer(desktop, topWidth, topHeight-1);
		
		FrameUsecaseContainersAdvisor.getInstance().loadDesktop(desktop);

		mainContainer.setTopComponent(desktop);

		JPanel taskBarContainerPane = createBottomTaskBar(framework);

		mainContainer.setBottomComponent(taskBarContainerPane);
		
		ActionListenerAssociator associator = new ActionListenerAssociator(frame, mainContainer);
		
		associator.associateGlobalActions(ActionTypes.LOCK_ACTION);
		
		frame.getContentPane().add(mainContainer);

	}
	
	/**
	 * 
	 * @param desktopPane
	 */
	private void loadDashBoardContainer(final JDesktopPane desktop, int width, int height) 
	throws Exception{

		ImageIcon dashboardIcon = new ImageIcon(ImageLoaderUtils
				.loadImage("Dashboard-iFrmae.png"));

		JInternalFrame iMFrame = new JInternalFrame("DashBoard");
		iMFrame.setFrameIcon(dashboardIcon);
		iMFrame.setMaximizable(false);
		iMFrame.setIconifiable(false);
		iMFrame.setIcon(false);
		iMFrame.setClosable(false);
		iMFrame.setResizable(false);
		iMFrame.setAutoscrolls(false);
		iMFrame.setVisible(true);
		
		iMFrame.setBounds(width, 0, 200, height-1);
		
		DashBoardContainer.getInstance().loadDashBoardContainer(iMFrame);
		
		AnalogClock clock = new AnalogClock();
		
//		DashBoardContainer.getInstance().loadGadgetsForDashBoard(clock);
	
		desktop.add(iMFrame);

	}

	/**
	 * 
	 * @param framework
	 * @return
	 */
	private JPanel createBottomTaskBar(
			final FrameworkGeneratorAdaptor<UIFrameworkAdvisor, UIMainDecorator> framework) {

		ImageIcon logoutIcon = new ImageIcon(ImageLoaderUtils
				.loadImage("logout.png"));
		
		ImageIcon favIcon = new ImageIcon(ImageLoaderUtils.loadImage("efavorites.png"));

		JPanel bottomPanel = new JPanel(new BorderLayout());
		JButton logoutBtn = new JButton(logoutIcon);
		logoutBtn.addActionListener(new LogoutAction());
		
		JButton favButton = new JButton(favIcon);
		
		favButton.addActionListener(new FavMenuAction()); //TODO: temporary
		
		JPanel taskLeftPanel = new JPanel();
		DesignGridLayout leftLayout = new DesignGridLayout(taskLeftPanel);
		leftLayout.row().left().add(favButton);
		
		JPanel taskRightPanel = new JPanel();
		DesignGridLayout rightLayout = new DesignGridLayout(taskRightPanel);
//		rightLayout.row().grid().add(clock.getClock()).add( logoutBtn);
		rightLayout.row().grid().add( logoutBtn);

		bottomPanel.add(taskRightPanel, BorderLayout.EAST);
		
		bottomPanel.add(taskLeftPanel, BorderLayout.WEST);

		JPanel taskBarPanel = new JPanel();
		bottomPanel.add(taskBarPanel, BorderLayout.CENTER);

		taskBarPanel.add(framework.getTaksBarPanel4Display());

		return bottomPanel;

	}
	
	/**
	 * 
	 * @return
	 */
	public JComponent getMainContainer(){
		
		return mainContainer;
	}
	
	/**
	 * 
	 */
	public void removeMainContainer(){
		
		mainContainer.setVisible(false);
		
		frame.getContentPane().remove(mainContainer);
	}
	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private class LogoutAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			frame.setVisible(false);
			
			MainApp.logoff();
		}
	}
	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private class FavMenuAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			FrameUsecaseContainersAdvisor.getInstance().loadFavouriteMenu();
		}
		
		
	}
}


/**
 * 
 * @author Anees
 * 
 */
class DigitalClock implements Runnable {

	static Thread fThread = null;

	static DateFormatPanel fClockPanel = null;

	public DigitalClock() {

		init();

	}

	public static void init() {

		fClockPanel = new DateFormatPanel();
	}

	/**
	 * 
	 */
	public void start() {

		if (fThread == null) {

			fThread = new Thread(this);

			fThread.start();
		}
	}

	/**
	 * 
	 */
	public void stop() {

		fThread = null;
	}

	/**
	 * 
	 */
	public void run() {

		while (fThread != null) {
			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
			}

			fClockPanel.repaint();
		}
	}

	public JPanel getClock() {
		return fClockPanel;
	}
}

/**
 * 
 * @author Anees
 * 
 */
class DateFormatPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel label;

	DateFormat fDateFormat = null;

	boolean fFirstPass = true;

	int fMsgX = 0, fMsgY = 0;

	Font fFont = new Font("Serif", Font.BOLD, 24);

	DateFormatPanel() {
		fDateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT);
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Date now = new Date();

		String date_out = fDateFormat.format(now);

		g.setFont(fFont);

		if (fFirstPass) {

			FontMetrics fm = g.getFontMetrics();

			int msg_width = fm.stringWidth(date_out);

			fMsgX = getSize().width / 2 - msg_width / 2;

			int ascent = fm.getMaxAscent();

			int descent = fm.getMaxDescent();

			fMsgY = getSize().height / 2 - descent / 2 + ascent / 2;
		}
		g.drawString(date_out, fMsgX, fMsgY);

		fFirstPass = false;

	}
}
