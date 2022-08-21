package place;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class list extends JFrame{
	
	list() throws Exception{
		dao d = new dao();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("저장되어 있는 리스트");	
		setSize(500,600);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		ArrayList<Member>arr = d.create();
		System.out.println(arr.size());
		String header[] = {"id","이름"};
		String cells[][] = new String[arr.size()][2];
		for(int i=0;i<arr.size();i++) {
			int k = arr.get(i).getId();
			System.out.println(k);
			cells[i][0] = k+"";
			cells[i][1]=arr.get(i).getName();
		}
		
		JTable table = new JTable(cells,header);
		this.add(new JScrollPane(table));
		setVisible(true);
		
		JButton btn = new JButton("돌아가기");
		btn.setBounds(30,30,30,30);
		this.add(btn);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new gui_main();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
			
		});
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new list();
	}

}
