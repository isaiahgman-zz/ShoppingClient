import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Todo extends JPanel{
	
	//Just a needed addition
	private static final long serialVersionUID = 1L;
	int count = 0;
	
	public Todo() {
		setLayout(new BorderLayout());
		ArrayList<TechItem> techList = new ArrayList<TechItem>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list = new JList<String>(model);
		list.setFont(new Font("Arial",Font.BOLD,24));
		
		TechItem iPhone = new TechItem("iPhone", 999, 90, "The iPhone is a smartphone made by Apple that combines a computer, iPod, digital camera and cellular phone into one device with a touchscreen interface. The iPhone runs the iOS operating system (OS), and as of 2017, there were 2.2 million apps available for it through the Apple App Store, according to Statista.");
		TechItem iPad = new TechItem("iPad", 329, 80, "The iPad is a tablet computer developed by Apple. It is smaller than a typical laptop, but significantly larger than the average smartphone. The iPad does not include a keyboard or a trackpad, but instead has a touchscreen interface, which is used to control the device.");
		TechItem macbook = new TechItem("Macbook Air", 999, 75, "The incredibly thin and light MacBook Air is now more powerful than ever. It features a brilliant Retina display, new Magic Keyboard, Touch ID, processors with up to twice the performance,1 faster graphics, and double the storage capacity. The sleek wedge-shaped design is created from 100 percent recycled aluminum, making it the greenest Mac ever.2 And with all-day battery life, our most popular Mac is your perfectly portable, do-it-all notebook.");
		TechItem macPro = new TechItem("Mac Pro", 5999, 95, "The Mac Pro is a series of workstations and servers for professionals designed, manufactured, and sold by Apple Inc. since 2006. The Mac Pro, in most configurations and in terms of speed and performance, is the most powerful computer that Apple offers. It is one of four desktop computers in the current Macintosh lineup, sitting above the consumer Mac Mini and iMac, and alongside the all-in-one iMac Pro.");
		TechItem lenovoX280 = new TechItem("Lenovo X280", 799, 80, "Lenovo's ThinkPad X280 squeezes a gorgeous display and good keyboard into a compact package, but its battery life could be better.");
		
		techList.add(iPhone);
		techList.add(iPad);
		techList.add(macbook);
		techList.add(macPro);
		techList.add(lenovoX280);
		
		model.addElement(iPhone.getName());
		model.addElement(iPad.getName());
		model.addElement(macbook.getName());
		model.addElement(macPro.getName());
		model.addElement(lenovoX280.getName());
		
	    JScrollPane pane = new JScrollPane(list);
	    JPanel titlePanel = new JPanel();
	    JLabel title = new JLabel("Technology Catalog");
	    title.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
	    titlePanel.setBackground(Color.BLACK);
	    title.setForeground(Color.WHITE);
	    
	    titlePanel.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	titlePanel.setBackground(Color.WHITE);
	        	title.setForeground(Color.BLACK);
	        }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	titlePanel.setBackground(Color.BLACK);
	        	title.setForeground(Color.WHITE);
	        }
	    });
	    
	    JButton selectButton = new JButton("Select");
	    selectButton.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
	    selectButton.setBackground(Color.BLACK);
	    selectButton.setForeground(Color.WHITE);
	    
	    selectButton.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	selectButton.setBackground(Color.WHITE);
	        	selectButton.setForeground(Color.BLACK);
	        }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	selectButton.setBackground(Color.BLACK);
	        	selectButton.setForeground(Color.WHITE);
	        }
	    });
	    
	    selectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex() < 0 || list.getSelectedIndex() > model.getSize()){
					return;
				}
				String target = model.getElementAt(list.getSelectedIndex());
				
				for(TechItem i : techList) {
					if(target.equals(i.getName())) {
						printItemPage(i, pane, titlePanel, selectButton);
						break;
					}
				}
			}
	    });	  
	    
	    add(titlePanel, BorderLayout.PAGE_START);
	    titlePanel.add(title);
	    add(pane);
	    add(selectButton, BorderLayout.PAGE_END);
	}
	
	public void printItemPage(TechItem item, JScrollPane pane, JPanel titlePanel, JButton selectButton) {
		pane.setVisible(false);
		selectButton.setVisible(false);
		remove(pane);
		remove(selectButton);
		
		JPanel productPage = new JPanel();
		productPage.setLayout(new FlowLayout());
		JLabel productPageHeading = new JLabel(item.getName());
		productPageHeading.setFont(new java.awt.Font("Arial", Font.BOLD, 30));
		JTextArea productPageDescription = new JTextArea(item.getDescription());
		productPageDescription.setFont(new java.awt.Font("Arial", Font.ITALIC, 15));
		productPageDescription.setLineWrap(true);
		productPageDescription.setEditable(false);
		
		JLabel productPagePrice = new JLabel("$" + Integer.toString(item.getPrice()));
		productPagePrice.setFont(new java.awt.Font("Arial", Font.PLAIN,20));
		
		JButton doneButton = new JButton("Done");
		add(doneButton, BorderLayout.PAGE_END);
		
		doneButton.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
		doneButton.setBackground(Color.BLACK);
		doneButton.setForeground(Color.WHITE);
		
		productPage.add(productPageHeading);
		productPage.add(productPagePrice);
		productPage.add(productPageDescription);
		add(productPage);
	    
		doneButton.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	doneButton.setBackground(Color.WHITE);
	        	doneButton.setForeground(Color.BLACK);
	        }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	doneButton.setBackground(Color.BLACK);
	        	doneButton.setForeground(Color.WHITE);
	        }
	    });
		
		doneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doneButton.setVisible(false);
				productPageHeading.setVisible(false);
				productPageDescription.setVisible(false);
				productPagePrice.setVisible(false);
				productPage.setVisible(false);
				remove(doneButton);
				remove(productPageHeading);
				remove(productPageDescription);
				remove(productPagePrice);
				remove(productPage);
				
				add(pane);
				add(selectButton, BorderLayout.PAGE_END);
				pane.setVisible(true);
				selectButton.setVisible(true);
			}
		});
	}
	
	public static void main(String[] args) {
		//Creating the JFrame window
		JFrame frame = new JFrame("Tech Shopping Site");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Todo());
		frame.setResizable(false);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
