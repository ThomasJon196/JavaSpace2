import javax.swing.*;
import java.awt.event.*;

public class Window {
	JFrame frame;
	final int frameX = 600, frameY = 500;
	
	public Window() {
		frame = new JFrame("Window");
		
		JTextField tf1 = new JTextField();
		tf1.setBounds(50, 50, 150, 20);
		JButton b1 = new JButton(new ImageIcon("C:\\Users\\Thomas\\Desktop\\JavaSpace2\\"
				+ "UserInterface\\Icons\\icons8-download-32.png"));
		b1.setBounds(150, 100, 100, 40);
		b1.setEnabled(true);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("Nibba");
			}
		});
		
		
		frame.add(new TextArea().area);
		frame.add(b1);
		frame.add(tf1);
		frame.setSize(frameX, frameY);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Window();
	}
	
}
