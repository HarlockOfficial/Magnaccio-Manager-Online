package MagnaccioManagerOnline;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author HarlockOfficial
 */
public class FinestraAcquista extends JFrame{
    private Map M;
    private JPanel nazione, sostanza, corriere;
    private JButton avviaSpedizione;
    private JLabel localita,maria,fumo,lsd,coca,eroina,viaggio,rischio,paginaLuogo,
            quantitaMaria,quantitaFumo,quantitaLsd,quantitaCoca,quantitaEroina,
            paginaCorriere,imgCorriere,nomeCorriere,qualitaCorriere,ingaggioCorriere,statoCorriere,
            spesaTotale,money;
    private boolean[] status;
    private boolean go=true;
    public FinestraAcquista(final Map m) {
        super("Drug Market");
        this.M=m;
        setPreferredSize(new Dimension(700, 400));
        setLayout(new GridLayout(0, 3));
        nazione=new JPanel(new GridLayout(10, 0));
        paginaLuogo=new JLabel("1");
        nazione.add(new JLabel("Localita"));
        M.scrivi("localitaList;"+paginaLuogo.getText());
        String res=M.leggi();
        String[] data=res.split(";");
        /*
        8 elem
        -------------------------
        0-x localita
        1-x costo maria
        2-x costo fumo
        3-x costo lsd
        4-x costo coca
        5-x costo eroina
        6-x costo viaggio
        7-x percentuale rischio
        */
        localita=new JLabel(data[0]);
        nazione.add(localita);
        JPanel tmpP=new JPanel(new GridLayout(0,2));
        JLabel tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/maria.jpg")));
        tmpP.add(tmp);
        maria=new JLabel(data[1]);
        tmpP.add(maria);
        nazione.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0,2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/fumo.jpg")));
        tmpP.add(tmp);
        fumo=new JLabel(data[2]);
        tmpP.add(fumo);
        nazione.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0,2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/lsd.jpg")));
        tmpP.add(tmp);
        lsd=new JLabel(data[3]);
        tmpP.add(lsd);
        nazione.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0,2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/coca.jpg")));
        tmpP.add(tmp);
        coca=new JLabel(data[4]);
        tmpP.add(coca);
        nazione.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0,2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/eroina.jpg")));
        tmpP.add(tmp);
        eroina=new JLabel(data[5]);
        tmpP.add(eroina);
        nazione.add(tmpP);
        
        viaggio=new JLabel("Costo Viaggio: "+data[6]);
        nazione.add(viaggio);
        
        rischio=new JLabel("Rischio: "+data[7]+"%");
        nazione.add(rischio);
        
        tmpP=new JPanel(new GridLayout(0, 3));
        JButton tmpB=new JButton("-");
        tmpB.addActionListener((ActionEvent e) -> {
            if((Integer.parseInt(paginaLuogo.getText())-1)>0){
                paginaLuogo.setText(""+(Integer.parseInt(paginaLuogo.getText())-1));
                new Thread(() -> {
                    M.scrivi("localitaList;"+paginaLuogo.getText());
                    String result=M.leggi();
                    String[] dati=result.split(";");
                    localita.setText(dati[0]);
                    maria.setText(dati[1]);
                    fumo.setText(dati[2]);
                    lsd.setText(dati[3]);
                    coca.setText(dati[4]);
                    eroina.setText(dati[5]);
                    viaggio.setText("Costo Viaggio: "+dati[6]);
                    rischio.setText("Rischio: "+dati[7]+"%");
                }).start();
            }
        });
        tmpP.add(tmpB);
        tmpP.add(paginaLuogo);
        tmpB=new JButton("+");
        tmpB.addActionListener((ActionEvent e) -> {
            if((Integer.parseInt(paginaLuogo.getText())+1)<=8){
                paginaLuogo.setText(""+(Integer.parseInt(paginaLuogo.getText())+1));
                new Thread(() -> {
                    M.scrivi("localitaList;"+paginaLuogo.getText());
                    String result=M.leggi();
                    String[] dati=result.split(";");
                    localita.setText(dati[0]);
                    maria.setText(dati[1]);
                    fumo.setText(dati[2]);
                    lsd.setText(dati[3]);
                    coca.setText(dati[4]);
                    eroina.setText(dati[5]);
                    viaggio.setText("Costo Viaggio: "+dati[6]);
                    rischio.setText("Rischio: "+dati[7]+"%");
                }).start();
            }
        });
        tmpP.add(tmpB);
        nazione.add(tmpP);
        add(nazione);
        
        sostanza=new JPanel(new GridLayout(8, 0));
        sostanza.add(new JLabel("Quantita"));
        String[] choices = {"1", "10", "100", "1000", "5000", "10000"};
        final JComboBox<String> cb = new JComboBox<>(choices);
        sostanza.add(cb);
        tmpP=new JPanel(new GridLayout(0,4));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/maria.jpg")));
        tmpP.add(tmp);
        tmpB=new JButton("-");
        tmpB.addActionListener((ActionEvent e) -> {
            int grams=Integer.parseInt(quantitaMaria.getText().substring(0, quantitaMaria.getText().length()-1));
            if(grams-Integer.parseInt((String)cb.getSelectedItem())<0){
                return;
            }
            quantitaMaria.setText(""+(grams-Integer.parseInt((String)cb.getSelectedItem()))+"g");
        });
        tmpP.add(tmpB);
        quantitaMaria=new JLabel("0g");
        tmpP.add(quantitaMaria);
        tmpB=new JButton("+");
        tmpB.addActionListener((ActionEvent e) -> {
            int grams=Integer.parseInt(quantitaMaria.getText().substring(0, quantitaMaria.getText().length()-1));
            quantitaMaria.setText(""+(grams+Integer.parseInt((String)cb.getSelectedItem()))+"g");
        });
        tmpP.add(tmpB);
        sostanza.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0,4));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/fumo.jpg")));
        tmpP.add(tmp);
        tmpB=new JButton("-");
        tmpB.addActionListener((ActionEvent e) -> {
            int grams=Integer.parseInt(quantitaFumo.getText().substring(0, quantitaFumo.getText().length()-1));
            if(grams-Integer.parseInt((String)cb.getSelectedItem())<0){
                return;
            }
            quantitaFumo.setText(""+(grams-Integer.parseInt((String)cb.getSelectedItem()))+"g");
        });
        tmpP.add(tmpB);
        quantitaFumo=new JLabel("0g");
        tmpP.add(quantitaFumo);
        tmpB=new JButton("+");
        tmpB.addActionListener((ActionEvent e) -> {
            int grams=Integer.parseInt(quantitaFumo.getText().substring(0, quantitaFumo.getText().length()-1));
            quantitaFumo.setText(""+(grams+Integer.parseInt((String)cb.getSelectedItem()))+"g");
        });
        tmpP.add(tmpB);
        sostanza.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0,4));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/lsd.jpg")));
        tmpP.add(tmp);
        tmpB=new JButton("-");
        tmpB.addActionListener((ActionEvent e) -> {
            int grams=Integer.parseInt(quantitaLsd.getText().substring(0, quantitaLsd.getText().length()-1));
            if(grams-Integer.parseInt((String)cb.getSelectedItem())<0){
                return;
            }
            quantitaLsd.setText(""+(grams-Integer.parseInt((String)cb.getSelectedItem()))+"g");
        });
        tmpP.add(tmpB);
        quantitaLsd=new JLabel("0g");
        tmpP.add(quantitaLsd);
        tmpB=new JButton("+");
        tmpB.addActionListener((ActionEvent e) -> {
            int grams=Integer.parseInt(quantitaLsd.getText().substring(0, quantitaLsd.getText().length()-1));
            quantitaLsd.setText(""+(grams+Integer.parseInt((String)cb.getSelectedItem()))+"g");
        });
        tmpP.add(tmpB);
        sostanza.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0,4));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/coca.jpg")));
        tmpP.add(tmp);
        tmpB=new JButton("-");
        tmpB.addActionListener((ActionEvent e) -> {
            int grams=Integer.parseInt(quantitaCoca.getText().substring(0, quantitaCoca.getText().length()-1));
            if(grams-Integer.parseInt((String)cb.getSelectedItem())<0){
                return;
            }
            quantitaCoca.setText(""+(grams-Integer.parseInt((String)cb.getSelectedItem()))+"g");
        });
        tmpP.add(tmpB);
        quantitaCoca=new JLabel("0g");
        tmpP.add(quantitaCoca);
        tmpB=new JButton("+");
        tmpB.addActionListener((ActionEvent e) -> {
            int grams=Integer.parseInt(quantitaCoca.getText().substring(0, quantitaCoca.getText().length()-1));
            quantitaCoca.setText(""+(grams+Integer.parseInt((String)cb.getSelectedItem()))+"g");
        });
        tmpP.add(tmpB);
        sostanza.add(tmpP);
        
        tmpP=new JPanel(new GridLayout(0,4));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/droghe/eroina.jpg")));
        tmpP.add(tmp);
        tmpB=new JButton("-");
        tmpB.addActionListener((ActionEvent e) -> {
            int grams=Integer.parseInt(quantitaEroina.getText().substring(0, quantitaEroina.getText().length()-1));
            if(grams-Integer.parseInt((String)cb.getSelectedItem())<0){
                return;
            }
            quantitaEroina.setText(""+(grams-Integer.parseInt((String)cb.getSelectedItem()))+"g");
        });
        tmpP.add(tmpB);
        quantitaEroina=new JLabel("0g");
        tmpP.add(quantitaEroina);
        tmpB=new JButton("+");
        tmpB.addActionListener((ActionEvent e) -> {
            int grams=Integer.parseInt(quantitaEroina.getText().substring(0, quantitaEroina.getText().length()-1));
            quantitaEroina.setText(""+(grams+Integer.parseInt((String)cb.getSelectedItem()))+"g");
        });
        tmpP.add(tmpB);
        sostanza.add(tmpP);
        
        add(sostanza);
        corriere=new JPanel(new GridLayout(10, 0));
        corriere.add(new JLabel("Corriere"));
        paginaCorriere=new JLabel("1");
        M.scrivi("corriereList;"+paginaCorriere.getText());
        res=M.leggi();
        data=res.split(";");
        /*
        4 dati
        --------------
        0 nome
        1 qualita
        2 ingaggio
        */
        tmpP=new JPanel(new GridLayout(0, 2));
        imgCorriere = new JLabel();
        //imgCorriere.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/Personaggi/corrieri/"+data[0]+".jpg")));
        tmpP.add(imgCorriere);
        nomeCorriere=new JLabel(data[0]);
        tmpP.add(nomeCorriere);
        corriere.add(tmpP);
        qualitaCorriere=new JLabel("Qualita: "+data[1]);
        corriere.add(qualitaCorriere);
        ingaggioCorriere=new JLabel("Ingaggio: "+data[2]+"%");
        corriere.add(ingaggioCorriere);
        status=new boolean[8];
        for(int i=0;i<8;i++){
            status[i]=true;
        }
        statoCorriere=new JLabel("Stato: "+(status[(Integer.parseInt(paginaCorriere.getText())-1)]?"Disponibile":"Non Disponibile"));
        corriere.add(statoCorriere);
        tmpP=new JPanel(new GridLayout(0, 3));
        tmpB=new JButton("-");
        tmpB.addActionListener((ActionEvent e) -> {
            if((Integer.parseInt(paginaCorriere.getText())-1)>0){
                paginaCorriere.setText(""+(Integer.parseInt(paginaCorriere.getText())-1));
                new Thread(() -> {
                    M.scrivi("corriereList;"+paginaCorriere.getText());
                    String result=M.leggi();
                    String[] dati=result.split(";");
                    //imgCorriere.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/Personaggi/corrieri/"+dati[0]+".jpg")));
                    nomeCorriere.setText(dati[0]);
                    qualitaCorriere.setText("Qualita: "+dati[1]);
                    ingaggioCorriere.setText("Ingaggio: "+dati[2]+"%");
                    statoCorriere.setText("Stato: "+(status[(Integer.parseInt(paginaCorriere.getText())-1)]?"Disponibile":"Non Disponibile"));
                }).start();
            }
        });
        tmpP.add(tmpB);
        tmpP.add(paginaCorriere);
        tmpB=new JButton("+");
        tmpB.addActionListener((ActionEvent e) -> {
            if((Integer.parseInt(paginaCorriere.getText())+1)<9){
                paginaCorriere.setText(""+(Integer.parseInt(paginaCorriere.getText())+1));
                new Thread(() -> {
                    M.scrivi("corriereList;"+paginaCorriere.getText());
                    String result=M.leggi();
                    String[] dati=result.split(";");
                    //imgCorriere.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/Personaggi/corrieri/"+dati[0]+".jpg")));
                    nomeCorriere.setText(dati[0]);
                    qualitaCorriere.setText("Qualita: "+dati[1]);
                    ingaggioCorriere.setText("Ingaggio: "+dati[2]+"%");
                    statoCorriere.setText("Stato: "+(status[(Integer.parseInt(paginaCorriere.getText())-1)]?"Disponibile":"In Arresto"));
                }).start();
            }
        });
        tmpP.add(tmpB);
        corriere.add(tmpP);
        corriere.add(new JLabel(""));
        spesaTotale=new JLabel("Costo: 0€");
        corriere.add(spesaTotale);
        tmpP = new JPanel(new GridLayout(0, 2));
        tmp = new JLabel();
        tmp.setIcon(new ImageIcon(getClass().getResource("/MagnaccioManagerOnline/img/icone/money.jpg")));
        tmpP.add(tmp);
        money = new JLabel(M.getMoney().getText());
        tmpP.add(money);
        corriere.add(tmpP);
        avviaSpedizione=new JButton("Avvia Spedizione");
        avviaSpedizione.addActionListener((ActionEvent e) -> {
            avviaSpedizione.setEnabled(false);
            if(status[Integer.parseInt(paginaCorriere.getText())] && Integer.parseInt(money.getText().substring(0,money.getText().length()-1))-Integer.parseInt(spesaTotale.getText().substring(0,spesaTotale.getText().length()-1))>=0){
                M.scrivi("spedizioneStart;"+spesaTotale.getText().substring(0,spesaTotale.getText().length()-1)+";"+rischio.getText().substring(9,rischio.getText().length()-1)+";"+qualitaCorriere.getText().substring(9));
                JOptionPane.showMessageDialog(null, "Spedizione Avviata","Spedizione",JOptionPane.INFORMATION_MESSAGE);
                M.setMoney((Integer.parseInt(money.getText().substring(0,money.getText().length()-1))-Integer.parseInt(spesaTotale.getText().substring(0, spesaTotale.getText().length()-1)))+"€");
                status[Integer.parseInt(paginaCorriere.getText())]=false;
                statoCorriere.setText("Non Disponibile");
                String result=M.leggi();
                if(result.equals("spedizione;Ok")){
                    JOptionPane.showMessageDialog(null, "La Spedizione è andata a buon fine", "Spedizione", JOptionPane.INFORMATION_MESSAGE);
                    status[Integer.parseInt(paginaCorriere.getText())]=true;
                    M.setMaria((Integer.parseInt(M.getMaria().getText().substring(0,M.getMaria().getText().length()-1))+Integer.parseInt(quantitaMaria.getText().substring(0,quantitaMaria.getText().length()-1)))+"");
                    M.setFumo((Integer.parseInt(M.getFumo().getText().substring(0,M.getFumo().getText().length()-1))+Integer.parseInt(quantitaFumo.getText().substring(0,quantitaFumo.getText().length()-1)))+"");
                    M.setLsd((Integer.parseInt(M.getLsd().getText().substring(0,M.getLsd().getText().length()-1))+Integer.parseInt(quantitaLsd.getText().substring(0,quantitaLsd.getText().length()-1)))+"");
                    M.setCoca((Integer.parseInt(M.getCoca().getText().substring(0,M.getCoca().getText().length()-1))+Integer.parseInt(quantitaCoca.getText().substring(0,quantitaCoca.getText().length()-1)))+"");
                    M.setEroina((Integer.parseInt(M.getEroina().getText().substring(0,M.getEroina().getText().length()-1))+Integer.parseInt(quantitaEroina.getText().substring(0,quantitaEroina.getText().length()-1)))+"");
                    avviaSpedizione.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "La Spedizione NON è andata a buon fine", "Spedizione", JOptionPane.ERROR_MESSAGE);
                    M.setBeccato((Double.parseDouble(M.getBeccato().getText().substring(0, M.getBeccato().getText().length()-1))+Double.parseDouble(result.split(";")[1]))+"%");
                    avviaSpedizione.setEnabled(true);
                    new Thread(() -> {
                        try{
                            Thread.sleep(new Random().nextInt(5)*60*1000);
                            status[Integer.parseInt(paginaCorriere.getText())]=true;
                        }catch(InterruptedException ex){}
                    }).start();
                }
                setVisible(false);
            }
        });
        corriere.add(avviaSpedizione);
        add(corriere);
        pack();
        setLocationRelativeTo(null);
        new Thread(() -> {
            while(go){
                money.setText(M.getMoney().getText());
                int somma=0;
                somma+=Integer.parseInt(maria.getText())*Integer.parseInt(quantitaMaria.getText().substring(0,quantitaMaria.getText().length()-1));
                somma+=Integer.parseInt(fumo.getText())*Integer.parseInt(quantitaFumo.getText().substring(0,quantitaFumo.getText().length()-1));
                somma+=Integer.parseInt(lsd.getText())*Integer.parseInt(quantitaLsd.getText().substring(0,quantitaLsd.getText().length()-1));
                somma+=Integer.parseInt(coca.getText())*Integer.parseInt(quantitaCoca.getText().substring(0,quantitaCoca.getText().length()-1));
                somma+=Integer.parseInt(eroina.getText())*Integer.parseInt(quantitaEroina.getText().substring(0,quantitaEroina.getText().length()-1));
                somma+=Integer.parseInt(viaggio.getText().substring(15));
                somma+=(somma*(Integer.parseInt(ingaggioCorriere.getText().substring(10,ingaggioCorriere.getText().length()-1))/100.0));
                spesaTotale.setText(somma+"€");
                try{
                    Thread.sleep(10);
                }catch(InterruptedException ex){}
            }
        }).start();
        setVisible(true);
    }
}
