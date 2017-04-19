package TiJavaTest;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by chenjie on 16/10/28.
 */

class SeparateSubTask extends Thread {
    private int count = 0;
    private Applet1 c2;
    private boolean runFlag = true;
    public SeparateSubTask(Applet1 c2) {
        this.c2 = c2;
        start();
    }
    public void invertFlag() { runFlag = !runFlag;}
    public void run() {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e){}
            if(runFlag)
                c2.t.setText(Integer.toString(count++));
        }
    }
}

public class Applet1 extends Applet {
    TextField t = new TextField(10);
    private SeparateSubTask sp = null;
    private Button
            onOff = new Button("Toggle"),
            start = new Button("Start");
    public void init() {
        add(t);
        start.addActionListener(new StartL());
        add(start);
        onOff.addActionListener(new OnOffL());
        add(onOff);
    }
    class StartL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(sp == null)
                sp = new SeparateSubTask(Applet1.this);
        }
    }
    class OnOffL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(sp != null)
                sp.invertFlag();
        }
    }
    public static void main(String[] args) {
        Applet1 applet = new Applet1();
        Frame aFrame = new Frame("Counter2");
        aFrame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
        aFrame.add(applet, BorderLayout.CENTER);
        aFrame.setSize(300,200);
        applet.init();
        applet.start();
        aFrame.setVisible(true);
    }
}