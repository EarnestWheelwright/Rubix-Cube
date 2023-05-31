import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Main {
  public static void main(String[] args) {
		//creates new cube and panel object
		Cube cube = new Cube();
		Panel panel = new Panel(cube);
		//System.out.println(cube);
    JFrame fram = new JFrame("Rubik's Cube :D");
		//Timer
		JLabel timer = new JLabel("00:00:00");
		timer.setBounds(100,0,200,50);
		//timer.setText();
		//create button reset
		Button reset = new Button("Reset");
		reset.setBounds(0, 0, 100, 50);
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cube.reset();
				//System.out.println(cube);
				SwingUtilities.updateComponentTreeUI(fram);
				
			}
		});
		//create button scramble
    Button scramble = new Button("Scramble");
    scramble.setBounds(50, 300, 100, 100);
		scramble.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				cube.scramble();
				//System.out.println(cube);
				SwingUtilities.updateComponentTreeUI(fram);
			}
		});
		//create button rowOrCol
    Button rowOrCol = new Button("Row/Col/Layer");
    rowOrCol.setBounds(150, 300, 100, 100);
		rowOrCol.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Select.select += 1;
				Select.select %= 3;
				//System.out.println("Select: " + Select.select);
				SwingUtilities.updateComponentTreeUI(fram);
			}
		});
    //create button next
    Button next = new Button("Next");
    next.setBounds(250, 300, 100, 50);
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(Select.select == 0){
					Select.layer += 1;
					Select.layer %= 3;
					//System.out.println("Layer: " + Select.layer);
				}
				else if(Select.select == 1)
				{
					if(Select.row == 0)
					{
						Select.row = 2;
					}
					else
					{
						Select.row -= 1;
					}
					//System.out.println("Row: " + Select.row);
				}
				else{
					Select.col += 1;
					Select.col %= 3;
					//System.out.println("Col: " + Select.col);
				}
				SwingUtilities.updateComponentTreeUI(fram);
			}
		});
		//create button rotate
    Button rotate = new Button("Rotate");
    rotate.setBounds(350, 300, 100, 50);
		rotate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(Select.select == 0)
				{
					cube.rotateRight(Select.layer);
				}
				else if(Select.select == 1)
				{
					cube.rotateRowUp(Select.row);
				}
				else
				{
					cube.rotateColUp(Select.col);
				}
				System.out.println(cube.solved());
				//System.out.println(cube);
				SwingUtilities.updateComponentTreeUI(fram);
			}
		});
		//create button toggle (reverse)
		Button toggle = new Button("Reverse");
    toggle.setBounds(350, 350, 100, 50);
		toggle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(Select.select == 0)
				{
					cube.rotateLeft(Select.layer);
				}
				else if(Select.select == 1)
				{
					cube.rotateRowDown(Select.row);
				}
				else
				{
					cube.rotateColDown(Select.col);
				}
				System.out.println(cube.solved());
				//System.out.println(cube);
				SwingUtilities.updateComponentTreeUI(fram);
			}
		});
		//create button back
		Button back = new Button("Back");
		back.setBounds(250, 350, 100, 50);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(Select.select == 0){
					if(Select.layer == 0)
					{
						Select.layer = 2;
					}
					else
					{
						Select.layer -= 1;
					}
					//System.out.println("Layer: " + Select.layer);
				}
				else if(Select.select == 1)
				{
					Select.row += 1;
					Select.row %= 3;
					//System.out.println("Row: " + Select.row);
				}
				else
				{
					if(Select.col == 0)
					{
						Select.col = 2;
					}
					else
					{
						Select.col -= 1;
					}
					//System.out.println("Col: " + Select.col);
				}
				SwingUtilities.updateComponentTreeUI(fram);
			}
		});
		//adds all buttons and panel to the frame
    fram.setSize(500, 500);
		fram.add(timer);
		fram.add(reset);
    fram.add(scramble);
    fram.add(rowOrCol);
    fram.add(next);
    fram.add(rotate);
		fram.add(toggle);
		fram.add(back);
		fram.add(panel);
		fram.pack();
		fram.setVisible(true);
	}
}