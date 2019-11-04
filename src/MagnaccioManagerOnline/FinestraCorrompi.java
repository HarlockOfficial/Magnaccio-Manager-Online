package MagnaccioManagerOnline;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinestraCorrompi extends JFrame implements Runnable{
	private static final long serialVersionUID = 2286014442775280732L;
	private JLabel money;
	private Map M;
	public FinestraCorrompi(JLabel beccato, JLabel Money, Map M) {
		super("Corrompi");
		this.M=M;
		money=Money;
		setPreferredSize(new Dimension(250,200));
		setLayout(new GridLayout(6,0));
		JPanel tmpP = new JPanel (new GridLayout(0,2));
		JLabel tmp=new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/guardie.jpg")));
        tmpP.add(tmp);
        tmpP.add(beccato);
        add(tmpP);
        tmpP = new JPanel (new GridLayout(0,2));
        tmp=new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/money.jpg")));
        tmpP.add(tmp);
        tmpP.add(money);
        add(tmpP);
        String[] choices = { "1","10", "100","1000","5000","10000"};
        JComboBox<String> cb = new JComboBox<String>(choices);
        add(cb);
        add(new JLabel("Proposta:"));
        tmpP = new JPanel (new GridLayout(0,3));
        JButton btnP=new JButton("+");
        JButton btnM= new JButton("-");
        JLabel valore = new JLabel("0€");
        btnP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				valore.setText(""+(Integer.parseInt(valore.getText().substring(0, valore.getText().length()-1))+Integer.parseInt(cb.getSelectedItem().toString()))+"€");
			}
		});
        btnM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((Integer.parseInt(valore.getText().substring(0, valore.getText().length()-1))-Integer.parseInt(cb.getSelectedItem().toString()))>=0)
					valore.setText(""+(Integer.parseInt(valore.getText().substring(0, valore.getText().length()-1))-Integer.parseInt(cb.getSelectedItem().toString()))+"€");
			}
		});
        tmpP.add(btnM);
        tmpP.add(valore);
        tmpP.add(btnP);
        add(tmpP);
        JButton btnPaga = new JButton("PAGA");
        btnPaga.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(M.getMoney().substring(0,M.getMoney().length()-1))>=Integer.parseInt(valore.getText().substring(0,valore.getText().length()-1)))
				{
					M.setMoney((Integer.parseInt(M.getMoney().substring(0,M.getMoney().length()-1))-Integer.parseInt(valore.getText().substring(0,valore.getText().length()-1)))+"€");
				}
			}
		});
        add(btnPaga);
        pack();
        setLocationRelativeTo(null);
        new Thread(this).start();
        setVisible(true);
        
	}

	@Override
	public void run() {
		while(true)
		{
			try
			{
				Thread.sleep(10);
				money.setText(M.getMoney());
			}catch(InterruptedException ex) {
				
			}
		}
		
	}
}