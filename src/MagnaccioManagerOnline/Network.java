package MagnaccioManagerOnline;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * @author HarlockOfficial
 */
public class Network extends Thread {
    private PrintWriter out;
    private BufferedReader in;
    private Socket s;
    private boolean go=false;
    public Network() {
        super();
        firstConnection();
    }

    @Override
    public void run() {
        try {
            while (s.isConnected()) {
                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {
        }
    }

    public synchronized void scrivi(String str) {
        out.println(str);
    }

    public synchronized String leggi() {
        try {
            String s=null;
            do{
                s=in.readLine();
            }while((s==null || s.equals("")));
            return s;
        } catch (IOException ex) {
            return null;
        }
    }

    private void firstConnection() {
        final JFrame frame = new JFrame("Connessione al server");
        frame.setLayout(new GridLayout(3, 2));
        frame.add(new JLabel("Inserisci l'indirizzo del server"));
        final JTextField url = new JTextField();
        frame.add(url);
        frame.add(new JLabel("Inserisci la porta del server"));
        final JTextField port = new JTextField();
        frame.add(port);
        JButton ok = new JButton("Conferma");
        frame.add(ok);
        JButton exit = new JButton("Exit");
        frame.add(exit);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (url.getText() != null && !url.getText().equals("") && port.getText() != null && !port.getText().equals("")) {
                    try {
                        s = new Socket(url.getText(), Integer.parseInt(port.getText()));
                        frame.setVisible(false);
                        out=new PrintWriter(s.getOutputStream(),true);
                        in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
                        Thread.sleep(5000);
                        String str=in.readLine();
                        out.println("got");
                        s = new Socket(url.getText(), Integer.parseInt(str));
                        out = new PrintWriter(s.getOutputStream(), true);
                        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        go=true;
                    } catch (UnknownHostException ex) {
                        frame.setVisible(true);
                        url.setText("");
                        port.setText("");
                    } catch (NumberFormatException ex) {
                        frame.setVisible(true);
                        port.setText("");
                    } catch (IOException ex) {
                        frame.setVisible(true);
                        url.setText("");
                        port.setText("");
                    } catch(InterruptedException ex){
                        
                    }
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
        try {
            while (!go) {
                Thread.sleep(10);
            }
            this.start();
        } catch (InterruptedException ex) {
        }
    }
    public void close(){
        try{
            s.close();
            in.close();
            out.close();
        }catch(IOException ignored){}
    }
}
