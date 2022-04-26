import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BasicStroke;
import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.regex.Pattern;
import javax.swing.JTextArea;

public class SquareMenu extends JFrame implements ActionListener {

	// Var
	JTextField posinput1, posinput2;
	JButton calcbtnsqr, tfcalcbtn;
	SquareMenu sqrmenu;
	JPanel canvasmain, canvastransform, tfmenupanel;
	String getinput1, getinput2;
	String[] input1, input2;
	Integer x1 = 0, x2 = 0, y1 = 0, y2 = 0;
	Integer a, b, rotate = 0;
	Integer xi1 = 0, xi2 = 0, yi1 = 0, yi2 = 0;
	JLabel sssw, translasi_a_lbl, translasi_b_lbl, scalehelp, rotationhelp;
	JTextField translasi_a, translasi_b, scaleinput, rotationinput;
	JComboBox tfselect;
	MainPanel mainpanel;
	TransformPanel transformpanel;
	RotatePanel rotatepanel;
	JTextField textField;

	SquareMenu() {
		sqrmenu = this;
		this.setTitle("Shape Transformation : Square");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800, 600);
		this.setResizable(false);
		getContentPane().setLayout(null);

		JLabel sqrlbl = new JLabel("SQUARE");
		sqrlbl.setHorizontalAlignment(SwingConstants.CENTER);
		sqrlbl.setBounds(249, 21, 285, 82);
		getContentPane().add(sqrlbl);

		JLabel inputtop = new JLabel("Input Square Position");
		inputtop.setHorizontalAlignment(SwingConstants.CENTER);
		inputtop.setBounds(96, 92, 120, 14);
		getContentPane().add(inputtop);

		JLabel inputhelp1 = new JLabel("(x1,y1)");
		inputhelp1.setHorizontalAlignment(SwingConstants.CENTER);
		inputhelp1.setBounds(34, 117, 62, 20);
		getContentPane().add(inputhelp1);

		JLabel inputhelp2 = new JLabel("(x2,y2)");
		inputhelp2.setHorizontalAlignment(SwingConstants.CENTER);
		inputhelp2.setBounds(34, 150, 62, 20);
		getContentPane().add(inputhelp2);
		this.setVisible(true);

		// Input Field
		posinput1 = new JTextField("");
		posinput1.setHorizontalAlignment(SwingConstants.CENTER);
		posinput1.setForeground(Color.BLACK);
		posinput1.setToolTipText("Input x1 y1 (separate by space)");
		posinput1.setBounds(106, 117, 90, 20);
		getContentPane().add(posinput1);
		posinput1.setColumns(10);
		posinput1.addActionListener(this);

		posinput2 = new JTextField("");
		posinput2.setToolTipText("Input x2 y2 (separate by space)");
		posinput2.setHorizontalAlignment(SwingConstants.CENTER);
		posinput2.setForeground(Color.BLACK);
		posinput2.setColumns(10);
		posinput2.setBounds(106, 150, 90, 20);
		getContentPane().add(posinput2);
		posinput1.addActionListener(this);

		calcbtnsqr = new JButton("Calculate");
		calcbtnsqr.setBounds(96, 201, 120, 20);
		getContentPane().add(calcbtnsqr);
		calcbtnsqr.addActionListener(this);

		// Transformation Button
		String[] transformation = { "Select Transformation", "Translation", "Dilatation", "Reflection", "Rotation" };
		tfselect = new JComboBox(transformation);
		tfselect.addActionListener(new tfbtnlistener());

		tfselect.setBounds(544, 87, 150, 25);
		getContentPane().add(tfselect);

		// Translation

		translasi_a = new JTextField();
		translasi_a.setToolTipText("input x");
		translasi_a.setBounds(474, 139, 86, 20);

		translasi_b = new JTextField();
		translasi_b.setToolTipText("input y");
		translasi_b.setColumns(10);
		translasi_b.setBounds(664, 139, 86, 20);
		

		translasi_a_lbl = new JLabel("X");
		translasi_a_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		translasi_a_lbl.setBounds(520, 120, 90, 15);

		translasi_b_lbl = new JLabel("Y");
		translasi_b_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		translasi_b_lbl.setBounds(620, 120, 100, 15);

		// Dilatation
		scalehelp = new JLabel();
		scalehelp.setHorizontalAlignment(SwingConstants.CENTER);
		scalehelp.setText("Input Scale");
		scalehelp.setBounds(544, 128, 150, 20);

		scaleinput = new JTextField();
		scaleinput.setBounds(544, 148, 150, 25);
		scaleinput.setColumns(10);

		// Reflection

		// Rotation
		rotationinput = new JTextField();
		rotationinput.setHorizontalAlignment(SwingConstants.CENTER);
		rotationinput.setBounds(574, 150, 100, 20);
		
		rotationinput.setColumns(10);
		
		rotationhelp = new JLabel("Enter Rotational Degrees");
		rotationhelp.setHorizontalAlignment(SwingConstants.CENTER);
		rotationhelp.setBounds(554, 123, 136, 14);

		// Tranformation Menu Panel
		/*
		 * tfmenupanel = new JPanel(); tfmenupanel.setBounds(484, 110, 250, 80);
		 * tfmenupanel.setLayout(getLayout());
		 * 
		 * getContentPane().add(tfmenupanel); tfmenupanel.setLayout(null);
		 */


		tfcalcbtn = new JButton("Transform");
		tfcalcbtn.setEnabled(true);
		tfcalcbtn.setBounds(574, 201, 120, 20);
		getContentPane().add(tfcalcbtn);
		tfcalcbtn.addActionListener(new tfcalclistener());

		// Canvas
		mainpanel = new MainPanel();
		mainpanel.setBackground(Color.LIGHT_GRAY);
		mainpanel.setBounds(10, 11, 285, 285);

		transformpanel = new TransformPanel();
		transformpanel.setBackground(Color.LIGHT_GRAY);
		transformpanel.setBounds(10, 11, 285, 285);
		
		rotatepanel = new RotatePanel();
		rotatepanel.setBackground(Color.LIGHT_GRAY);
		rotatepanel.setBounds(10, 11, 285, 285);

		canvastransform = new JPanel();
		canvastransform.setBackground(Color.LIGHT_GRAY);
		canvastransform.setBounds(479, 246, 305, 305);
		canvastransform.setLayout(null);
		getContentPane().add(canvastransform);
		canvastransform.add(transformpanel);

		sssw = new JLabel("New label");

		sssw.setBounds(229, 139, 150, 20);
		getContentPane().add(sssw);

		canvasmain = new JPanel();
		canvasmain.setBackground(Color.LIGHT_GRAY);
		canvasmain.setOpaque(true);
		canvasmain.setBounds(28, 246, 305, 305);
		canvasmain.setLayout(null);
		getContentPane().add(canvasmain);
		canvasmain.add(mainpanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == calcbtnsqr) {
			getinput1 = posinput1.getText();
			input1 = getinput1.split(" ");
			getinput2 = posinput2.getText();
			input2 = getinput2.split(" ");
			x1 = Integer.parseInt(input1[0]);
			y1 = Integer.parseInt(input1[1]);
			x2 = Integer.parseInt(input2[0]);
			y2 = Integer.parseInt(input2[1]);

			canvasmain.remove(mainpanel);
			canvasmain.add(mainpanel);
			canvasmain.revalidate();
			canvasmain.repaint();
			sssw.setText(input1[0] + input1[1] + input2[0] + input2[1]);
		}

	}
	
	
	
	//THIS ENTIRE THING NEED REFACTORING, THIS LOOKS HORRENDOUS
	public class tfbtnlistener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tfselect) {
				
					tfcalcbtn.setEnabled(true);
				if (tfselect.getSelectedItem() == "Translation") {
					
					
					
					  sqrmenu.remove(scalehelp); sqrmenu.remove(scaleinput);
					  sqrmenu.remove(rotationinput);sqrmenu.remove(rotationhelp);
					  
					  sqrmenu.revalidate(); sqrmenu.repaint();
					  
					  sqrmenu.add(translasi_a_lbl); sqrmenu.add(translasi_b_lbl);
					  sqrmenu.add(translasi_a); sqrmenu.add(translasi_b);
					 
					 
					 

					sssw.setText("should be visible");
				}
				if (tfselect.getSelectedItem() == "Dilatation") {
					
					
					
					  sqrmenu.remove(translasi_a); sqrmenu.remove(translasi_b);
					  sqrmenu.remove(rotationinput);sqrmenu.remove(rotationhelp);
					  sqrmenu.revalidate(); sqrmenu.repaint();
					  
					  sqrmenu.add(scalehelp); sqrmenu.add(scaleinput);
					 
					 
					 
					}
				if (tfselect.getSelectedItem() == "Reflection") {

					}
				if (tfselect.getSelectedItem() == "Rotation") {
					
					
					  sqrmenu.remove(translasi_a); sqrmenu.remove(translasi_b);
					  sqrmenu.remove(scalehelp); sqrmenu.remove(scaleinput); sqrmenu.revalidate();
					  sqrmenu.repaint();
					  
					  sqrmenu.add(rotationinput); sqrmenu.add(rotationhelp);
					 
					} 
				else {
				}
				// sqrmenu.add(pane1);
			}
		}
	}

	public class tfcalclistener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tfcalcbtn) {
				if (tfselect.getSelectedItem() == "Translation") {
					a = Integer.parseInt(translasi_a.getText());
					b = Integer.parseInt(translasi_b.getText());
					xi1 = x1 + a;
					xi2 = x2 + a;
					yi1 = y1 + b;
					yi2 = y2 + b;
					sssw.setText("should transform");
				}
				if (tfselect.getSelectedItem() == "Dilatation") {
					a = Integer.parseInt(scaleinput.getText());
					xi1 = x1;
					xi2 = x2 * a;
					yi1 = y1;
					yi2 = y2 * a;
					x1 += 10;
					x2 += 10;
					y1 += 10;
					y2 += 10;

					if (xi2 > 250 || yi2 > 250) {
						x1 = x1 / 2;
						x2 = x2 / 2;
						y1 = y1 / 2;
						y2 = y2 / 2;
						xi1 = xi1 / 2;
						xi2 = xi2 / 2;
						yi1 = yi1 / 2;
						yi2 = yi2 / 2;
					}
				}
				if (tfselect.getSelectedItem() == "Reflection") {

				}
				if (tfselect.getSelectedItem() == "Rotation") {
					//
					a = Integer.parseInt(rotationinput.getText());
					xi1 = x1;
					xi2 = x2;
					yi1 = y1;
					yi2 = y2;
					
					
				}
				
				canvastransform.remove(transformpanel);
				//canvastransform.add(rotatepanel);
				if(tfselect.getSelectedItem() == "Rotation")
				{canvastransform.add(rotatepanel);}
				else {canvastransform.add(transformpanel);}
				canvastransform.revalidate();
				canvastransform.repaint();

				
			}
		}
	}

	public class MainPanel extends JPanel {

		MainPanel() {
		}

		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;

			g2d.setStroke(new BasicStroke(2));
			g2d.setColor(Color.BLUE);
			g2d.drawLine(x1, y1, x1, y2);
			g2d.drawLine(x1, y2, x2, y2);
			g2d.drawLine(x2, y2, x2, y1);
			g2d.drawLine(x2, y1, x1, y1);

		}

	}

	public class TransformPanel extends JPanel {

		TransformPanel() {
		}

		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			Graphics2D tfg2d = (Graphics2D) g;
			
			g2d.setStroke(new BasicStroke(2));
			g2d.setColor(Color.BLUE);
			g2d.drawLine(x1, y1, x1, y2);
			g2d.drawLine(x1, y2, x2, y2);
			g2d.drawLine(x2, y2, x2, y1);
			g2d.drawLine(x2, y1, x1, y1);

			tfg2d.setStroke(new BasicStroke(2));
			tfg2d.setColor(Color.RED);
			tfg2d.drawLine(xi1, yi1, xi1, yi2);
			tfg2d.drawLine(xi1, yi2, xi2, yi2);
			tfg2d.drawLine(xi2, yi2, xi2, yi1);
			tfg2d.drawLine(xi2, yi1, xi1, yi1);
			
		}

	}
	
	public class RotatePanel extends JPanel {

		RotatePanel() {
		}

		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			Graphics2D tfg2d = (Graphics2D) g;
			
			g2d.setStroke(new BasicStroke(2));
			g2d.setColor(Color.BLUE);
			g2d.drawLine(x1, y1, x1, y2);
			g2d.drawLine(x1, y2, x2, y2);
			g2d.drawLine(x2, y2, x2, y1);
			g2d.drawLine(x2, y1, x1, y1);

			
			
			tfg2d.setStroke(new BasicStroke(2));
			tfg2d.setColor(Color.RED);
			tfg2d.rotate(Math.toRadians(a), (xi2), (yi2));
			tfg2d.drawLine(xi1, yi1, xi1, yi2);
			tfg2d.drawLine(xi1, yi2, xi2, yi2);
			tfg2d.drawLine(xi2, yi2, xi2, yi1);
			tfg2d.drawLine(xi2, yi1, xi1, yi1);
			

		}
	}
}