package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import controller.CorridaThread;

public class Corrida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Corrida frame = new Corrida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Corrida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Carro 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(10, 100, 97, 42);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel2 = new JLabel("Carro 2");
		lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel2.setForeground(new Color(0, 0, 255));
		lblNewLabel2.setBounds(10, 200, 97, 42);
		contentPane.add(lblNewLabel2);
		
		JButton correr = new JButton("CORRER");
		correr.setFont(new Font("Tahoma", Font.PLAIN, 25));
		correr.setBounds(76, 350, 181, 48);
		contentPane.add(correr);
		
		JLabel lblNewLabel_1 = new JLabel("Vencedor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(350, 350, 113, 30);
		contentPane.add(lblNewLabel_1);
		
		JTextArea vencedor = new JTextArea();
		vencedor.setBounds(473, 355, 150, 22);
		contentPane.add(vencedor);
		
		JTextArea perdedor = new JTextArea();
		perdedor.setBounds(473, 400, 150, 22);
		contentPane.add(perdedor);
		
		JLabel lblNewLabel_2 = new JLabel("Perdedor");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(350, 393, 80, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel_3.setBounds(0, 170, 1076, 13);
		contentPane.add(lblNewLabel_3);
		
		ActionListener inicia = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				correr.setBounds(0, 0, 0, 0);
				Thread carro1 = new CorridaThread(lblNewLabel,0,vencedor,perdedor);
				Thread carro2 = new CorridaThread(lblNewLabel2,1,vencedor,perdedor);
				carro1.start();
				carro2.start();
				
			}
		};
		correr.addActionListener(inicia);
	}
}
