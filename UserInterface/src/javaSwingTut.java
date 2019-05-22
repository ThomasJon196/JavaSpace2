import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Color;

public class javaSwingTut {

	private JFrame frame;
	private JTextField txtSongsOrPlaylists;
	private JTextField textFieldPLNumber;
	private String commands;
	private String addres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javaSwingTut window = new javaSwingTut();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public javaSwingTut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Download-Helper");
		frame.setFont(UIManager.getFont("ToolTip.font"));
		frame.setBounds(800, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblYoutubeOrg = new JLabel("YouTub-E . org DoWnLoAd - M.Neger");
		lblYoutubeOrg.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYoutubeOrg.setBounds(146, 11, 345, 34);
		frame.getContentPane().add(lblYoutubeOrg);		
		
		txtSongsOrPlaylists = new JTextField();
		txtSongsOrPlaylists.setText("Songs or Playlists URL here...");
		txtSongsOrPlaylists.setBounds(146, 288, 328, 20);
		frame.getContentPane().add(txtSongsOrPlaylists);
		txtSongsOrPlaylists.setColumns(10);
		
		JButton btnDownload = new JButton("");
		btnDownload.setIcon(new ImageIcon("C:\\Users\\Thomas\\Desktop\\JavaSpace2\\"
				+ "UserInterface\\Icons\\icons8-download-32.png"));
		btnDownload.setBounds(494, 274, 45, 34);
		frame.getContentPane().add(btnDownload);
		
		textFieldPLNumber = new JTextField();
		textFieldPLNumber.setBounds(135, 124, 45, 20);
		frame.getContentPane().add(textFieldPLNumber);
		textFieldPLNumber.setColumns(10);
		textFieldPLNumber.setEnabled(false);
		
		JLabel lblStartAtTrack = new JLabel("Start at Track: ");
		lblStartAtTrack.setBounds(52, 127, 73, 14);
		frame.getContentPane().add(lblStartAtTrack);
		lblStartAtTrack.setEnabled(false);
		
		JRadioButton rdbtnPlaylist = new JRadioButton("Playlist");
		rdbtnPlaylist.setBounds(138, 52, 109, 23);
		frame.getContentPane().add(rdbtnPlaylist);
		rdbtnPlaylist.addActionListener(new ActionListener() {
		/* Using this radio button enables all elements that are in relation to a playlistdownload */
			@Override  
			public void actionPerformed(ActionEvent e) {
				textFieldPLNumber.setEnabled(true);
				lblStartAtTrack.setEnabled(true);
			}

		});			
			
		JRadioButton rdbtnSingleTrack = new JRadioButton("Single Track");
		rdbtnSingleTrack.setBounds(382, 52, 109, 23);
		frame.getContentPane().add(rdbtnSingleTrack);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnPlaylist);
		bg.add(rdbtnSingleTrack);
	}
}
