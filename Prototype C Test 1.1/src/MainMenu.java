import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.JButton;


public class MainMenu extends JFrame implements ActionListener
{

	//Public Declaration
	JRadioButton squarebtn, trianglebtn, rectanglebtn;
	ImageIcon panelshape;
	JPanel shapepanelx;
	JLabel panelpic;
	JFrame mainmenu;
	JButton calcbutton;
	int shapeno;
	
	
	
	
	MainMenu()
	{
		
		//Main Menu
		mainmenu = this;
		this.setTitle("Shape Transformation");
		
		this.setSize(800,600);
		this.setResizable(false);
		
		ImageIcon icon = new ImageIcon("sticon.png");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(new Color(0xA7AFB2));
		
		getContentPane().setLayout(null);
			
		JLabel topwc = new JLabel();
		topwc.setBackground(Color.WHITE);
		topwc.setBounds(213, 28, 358, 32);
		topwc.setText("Shape Transformation 1.0");
		topwc.setFont(new Font("Javanese Text", Font.BOLD, 24));
		topwc.setForeground(Color.RED);
		topwc.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(topwc);
		
		
		//Shape Selection
		JLabel selectshape = new JLabel();
		selectshape.setBackground(new Color(240, 240, 240));
		selectshape.setForeground(new Color(255, 0, 0));
		selectshape.setFont(new Font("Javanese Text", Font.PLAIN, 16));
		selectshape.setHorizontalAlignment(SwingConstants.CENTER);
		selectshape.setBounds(23, 118, 142, 39);
		selectshape.setText("Select Shapes :");
		getContentPane().add(selectshape);
		
		squarebtn = new JRadioButton("Square");
		squarebtn.setForeground(Color.CYAN);
		squarebtn.setBackground(UIManager.getColor("Button.darkShadow"));
		squarebtn.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		squarebtn.setBounds(33, 164, 132, 39);
		getContentPane().add(squarebtn);
		squarebtn.addActionListener(this);
		
		trianglebtn = new JRadioButton("Triangle");
		trianglebtn.setForeground(Color.CYAN);
		trianglebtn.setBackground(UIManager.getColor("Button.darkShadow"));
		trianglebtn.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		trianglebtn.setBounds(33, 206, 132, 39);
		getContentPane().add(trianglebtn);
		trianglebtn.addActionListener(this);
		
		rectanglebtn = new JRadioButton("Rectangle");
		rectanglebtn.setForeground(Color.CYAN);
		rectanglebtn.setBackground(UIManager.getColor("Button.darkShadow"));
		rectanglebtn.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		rectanglebtn.setBounds(33, 247, 132, 39);
		getContentPane().add(rectanglebtn);
		rectanglebtn.addActionListener(this);
		
		ButtonGroup shapebtn = new ButtonGroup();
	      shapebtn.add(squarebtn);
	      shapebtn.add(trianglebtn);
	      shapebtn.add(rectanglebtn);
	     
		
		calcbutton = new JButton("Calculate");
		calcbutton.setEnabled(false);
		calcbutton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		calcbutton.setForeground(UIManager.getColor("CheckBox.focus"));
		calcbutton.setBackground(UIManager.getColor("Button.darkShadow"));
		calcbutton.setBounds(301, 407, 89, 23);
		getContentPane().add(calcbutton);
		
		
		
		//Shape Panel
		shapepanelx = new JPanel();
		panelpic = new JLabel();
		panelpic.setIcon(panelshape);
		shapepanelx.add(panelpic);
		
		shapepanelx.setBounds(433, 130, 300, 300);
		getContentPane().add(shapepanelx);
		
		
		//Finishing
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
	

	}
	
	@Override
	public void actionPerformed(ActionEvent getshape)
	{
		if (getshape.getSource()==squarebtn)
		{
			panelshape = new ImageIcon("squarex.png");
			calcbutton.setEnabled(true);
			shapeno = 1;
		}
		else if (getshape.getSource()==trianglebtn)
		{
			panelshape = new ImageIcon("trianglex.png");
			calcbutton.setEnabled(true);
			shapeno = 2;
		}
		else if (getshape.getSource()==rectanglebtn)
		{
			panelshape = new ImageIcon("rectanglex.png");			
			calcbutton.setEnabled(true);
			shapeno = 3;
		}
		else{}
		
		panelpic.setIcon(panelshape);
		shapepanelx.add(panelpic);
		
		
		
		calcbutton.addActionListener(new ActionListener() 
		{	@Override
			public void actionPerformed(ActionEvent e) 
			{
			mainmenu.dispose();
			switch (shapeno)
			{
			case 1: new SquareMenu(); break;
			case 2: new TriangleMenu(); break;
			case 3: new RectangleMenu(); break;
			
			}
			}
		});
		
		
		
	}
}

