package MagnaccioManagerOnline;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author HarlockOfficial
 */
public class Map extends JFrame /*implements Runnable */{

    private static final long serialVersionUID = 8027136468271736752L;
    private FinestraCorrompi finestraCorr = null;
    private FinestraAcquista finestraAcq=null;
    private JLabel pot, beccato, money, maria, fumo, coca, lsd, eroina, notifiche, corriere, prostitute, notificheProstitute;
    private JButton corrompi, statistiche, contabilita, acquista, statisticheProstitute, contattiMafiosi, richiesteMafiosi;
    private Network n;
    public Map(Network n) {
        super();
        this.n=n;
        setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        //mappa citta'
        JLabel tmp = new JLabel();
        tmp.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/Mappe/Citta.jpg")).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT)));
        c.fill=SwingConstants.NORTH_EAST;
        c.gridwidth=1;
        c.gridheight=1;
        c.gridx=0;
        c.gridy=0;
        add(tmp,c);
        //colonna DX
        JPanel colonnaDx = new JPanel(new GridLayout(13, 0));
        JPanel tmpP = new JPanel(new GridLayout(0, 2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/fist.jpg")));
        tmpP.add(tmp);
        pot = new JLabel("Pot: 0.0");
        tmpP.add(pot);
        colonnaDx.add(tmpP);

        tmpP = new JPanel(new GridLayout(0, 2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/guardie.jpg")));
        tmpP.add(tmp);
        JPanel tmpP2 = new JPanel(new GridLayout(0, 2));
        beccato = new JLabel("0%");
        tmpP2.add(beccato);
        corrompi = new JButton("Corrompi");
        corrompi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (finestraCorr == null) {
                    finestraCorr = new FinestraCorrompi(Map.this);
                } else {
                    finestraCorr.setVisible(true);
                }
            }
        });
        tmpP2.add(corrompi);
        tmpP.add(tmpP2);
        colonnaDx.add(tmpP);

        tmpP = new JPanel(new GridLayout(0, 2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/money.jpg")));
        tmpP.add(tmp);
        money = new JLabel("3000€");
        tmpP.add(money);
        colonnaDx.add(tmpP);

        tmpP = new JPanel(new GridLayout(0, 2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/maria.jpg")));
        tmpP.add(tmp);
        maria = new JLabel("0g");
        tmpP.add(maria);
        colonnaDx.add(tmpP);

        tmpP = new JPanel(new GridLayout(0, 2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/fumo.jpg")));
        tmpP.add(tmp);
        fumo = new JLabel("0g");
        tmpP.add(fumo);
        colonnaDx.add(tmpP);

        tmpP = new JPanel(new GridLayout(0, 2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/lsd.jpg")));
        tmpP.add(tmp);
        lsd = new JLabel("0g");
        tmpP.add(lsd);
        colonnaDx.add(tmpP);

        tmpP = new JPanel(new GridLayout(0, 2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/coca.jpg")));
        tmpP.add(tmp);
        coca = new JLabel("0g");
        tmpP.add(coca);
        colonnaDx.add(tmpP);

        tmpP = new JPanel(new GridLayout(0, 2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/eroina.jpg")));
        tmpP.add(tmp);
        eroina = new JLabel("0g");
        tmpP.add(eroina);
        colonnaDx.add(tmpP);

        notifiche = new JLabel("");
        colonnaDx.add(notifiche);

        statistiche = new JButton("Statistiche");
        statistiche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        colonnaDx.add(statistiche);

        contabilita = new JButton("Contabilità");
        contabilita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        colonnaDx.add(contabilita);

        acquista = new JButton("Acquista");
        acquista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(finestraAcq==null){
                    finestraAcq=new FinestraAcquista(Map.this);
                }else{
                    finestraAcq.setVisible(true);
                }
            }
        });
        colonnaDx.add(acquista);

        tmpP = new JPanel(new GridLayout(0, 3));
        corriere = new JLabel("Inattivo");
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/corriere.jpg")));
        tmpP.add(tmp);
        tmpP.add(new JLabel("Corriere:"));
        tmpP.add(corriere);
        colonnaDx.add(tmpP);
        
        c.fill=SwingConstants.NORTH_WEST;
        c.gridx=1;
        c.gridy=0;
        add(colonnaDx,c);
        
        //menu sotto
        JPanel p1 = new JPanel(new GridLayout(0, 3));
        prostitute = new JLabel();
        prostitute.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/prostituta.jpg")).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
        p1.add(prostitute);

        tmpP = new JPanel(new GridLayout(3, 0));
        tmp=new JLabel("Prostituzione:");
        tmpP.add(tmp);
        notificheProstitute = new JLabel("");
        tmpP.add(notificheProstitute);
        statisticheProstitute = new JButton("Statistiche Puttane");
        statisticheProstitute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        tmpP.add(statisticheProstitute);
        p1.add(tmpP);

        tmpP = new JPanel(new GridLayout(2, 0));
        contattiMafiosi = new JButton("Contatti Mafiosi");
        contattiMafiosi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        tmpP.add(contattiMafiosi);
        richiesteMafiosi = new JButton("Richieste dei Mafiosi");
        richiesteMafiosi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        tmpP.add(richiesteMafiosi);
        p1.add(tmpP);
        c.fill=SwingConstants.CENTER;
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=2;
        add(p1,c);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        //new Thread(this).start();
        setVisible(true);
    }

    public void setMoney(String soldi) {
        money.setText(soldi);
    }
    public void setBeccato(String txt){
        beccato.setText(txt);
    }
    /*public void run() {
        boolean run=true;
        while (run) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {

            }
        }
    System.exit(0);
    }*/

    public JLabel getBeccato() {
        return beccato;
    }

    public JLabel getMoney() {
        return money;
    }
    public synchronized void scrivi(String str){
        n.scrivi(str);
        try{
            Thread.sleep(500);
        }catch(InterruptedException ex){}
    }
    public synchronized String leggi(){
        String s=n.leggi();
        while(s==null || s.equals("")){
            try{
                Thread.sleep(500);
            }catch(InterruptedException ex){}
            s=n.leggi();
        }
        return s;
    }
    public void setMaria(String str){
        maria.setText(str+"g");
    }
    public void setFumo(String str){
        fumo.setText(str+"g");
    }
    public void setLsd(String str){
        lsd.setText(str+"g");
    }
    public void setCoca(String str){
        coca.setText(str+"g");
    }
    public void setEroina(String str){
        eroina.setText(str+"g");
    }
    public JLabel getMaria() {
        return maria;
    }
    public JLabel getFumo() {
        return fumo;
    }
    public JLabel getLsd() {
        return lsd;
    }
    public JLabel getCoca() {
        return coca;
    }
    public JLabel getEroina() {
        return eroina;
    }
    
}
