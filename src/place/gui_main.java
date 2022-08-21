package place;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class gui_main extends JFrame{
	ArrayList<Member>arr = new ArrayList<Member>();
	dao cm = new dao();
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	gui_main() throws Exception{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("자리 배치 프로그램");			
		
		this.setLayout(new GridLayout(5,6,80,80));
		
		JTextField[] box = new JTextField[25];
	
		JButton indebtn = new JButton("학생 정보 입력/삭제");
		indebtn.setHorizontalAlignment(SwingConstants.CENTER);
		JButton selectbtn = new JButton("학생 정보 조회");
		selectbtn.setHorizontalAlignment(SwingConstants.CENTER);
		JButton placebtn= new JButton("자리 배치");
		placebtn.setHorizontalAlignment(SwingConstants.CENTER);
		ArrayList<Member>ori = cm.create();
		arr = ori;
		if(arr.size()==25) {
			for(int i=1;i<=25;i++) {
				box[i-1] = new JTextField(arr.get(i-1).getName());
				box[i-1].setHorizontalAlignment(SwingConstants.CENTER);
				this.add(box[i-1]);
				if(i==5||i==10)this.add(new JLabel());
				if(i==15)this.add(indebtn);
				if(i==25)this.add(placebtn);
				if(i==20)this.add(selectbtn);
			}
		}
		else {
			for(int i=1;i<=25;i++) {
				JTextField b = new JTextField("");
				b.setHorizontalAlignment(SwingConstants.CENTER);
				this.add(b);
				if(i==5||i==10)this.add(new JLabel("인원수 25명으로 맞추어주세요"));
				if(i==15)this.add(indebtn);
				if(i==25)this.add(placebtn);
				if(i==20)this.add(selectbtn);
			}
		}
		
		
		setSize(screenSize.width,screenSize.height);
		setVisible(true);
		
		indebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new inde();
				setVisible(false);
			}
			
		});
		
		selectbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new list();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
			
		});
		placebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int chk[] = new int[25];
				System.out.println(-1);
				int idx=0;
				
				Random rd = new Random();
				rd.setSeed(System.currentTimeMillis());
				if(arr.size()==25) {
					while(true) {
						if(idx>=25)break;
						int n = rd.nextInt(25);
						System.out.println(n);
						if(chk[n]==1)continue;
						chk[n]=1;					
						box[idx].setText(arr.get(n).getName());
						idx++;
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"다시확인해주세요");
				}
				
			}			
		});
		
	}
	public static void main(String[] args) throws Exception {
		new gui_main();
	}

}
