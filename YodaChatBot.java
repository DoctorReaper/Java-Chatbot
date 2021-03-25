import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.lang.Math;

public class YodaChatBot extends JFrame implements KeyListener{

	JPanel p=new JPanel();
	JTextArea dialog=new JTextArea(20,50);
	JTextArea input=new JTextArea(1,50);
	JScrollPane scroll=new JScrollPane(
		dialog,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	);
	
	
	
	public static void main(String[] args){
		new YodaChatBot();
	}
	

	public YodaChatBot(){
		super("Yoda Chat Bot");
		setSize(800,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dialog.setEditable(false);
		input.addKeyListener(this);
	
		p.add(scroll);
		p.add(input);
		p.setBackground(new Color(0,0,50));
		add(p);
		
		setVisible(true);
	}

	String[][] chatBot={
		//standard greetings
		{"hi","hello", "hi there"},
		{"Greetings Padawan", "Of assistance how may I be?"},
		//question greetings
		{"how are you","how r you","how r u","how are u"},
		{"Fine I am, how are you", "There is balance in the force, is there balance in you?"},
		//yes
		{"yes"},
		{"Good to hear that is"},
		//I am fine
		{"im good", "im fine", "i am fine", "i am good"},
		{"Splendid news that is"},
		//hello there
		{"hello there"},
		{"General Kenobi"},
		//Freetime
		{"what do you do in your free time"},
		{"I meditate becoming one with the force"},
		//Q and A
		{"where was luke skywalker born"},
		{"Tatooine"},
		{"who is darth vader"},
		{"Ahh the chosen one, Anakin Skywalker"},
		{"where did luke train"},
		{"Kashyyk, trained him myself I did"},
		{"are you human"},
		{"Ha Ha, your species I do not originate from"},
		{"will you train me"},
		{"Are you ready to be trained?"},
		{"when can we start"},
		{"When the time is right padawan"},
		{"what is your name"},
		{"I am Jedi Master Yoda, and who are you"},
		//default
		{"The Force is strong within you", "Careful you must be, the darkside emerging I sense"}
	};
	
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(false);
			//-----grab quote-----------
			String response;
			response=input.getText();
			input.setText("");
			addText("Interacter:\t"+response);
			response.trim();
			byte inArray=0;
			
			int j=0;
			while(inArray==0){
				if(inArray(response.toLowerCase(),chatBot[j*2])){
					inArray=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\nYoda:\t"+chatBot[(j*2)+1][r]);
				}
				j++;
				if(j*2==chatBot.length-1 && inArray==0){
					inArray=1;
				}
			}
			
			if(inArray==1){
				int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
				addText("\nYoda:\t"+chatBot[chatBot.length-1][r]);
			}
			addText("\n");
		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}

	public boolean inArray(String in,String[] str){
		boolean same=false;
		for(int i=0;i<str.length;i++){
			if(str[i].equals(in)){
				same=true;
			}
		}
		return same;
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		dialog.setText(dialog.getText()+str);
	}
	
	
}