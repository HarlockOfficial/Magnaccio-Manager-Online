/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MagnaccioManagerOnline;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class FinestraContabilita extends JFrame implements Runnable{
    private Map M;
    private JLabel money;
    private boolean go=true;
    public FinestraContabilita(Map map) {
        super("Libro Contabile");
        M=map;
        setLayout(new GridLayout(7,6));
        add(new JLabel("Giacenza"));
        add(new JLabel("Costi"));
        add(new JLabel("Prezzi"));
        add(new JLabel("Nelle"));
        add(new JLabel("Varie"));
        add(new JLabel("Zone"));
        //-------------------------
        money=new JLabel(M.getMoney().getText());
        add(money);
        add(new JLabel("Prezzi medi d'acquisto"));
        add(new JLabel("Zona Portuale"));
        add(new JLabel("Città Est"));
        add(new JLabel("Città Centro"));
        add(new JLabel("Campagna"));
        add(new JLabel("Costi"));
        //-------------------------
        //erba
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        //-------------------------
        //fumo
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        //-------------------------
        //lsd
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        //-------------------------
        //coca
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        //-------------------------
        //eroina
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        //-------------------------
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(go){
            try{
                money.setText(M.getMoney().getText());
                Thread.sleep(100);
            }catch(InterruptedException ignored){}
        }
    }
    public void close(){
        go=false;
        M=null;
        removeAll();
        setVisible(false);
    }
}
