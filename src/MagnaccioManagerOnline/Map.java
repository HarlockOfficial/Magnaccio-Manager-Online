package MagnaccioManagerOnline;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author HarlockOfficial
 */
public class Map extends JFrame{
    private static final long serialVersionUID = 8027136468271736752L;
    private JLabel pot,beccato,money,maria,notifiche, corriere,prostitute,notificheProstitute,velocita;
    private JButton corrompi,statistiche,contabilita,acquista,statisticheProstitute,contattiMafiosi,richiesteMafiosi,pausa,velocitaMeno,velocitaPiu;
    public Map(Network n) {
        super();
        setLayout(new GridLayout(2, 0));
        JPanel p1=new JPanel(new GridLayout(0, 2));
        JLabel tmp=new JLabel();
        tmp.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/Mappe/Citta.jpg")).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT)));
        p1.add(tmp);
        
        JPanel colonnaDx =new JPanel(new GridLayout(13, 0));
        
        JPanel tmpP=new JPanel(new GridLayout(0, 2));
        tmp=new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/fist.jpg")));
        tmpP.add(tmp);
        pot=new JLabel("Pot: 0.0");
        tmpP.add(pot);
        colonnaDx.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0, 2));
        tmp=new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/guardie.jpg")));
        tmpP.add(tmp);
        JPanel tmpP2=new JPanel(new GridLayout(0,2));
        beccato=new JLabel("0%");
        tmpP2.add(beccato);
        corrompi=new JButton("Corrompi");
        corrompi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        tmpP2.add(corrompi);
        tmpP.add(tmpP2);
        colonnaDx.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0, 2));
        tmp=new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/MONEY.jpg")));
        tmpP.add(tmp);
        money=new JLabel("3000€");
        tmpP.add(money);
        colonnaDx.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0, 2));
        tmp=new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/maria.jpg")));
        tmpP.add(tmp);
        maria=new JLabel("0g");
        tmpP.add(maria);
        colonnaDx.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0, 2));
        tmp=new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/fumo.jpg")));
        tmpP.add(tmp);
        maria=new JLabel("0g");
        tmpP.add(maria);
        colonnaDx.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0, 2));
        tmp=new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/lsd.jpg")));
        tmpP.add(tmp);
        maria=new JLabel("0g");
        tmpP.add(maria);
        colonnaDx.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0, 2));
        tmp=new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/coca.jpg")));
        tmpP.add(tmp);
        maria=new JLabel("0g");
        tmpP.add(maria);
        colonnaDx.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0, 2));
        tmp=new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/eroina.jpg")));
        tmpP.add(tmp);
        maria=new JLabel("0g");
        tmpP.add(maria);
        colonnaDx.add(tmpP);
        
        notifiche=new JLabel("");
        colonnaDx.add(notifiche);
        
        statistiche=new JButton("Statistiche");
        statistiche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        colonnaDx.add(statistiche);
        
        contabilita=new JButton("Contabilità");
        contabilita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        colonnaDx.add(contabilita);
        
        acquista=new JButton("Acquista");
        acquista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        colonnaDx.add(acquista);
        
        tmpP=new JPanel(new GridLayout(0, 3));
        corriere=new JLabel("Inattivo");
        tmp=new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/corriere.jpg")));
        tmpP.add(tmp);
        tmpP.add(new JLabel("Corriere:"));
        tmpP.add(corriere);
        colonnaDx.add(tmpP);
        p1.add(colonnaDx);
        add(p1);
        
        p1=new JPanel(new GridLayout(0,5));
        prostitute=new JLabel();
        prostitute.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/prostituta.jpg")).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
        p1.add(prostitute);
        
        tmpP=new JPanel(new GridLayout(3, 0));
        tmpP.add(new JLabel("Prostituzione:"));
        notificheProstitute=new JLabel("");
        tmpP.add(notificheProstitute);
        statisticheProstitute=new JButton("Statistiche Puttane");
        statisticheProstitute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        tmpP.add(statisticheProstitute);
        p1.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(2, 0));
        contattiMafiosi=new JButton("Contatti Mafiosi");
        contattiMafiosi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        tmpP.add(contattiMafiosi);
        richiesteMafiosi=new JButton("Richieste dei Mafiosi");
        richiesteMafiosi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        tmpP.add(richiesteMafiosi);
        p1.add(tmpP);
        
        pausa=new JButton("Pausa");
        pausa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        p1.add(pausa);
        
        tmpP=new JPanel(new GridLayout(2, 0));
        tmpP.add(new JLabel("Velocità:"));
        tmpP2=new JPanel(new GridLayout(0, 3));
        velocitaMeno=new JButton("-");
        velocitaMeno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        tmpP2.add(velocitaMeno);
        velocita=new JLabel("1");
        tmpP2.add(velocita);
        velocitaPiu=new JButton("+");
        velocitaPiu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        tmpP2.add(velocitaPiu);
        tmpP.add(tmpP2);
        p1.add(tmpP);
        add(p1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
