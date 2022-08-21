package place;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
public class inde extends JFrame{
	
	
	inde(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메뉴");
		setSize(600,150);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		JLabel lbl1 = new JLabel("학생 번호");
		this.add(lbl1);
		
		JTextField t1 = new JTextField("",4);
		
		this.add(t1);
		
		JLabel lbl2 = new JLabel("학생 이름");
		this.add(lbl2);
		
		JTextField t2 = new JTextField("",20);
		this.add(t2);
		
		JButton btn1 = new JButton("입력");
		this.add(btn1);
		
		JButton btn2 = new JButton("삭제");
		this.add(btn2);
		
		
		JButton btn3 = new JButton("돌아가기");
		this.add(btn3);
		setVisible(true);
		dao d = new dao();
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(t1.getText());
				String str = t2.getText();
				boolean b= d.insert(id,str);
				if(b==true) {
					JOptionPane.showMessageDialog(null,"입력되었습니다.");
				}
				else {
					JOptionPane.showMessageDialog(null,"다시확인해주세요");			
				}
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(t1.getText());
				boolean b = d.delect(id);
				if(b==true) {
					JOptionPane.showMessageDialog(null,"삭제되었습니다.");
				}
				else {
					JOptionPane.showMessageDialog(null,"다시확인해주세요");			
				}
			}
			
		});
		btn3.addActionListener(new ActionListener() {

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new inde();
	}

}
