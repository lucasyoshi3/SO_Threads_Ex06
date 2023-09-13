package controller;
import java.awt.Rectangle;
import java.util.Random;
import view.Corrida;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class CorridaThread extends Thread{
	private JLabel []carro=new JLabel[2];
	private JTextArea vencedor;
	private JTextArea perdedor;
	static String primeiro=null;
	private int i;
	
	public CorridaThread(JLabel carro,int i,JTextArea vencedor, JTextArea perdedor) {
		this.carro[i]=carro;
		this.i=i;
		this.vencedor=vencedor;
		this.perdedor=perdedor;
	}
	
	@Override
	public void run() {
		corrida();
		if(vencedor.getText().isEmpty()) {
			if(i==0) {
				vencedor.setText("carro1");
				perdedor.setText("carro2");
			}else {
				i++;
				vencedor.setText("carro2");
				perdedor.setText("carro1");
			}
		}
	}

	public void corrida() {
		Rectangle posicao=carro[i].getBounds();
		while(posicao.x<900) {
			posicao.x+=Math.random()*100+5;
			if(posicao.x>900) {
				posicao.x=900;
			}
			carro[i].setBounds(posicao);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
