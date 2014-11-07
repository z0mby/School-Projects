package lab4;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Lab4 extends JFrame {
	public Lab4(){
		// lab 4 is set as title bar for JFrame
		super("Lab 4");
		// call ScreenSaver constructor and run that class.
		ScreenSaver saver=new ScreenSaver();
		// Set and add borderlayouts for screen.
		setLayout(new BorderLayout());
		add(saver, BorderLayout.CENTER);
	}
	
	public static void main(String []args){
		// Call lab4 constructor
		Lab4 lab4=new Lab4();
		//close afterwards.
		lab4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		// Size and window specification for the program
		lab4.setSize(200, 210); // set frame size
		lab4.setResizable(true);
		lab4.setVisible(true); // display frame
		lab4.setLocationRelativeTo(null);
	}
} // end lab4

package lab4;

import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import java.lang.Math;


public class ScreenSaver extends JPanel implements ActionListener, MouseWheelListener{
	// x value points for drawing
	private int x[]=new int[60];
	// y value points for drawing
	private int y[]=new int[60];
	// number of points to be increased, max is 60
	private int numOfPoints=0;
	private int radius=10;
	// How long each line will be drawn (in this case 1 second.)
	private int delay=1000;
	private Timer timer=null; // javax.swing.timer

	public ScreenSaver(){
		timer=new Timer(1000, this); // the interval is 1000 milliseconds
		timer.start();
		addMouseWheelListener(this);
	}
	
	// This method will decide where each line will be drawn in the program
	public void actionPerformed(ActionEvent e){
		// size and width of the center of the circle(?)
		double centerX = getSize().getWidth()/2;
		double centerY = getSize().getHeight()/2;
		// Determine what the drawn angles are. Will increase as numofpoints increases.
		double pX = centerX + Math.cos(numOfPoints*Math.PI/3)*radius;
		double pY = centerY + Math.sin(numOfPoints*Math.PI/3)*radius;
		// angles are typecasted for array and put into each element of the array (?)
		x[numOfPoints] = (int)pX;
		y[numOfPoints] = (int)pY;
		numOfPoints++;
		radius +=1;
		// if num of points goes past 60, it and the radius will be reset.
		if (numOfPoints == 60){
				numOfPoints = 0;
				radius = 10;
			}
		
		// call paint component to clear everything and draw again.
		repaint();
	}
	
	
	public void paintComponent(Graphics g){
		// clear everything and draw
		g.clearRect(0,0,(int)getSize().getWidth(),(int)getSize().getHeight());
		// draw based on action parameters.
		g.drawPolyline(x, y, numOfPoints);
		
	}
	
	
		public void mouseWheelMoved(MouseWheelEvent e){
			// Gets wheel rotation and when the wheel is scrolled up...
			int r = e.getWheelRotation();
			if (r < 0){
				//decrease delay by 50 (Please note anything past 1000 will crash.) else
				timer.setDelay(delay-= 50);
			}else{
				// Increase delay by 50 when wheeling down.
				timer.setDelay(delay+= 50);
			}
			timer.restart();
		}
}
