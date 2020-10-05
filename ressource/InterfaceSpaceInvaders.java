import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceSpaceInvaders extends JFrame{
	
	private Color[][] g;
	private Color background = Color.BLACK;
	private Graphic p;
	private int bordure = 1,cell = 3;
	private KeyEvent ke;
	
	private class KEDispatcher implements KeyEventDispatcher { 
		public boolean dispatchKeyEvent(KeyEvent e) {
			if (e.getID() == KeyEvent.KEY_PRESSED) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_PAUSE || e.getKeyCode() == KeyEvent.VK_SPACE) ke = e;
			}
			return false;
		}
	}
	 
	public InterfaceSpaceInvaders(int largeur, int hauteur, Color fond){
		super("Space Invaders");
		this.g = new Color[largeur][hauteur];
		for(int i=0;i<this.g.length;i++){
			for(int j=0;j<this.g[i].length;j++){
				this.g[i][j] = background;
			}
		}
		this.background = fond;
		this.p = new Graphic();
		this.p.setPreferredSize(new Dimension(2*this.bordure+(this.g.length-1)*this.cell, 2*this.bordure+(this.g[0].length-1)*this.cell));
		this.getContentPane().add(this.p);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new KEDispatcher());
	}
	
	public void modifieCase(int x, int y, Color c){
		if(x>-1 && x<this.g.length && y>-1 && y<this.g[0].length) g[x][y] = c;
		this.p.repaint();
	}

	public void effaceCase(int x, int y){
		if(x>-1 && x<this.g.length && y>-1 && y<this.g[0].length) g[x][y] = this.background;
		this.p.repaint();
	}
	
	public int toucheTapee(){
		if(this.ke == null) return -1;
		else{
			int result = -1;
			if(this.ke.getKeyCode() == KeyEvent.VK_SPACE) result = 0;
			if(this.ke.getKeyCode() == KeyEvent.VK_RIGHT) result = 2;
			if(this.ke.getKeyCode() == KeyEvent.VK_LEFT) result = 1;
			if(this.ke.getKeyCode() == KeyEvent.VK_DOWN) result = 3;
			if(this.ke.getKeyCode() == KeyEvent.VK_UP) result = 4;
			if(this.ke.getKeyCode() == KeyEvent.VK_PAUSE) result = 5;
			this.ke = null;
			return result;
		}
	}
	
	/*public void refresh(){
		this.p.repaint();
	}*/
	
	private class Graphic extends JPanel{
		public void paint(Graphics gr){
			gr.setColor(background);
			gr.fillRect(0,0,this.getWidth(),this.getHeight());
			for(int i=0;i<g.length;i++){
				for(int j=0;j<g[i].length;j++){
					gr.setColor(g[i][j]);
					gr.fillRect(bordure+cell*i,bordure+cell*j,cell,cell);
				}
			}
		}
	}
	
	/** Affiche le message m dans une boite de dialogue. */
	public void afficheMessage(String m){
		JOptionPane.showMessageDialog(this,m);
	}
}