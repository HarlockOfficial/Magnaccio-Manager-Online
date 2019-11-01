package MagnaccioManagerOnline;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Network extends Thread{
    BufferedOutputStream out;
    BufferedReader in;
    Socket s;
    public Network() {
        super();
        firstConnection();
    }
    @Override
    public void run() {
        try{
            while(s.isConnected()){
                Thread.sleep(10);
            }
        }catch(InterruptedException ex){
        }
    }
    public void scrivi(String str){
        try{
            out.write((str+"\n").getBytes());
        }catch(IOException ex){
            if(s.isConnected() && out!=null)
                scrivi(str);
            else
                System.exit(0);
        }
    }
    public String leggi(){
        try{
            return in.readLine();
        }catch(IOException ex){
            return "";
        }
    }
    private void firstConnection() {
        final JFrame frame=new JFrame("Connessione al server");
        frame.setLayout(new GridLayout(3,2));
        frame.add(new JLabel("Inserisci l'indirizzo del server"));
        final JTextField url=new JTextField();
        frame.add(url);
        frame.add(new JLabel("Inserisci la porta del server"));
        final JTextField port=new JTextField();
        frame.add(port);
        JButton ok=new JButton("Conferma");
        frame.add(ok);
        JButton exit=new JButton("Exit");
        frame.add(exit);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(url.getText()!=null && !url.getText().equals("") && port.getText()!=null && !port.getText().equals(""))
                    try {
                        s=new Socket(url.getText(),Integer.parseInt(port.getText()));
                        out=new BufferedOutputStream(s.getOutputStream());
                        in=new BufferedReader(new InputStreamReader(s.getInputStream()));
                        frame.setVisible(false);
                        String str = leggi();
                        s=new Socket(url.getText(),Integer.parseInt(str));
                        out=new BufferedOutputStream(s.getOutputStream());
                        in=new BufferedReader(new InputStreamReader(s.getInputStream()));
                } catch (UnknownHostException ex) {
                    frame.setVisible(true);
                    url.setText("");
                    port.setText("");
                } catch (NumberFormatException ex){
                    frame.setVisible(true);
                    port.setText("");
                } catch (IOException ex){
                    frame.setVisible(true);
                    url.setText("");
                    port.setText("");
                }
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void go() {
        try{
            while(s==null){
                Thread.sleep(10);
            }
            while(!s.isConnected()){
                Thread.sleep(10);
            }
            this.start();
        }catch(InterruptedException ex){
        }
    }
}
