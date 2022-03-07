package OneMemo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

//=============================================================================
//public class OneMemo
//=============================================================================
public class OneMemo extends JFrame {	
	
	//=============================================================================
	//public static void main(String[] args)
	//=============================================================================
	public static void main(String[] args) {
		new MainPanel();
	
	}//public static void main(String[] args)
	
}//public class OneMemo


//=============================================================================
//class MainDisplay
//=============================================================================
class MainPanel extends JFrame {
	
	static int mainPanelX = 800;
	static int mainPanelY = 600;	
	static File selectedNode;
	JTextField 	tf 			= new JTextField();
	JTextArea 	ta 			= new JTextArea();
	DefaultTreeModel model;
	JTree jt;
	
	//=============================================================================
	//class TreeSelection implements TreeSelectionListener 
	//=============================================================================
	class TreeSelection implements TreeSelectionListener {
					
		@Override
		public void valueChanged(TreeSelectionEvent e) {			
			
			String baseLoca = "C:/";
			String seleLoca = "";
			String text = "";
			StringBuilder sb = new StringBuilder();

			int count = e.getPath().getPathCount();
			for(int i = 0; i < count; i++) {
				seleLoca += e.getPath().getPathComponent(i) + "/";
			}

			selectedNode = new File(baseLoca + seleLoca);
			
			/* 선택한 노드가 폴더일 경우, tf와 ta를 공백으로 만든다. */
			if(selectedNode.isDirectory()) {
				tf.setText("");
				ta.setText("");
				tf.setEnabled(true);		
				ta.setEnabled(true);
				
			/* 선택한 노드가 파일일 경우, 파일명과 파일내용을 불러와 tf와 ta에 덮어쓴다.	*/
			} else if(selectedNode.isFile()) {		
				try {			
					FileReader 		fileReader 		= new FileReader(baseLoca + seleLoca);
					try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
						String title = e.getPath().getPathComponent(count - 1).toString();
						String newTitle = title.substring(0, title.lastIndexOf("."));
										
						tf.setText(newTitle);
						tf.setEnabled(false);
						
						while((text = bufferedReader.readLine()) != null) {
							sb.append(text + "\n");
						}
					}
					ta.setText(sb.toString());					
				} catch(Exception e1) {
					e1.getStackTrace();
				}
			
			}//else if(testFile.isFile())	
		}//public void valueChanged(TreeSelectionEvent e)
	}//class TreeSelection implements TreeSelectionListener 
	
	
	//=============================================================================
	//class Save implements ActionListener
	//=============================================================================
	class Save implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(selectedNode.isDirectory()) {
				System.out.println("selectedNode: " + selectedNode);
				File newTxt = new File(selectedNode.toString() + "/" + tf.getText() + ".txt/");
				System.out.println("newTxt: " + newTxt);
				try {
					newTxt.createNewFile();
					FileOutputStream fos = new FileOutputStream(newTxt);
					OutputStreamWriter writer = new OutputStreamWriter(fos);
					writer.write(ta.getText());
					writer.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if((selectedNode.isFile())) {	
				System.out.println("파일: " + selectedNode);
				try {				
					File editTxt = selectedNode;
					FileOutputStream fos = new FileOutputStream(editTxt);
					OutputStreamWriter writer = new OutputStreamWriter(fos);
					writer.write(ta.getText());
					writer.close();
				} catch (Exception e1) {
					e1.getStackTrace();
				}				
			}			
		}//public void actionPerformed(ActionEvent e)
	}//class Save implements ActionListener
	
	 	
	//=============================================================================
	//class Delete implements ActionListener
	//=============================================================================
	class Delete implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			DeleteThread dt = new DeleteThread(selectedNode);
			dt.start();
			
		}//public void actionPerformed(ActionEvent e) 
	}//class Delete implements ActionListener 
	
	
	//=============================================================================
	//MainPanel()
	//=============================================================================
	MainPanel() {
		
		setTitle("ONE & MEMO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		
		JPanel 	leftPanel 	= new JPanel();
		JPanel 	rightPanel 	= new JPanel();
		JPanel  upperPanel	= new JPanel();
		
		MenuPanel(upperPanel);
		TreePanel(leftPanel);
		MemoPanel(rightPanel);
		
		upperPanel.setBackground(new Color(120, 50, 150));
		
		/**
		 * if문으로 구분하여 두 가지 텍스트를 표현하도록 추가한다
		 * 텍스트파일을 선택한 경우, 제목과 내용을 포함하고 있는 텍스트 파일 호출
		 * 폴더를 선택한 경우 해당 폴더 경로를 포함하고 있는 새로운 텍스트 파일 생성
		 * 아무것도 선택하지 않은 경우 기본 폴더를 경로로 하여 새로운 텍스트파일 선택
		 */
		
		GridBagConstraints gbc0 = new GridBagConstraints();
		GridBagConstraints gbc1 = new GridBagConstraints();
		GridBagConstraints gbc2 = new GridBagConstraints();
		
		gbc0.gridx = 0;
		gbc0.gridy = 0;
		gbc0.gridwidth = 3;
		gbc0.gridheight = 1;
		gbc0.weightx = 1;
		gbc0.weighty = 1;
		gbc0.fill = GridBagConstraints.HORIZONTAL;
		
		gbc1.gridx = 0;
		gbc1.gridy = 1;
		gbc1.gridwidth = 1;
		gbc1.gridheight = 1;
		gbc1.weightx = 1;
		gbc1.weighty = 100;
		gbc1.fill = GridBagConstraints.BOTH;
		
		gbc2.gridx = 2;
		gbc2.gridy = 1;
		gbc2.gridwidth = 1;
		gbc2.gridheight = 1;
		gbc2.weightx = 2;
		gbc2.weighty = 1;
		gbc2.fill = GridBagConstraints.BOTH;
		
		add(upperPanel, gbc0);
		add(leftPanel, gbc1);
		add(rightPanel, gbc2);	
		
		setSize(mainPanelX, mainPanelY);
		setVisible(true);
		
	}//MainPanel()
	
	/**
	 * 현재 미사용중인 내용 메소드
	 */
	void DeleteNode(File selectedNode) {

	}
	
	//=============================================================================
	//JPanel TreePanel
	//=============================================================================
	JPanel TreePanel(JPanel panel) {
		
		Path 					path 		= Paths.get("C:/Memo");
		File[] 					mainFiles 	= path.toFile().listFiles();
		DefaultMutableTreeNode 	mainDirList = new DefaultMutableTreeNode(path.getFileName());
		jt 			= new JTree(mainDirList);
		model 		= (DefaultTreeModel)jt.getModel();
		TreeSelection			selection 	= new TreeSelection();
		Delete					delete		= new Delete();
		JButton					delMemoBtn  = new JButton("삭제");


		panel.setLayout(new BorderLayout());
		panel.add(jt, BorderLayout.CENTER);
		panel.add(delMemoBtn, BorderLayout.SOUTH);
		delMemoBtn.addActionListener(delete);
		jt.setFont(new Font("", Font.BOLD, 15));
		jt.setBackground(Color.WHITE);
		jt.setBorder(new TitledBorder(new LineBorder(Color.BLACK,3), "Lists"));
		jt.setPreferredSize(new Dimension(mainPanelX / 10 * 2, mainPanelY / 2));
		panel.setBackground(Color.WHITE);
		
		for(int i = 0; i < mainFiles.length; i++) {
			path = Paths.get(mainFiles[i].toString());
			File[] subFiles = path.toFile().listFiles();		
			DefaultMutableTreeNode firstDirList = new DefaultMutableTreeNode(path.getFileName());

			mainDirList.add(firstDirList);
		
			if(mainFiles[i].isDirectory() == true) {
				for(int j = 0; j < subFiles.length; j++) {
					path = Paths.get(subFiles[j].toString());
					DefaultMutableTreeNode secondDirList = new DefaultMutableTreeNode(path.getFileName());
					firstDirList.add(secondDirList);										
				}
			}			
		}
		if(jt != null) { jt.addTreeSelectionListener(selection); }	
		return panel;
				
	}//JPanel TreePanel()
	
	
	/**
	 * 클릭한 폴더가 있을 경우 해당 폴더의 위치 정보를 받아서 메모를 저장
	 * 클릭한 폴더가 없을 경우나 메모 폴더를 선택한 경우는 기본 경로에 저장
	 * 파일을 선택한 경우 해당 파일의 내용을 표시
	 * 단. 파일을 선택한 경우 제목은 수정할 수 없도록 처리
	 */
	
	//=============================================================================
	//JPanel MemoPanel
	//======================== =====================================================
	JPanel MemoPanel(JPanel panel) {		
		
		JPanel		fontMenu		= new JPanel();
		JPanel		textArea		= new JPanel();
		JButton 	saveBtn 		= new JButton("저장");
		JButton		fontSizeUp		= new JButton("+");
		JButton		fontSizeDown	= new JButton("-");
		JButton		fontBold		= new JButton("진");
		JButton		fontUnderLine	= new JButton("밑");
		Save 		save 			= new Save();
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gblTf = new GridBagConstraints();
		GridBagConstraints gblTa = new GridBagConstraints();
		
		gblTf.gridx = 0;
		gblTf.gridy = 0;
		gblTf.gridwidth = 1;
		gblTf.gridheight = 1;
		gblTf.weightx = 1;
		gblTf.weighty = 1;
		gblTf.fill = GridBagConstraints.HORIZONTAL;
		
		gblTa.gridx = 0;
		gblTa.gridy = 1;
		gblTa.gridwidth = 1;
		gblTa.gridheight = 1;
		gblTa.weightx = 1;
		gblTa.weighty = 500;
		gblTa.fill = GridBagConstraints.BOTH;
		
		fontMenu.setLayout(new FlowLayout());
		fontMenu.add(fontSizeUp);
		fontMenu.add(fontSizeDown);
		fontMenu.add(fontBold);
		fontMenu.add(fontUnderLine);
				
		panel.add(tf, gblTf);
		panel.add(textArea, gblTa);

		textArea.setLayout(new BorderLayout());
		textArea.add(fontMenu, BorderLayout.NORTH);
		textArea.add(ta, BorderLayout.CENTER);
		textArea.add(saveBtn, BorderLayout.SOUTH);
		
		panel.setPreferredSize(new Dimension(mainPanelX / 10 * 7, mainPanelY));
		
		saveBtn.addActionListener(save);	
		
		tf.setEnabled(false);
		ta.setEnabled(false);
		
		return panel;

	}//JPanel MemoPanel()
	
	
	//=============================================================================
	//JPanel MenuPanel
	//=============================================================================
	JPanel MenuPanel(JPanel panel) {
		
		JLabel title = new JLabel("One & Memo");		
		panel.add(title);
		
		return panel;
		
	}//JPanel MemoPanel()
	
}//class MainDisPlay


//=============================================================================
//class DeleteThread extends Thread
//=============================================================================
class DeleteThread extends Thread {
	File path;
	
	DeleteThread(File path) {
		this.path = path;
	}
	
	public void run() {
		if(path.exists()) {
			for(int i = 0; i < 100; i++) {
				if(path.delete()) {
					System.out.println("성공");
					break;
				} else {
					System.out.println("실패");
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}
	}//public void run() 
}//class DeleteThread extends Thread


















