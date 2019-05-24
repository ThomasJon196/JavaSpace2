import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
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
	private JTextField txtVideoURL;
	private JTextField textFieldPLStartNumber, textFieldPLEndNumber;
	private String commands, addres, program;
	private boolean playlistOrNot;

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
	 * 
	 */
	private void initialize() {
		program = "youtube-dl.exe";
		commands = "cmd /c start cmd.exe /K youtube-dl.exe";
		addres = "";
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
		
		txtVideoURL = new JTextField();
		txtVideoURL.setText("Songs or Playlists URL here...");
		txtVideoURL.setBounds(146, 288, 328, 20);
		frame.getContentPane().add(txtVideoURL);
		txtVideoURL.setColumns(10);
		
		JButton btnDownload = new JButton("");
		btnDownload.setIcon(new ImageIcon("C:\\Users\\Thomas\\Desktop\\JavaSpace2\\"
				+ "UserInterface\\Icons\\icons8-download-32.png"));
		btnDownload.setBounds(494, 274, 45, 34);
		frame.getContentPane().add(btnDownload);
		
		textFieldPLStartNumber = new JTextField();
		textFieldPLStartNumber.setBounds(135, 124, 45, 20);
		frame.getContentPane().add(textFieldPLStartNumber);
		textFieldPLStartNumber.setColumns(10);
		textFieldPLStartNumber.setEnabled(false);
		
		textFieldPLEndNumber = new JTextField();
		textFieldPLEndNumber.setBounds(134, 147, 86, 20);
		frame.getContentPane().add(textFieldPLEndNumber);
		textFieldPLEndNumber.setColumns(10);
		textFieldPLEndNumber.setEnabled(false);
		
		JLabel lblStartAtTrack = new JLabel("Start at Track: ");
		lblStartAtTrack.setBounds(52, 127, 73, 14);
		frame.getContentPane().add(lblStartAtTrack);
		lblStartAtTrack.setEnabled(false);
		
		JRadioButton rdbtnPlaylist = new JRadioButton("Playlist");
		rdbtnPlaylist.setBounds(138, 52, 109, 23);
		frame.getContentPane().add(rdbtnPlaylist);		
			
		JRadioButton rdbtnSingleTrack = new JRadioButton("Single Track");
		rdbtnSingleTrack.setBounds(365, 52, 109, 23);
		frame.getContentPane().add(rdbtnSingleTrack);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnPlaylist);
		bg.add(rdbtnSingleTrack);
		
		JLabel lblQuality = new JLabel("Quality:");
		lblQuality.setBounds(52, 196, 46, 14);
		frame.getContentPane().add(lblQuality);
		
		JLabel lblEndAtTrack = new JLabel("End at Track:");
		lblEndAtTrack.setBounds(52, 150, 73, 14);
		frame.getContentPane().add(lblEndAtTrack);

		/*
		 * Functionality
		 */
		rdbtnSingleTrack.addActionListener(new ActionListener() {
			/*
			 *  Pushing this radio button enables all contents
			 *  that are in relation to a playlistdownload
			 */   
			public void actionPerformed(ActionEvent e) {
				playlistOrNot = false;
			} 
		});	
		
		rdbtnPlaylist.addActionListener(new ActionListener() {
			/*
			 *  Pushing this radio button enables all contents
			 *  that are in relation to a playlistdownload
			 */   
			public void actionPerformed(ActionEvent e) {
				playlistOrNot = true;
				textFieldPLStartNumber.setEnabled(true);
				textFieldPLEndNumber.setEnabled(true);
				lblStartAtTrack.setEnabled(true);
			} 
		});	
		
		btnDownload.addActionListener(new ActionListener() {
			/*
			 * Takes all entries in the textfields, puts them in one command
			 * and starts the download using the .exe
			 */
			public void actionPerformed(ActionEvent e) {
				if(playlistOrNot) {
					if(!(textFieldPLEndNumber.getText().equals(""))){
						commands += "--playlist-end " + textFieldPLEndNumber.getText();
					}
					if(!(textFieldPLStartNumber.getText().equals(""))){
						commands+="--playlist-start " + textFieldPLStartNumber.getText();
					}
				}
				commands += "--format 140";
				commands += txtVideoURL.getText();
				try {
					Runtime.getRuntime().exec("cmd /c start cmd.exe /K "
						+ program + " "
						+ commands + " "
						+ addres 
						+ "\"");
					}catch(IOException e2) {
						System.out.println("Something went wrong");
						e2.printStackTrace();
					}
			}
		});
	}
		
}
	
