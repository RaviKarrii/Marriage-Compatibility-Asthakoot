package Virgo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Window {
    private JPanel Main;
    private JTabbedPane MainTab;
    private JPanel Inputs;
    private JPanel Calculation;
    private JEditorPane Details;
    private JButton Generate;
    private JPanel GirlDet;
    private JPanel BoyDet;
    private JTextField BName;
    private JTextField GName;
    private JTextField BBD;
    private JTextField BBT;
    private JTextField GBD;
    private JTextField GBT;
    private JTextField BLat;
    private JTextField BLon;
    private JTextField GLat;
    private JTextField GLon;

    public Main_Window() {
        Generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Horoscope Boy = new Horoscope(BName.getText(),BBD.getText(),BBT.getText(),BLat.getText(),BLon.getText());
                Horoscope Girl = new Horoscope(GName.getText(),GBD.getText(),GBT.getText(),GLat.getText(),GLon.getText());
                Boy.process();
                Girl.process();
                System.out.println(Boy.planetlist.get(1).Nakshatra);
                Astakoot koot = new Astakoot(Integer.parseInt(Boy.planetlist.get(1).Nakshatra),Integer.parseInt(Girl.planetlist.get(1).Nakshatra));
                int a = koot.calcDinaKuta();
                a = koot.calcGanaKuta();

            }
        });
    }

    public static void main(String[] args) {
        Main_Window mainWin = new Main_Window();
        JFrame Frame = new JFrame("Virgo");
        Frame.setContentPane(mainWin.Main);
        Frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        Frame.setVisible(true);
        mainWin.BName.setText("Ravi");
        mainWin.GName.setText("Teja");
        mainWin.BBD.setText("30/08/2019");
        mainWin.GBD.setText("30/08/2019");
        mainWin.BBT.setText("18:52:39");
        mainWin.GBT.setText("18:52:39");
        mainWin.BLat.setText("17.385044");
        mainWin.GLat.setText("17.385044");
        mainWin.BLon.setText("78.486671");
        mainWin.GLon.setText("78.486671");
    }

}
