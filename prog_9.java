import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;

public class prog_9 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFile;
	JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prog_9 frame = new prog_9();
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
	public prog_9() {
		setTitle(" \u041E\u043F\u0435\u0440\u0430\u0446\u0438\u044F \u0434\u043B\u044F \u0440\u0430\u0431\u043E\u0442 \u0441 \u0444\u0430\u0439\u043B\u0430\u043C\u0438");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldFile = new JTextField();
		textFieldFile.setBounds(132, 11, 292, 20);
		contentPane.add(textFieldFile);
		textFieldFile.setColumns(10);
		
	
		
		JButton btnCreateNew = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u043D\u043E\u0432\u044B\u0439");
		btnCreateNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCreateNew.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String str = textFieldFile.getText().trim();
						if (str.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Enter path to file", "Error",0);
						
						}else {
							File nf = new File(str);
							try {
								nf.createNewFile();
								JOptionPane.showMessageDialog(null, "File is create", "Message", 1);
							}
							catch (IOException exp) {
								JOptionPane.showMessageDialog(null, "File is not create", "Error" , 0);
							}
						}
					}
				});
			}
		});
		btnCreateNew.setBounds(0, 80, 122, 23);
		contentPane.add(btnCreateNew);
		
		JButton btnDelete = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldFile.getText().trim();
				if (str.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Введите путь к файлу", "Ощибка",0);
				}else {
					File cf = new File(str);
					try {
						cf.delete();
						JOptionPane.showMessageDialog(null,"Файл удален","Сообщение", 1);
					}
					catch (Exception exp) {
						JOptionPane.showMessageDialog(null,"Файл не найден","Ошибка", 0);
					}
 				}
			}
		});
		btnDelete.setBounds(0, 114, 122, 23);
		contentPane.add(btnDelete);
		
		JButton btnRename = new JButton("\u041F\u0435\u0440\u0435\u043C\u0435\u043D\u043E\u0432\u0430\u0442\u044C");
		
		btnRename.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				String str = textFieldFile.getText().trim();
				if (str.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Введите путь к файлу","Ошибка", 0);
				}else {
					File rf = new File(str);
					if(rf.exists()) {
						String newName=JOptionPane.showInputDialog("Введите новое имя");
						if(newName==null) {newName="";}
						if(!newName.trim().isEmpty()) {
							File newFile=new File(rf.getParent()+"\\"+newName);
							rf.renameTo(newFile);
							JOptionPane.showMessageDialog(null,"Файл переименован!","Сообщение", 1);
						}
					}else {
						JOptionPane.showMessageDialog(null,"Файл не найден","Ошибка",0);
					}
				}
			}
		});
		btnRename.setBounds(0, 148, 122, 23);
		contentPane.add(btnRename);
		
		JButton btnRead = new JButton("\u041F\u0440\u043E\u0447\u0438\u0442\u0430\u0442\u044C");
	    btnRead.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String str = textFieldFile.getText().trim();
	    		if(str.isEmpty()) {
	    			JOptionPane.showMessageDialog(null,"Введите путь к файлу","Ошибка",0);
	    		}else {
	    			File nf = new File(str);
	    			if(nf.exists()) {
	    				try {
	    					InputStream obj=new FileInputStream(str);
	    					BufferedReader in=new BufferedReader(new InputStreamReader(obj));
	    					String tmp="";
	    					while(in.ready()) {
	    						tmp+=in.readLine()+"\n";
	    					}
	    					textArea.setText(tmp);
	    					in.close();
	    					obj.close();
	    				}
	    				catch (Exception exp) {}
	    			}else {
	    				JOptionPane.showMessageDialog(null,"Файл не найден","Ошибка",0);
	    			}
	    		}
	    	}
	    });
		btnRead.setBounds(0, 182, 122, 23);
		contentPane.add(btnRead);
		
		JButton btnWriteDown = new JButton("\u0417\u0430\u043F\u0438\u0441\u0430\u0442\u044C");
		btnWriteDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldFile.getText().trim();
				if(str.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Введите путь к файлу","Ошибка",0);
				}else {
					File nf = new File(str);
					if (nf.exists()) {
						try {
							OutputStream obj = new FileOutputStream(str);
							BufferedWriter out = new BufferedWriter(new OutputStreamWriter(obj));
							out.write(textArea.getText());
							out.close();
							obj.close();
							JOptionPane.showMessageDialog(null, "Запись выпоглнена!!!", "Сообщение", 1);
						}
						catch (Exception exp) {}
					}else {
						JOptionPane.showMessageDialog(null, "Файл не найден","Ошибка", 0);
					}
						
					
				}
			}
		});
		
		btnWriteDown.setBounds(0, 216, 122, 23);
		contentPane.add(btnWriteDown);
		
		JLabel lblNewLabel = new JLabel("\u0423\u043A\u0430\u0437\u0430\u0442\u044C \u043F\u0443\u0442\u044C \u043A \u0444\u0430\u0439\u043B\u0443");
		lblNewLabel.setBounds(0, 11, 114, 20);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 80, 292, 159);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
	}
}
