package de.lebk.songdb.gui;

import de.lebk.songdb.data_store.DataStore;
import de.lebk.songdb.song.Song;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author sopaetzel
 */
public class SongUI {
    private static JFrame frame;
    private static JPanel container;

    private JTextField txtfSong;
    private JTextField txtfSinger;
    private JButton btnSearchSong;
    private JButton btnSaveSong;
    private JButton btnBack;
    private JButton btnForward;
    private JPanel pnlFrame;
    private JLabel lblSong;
    private JLabel lblSinger;


    public static void main(String[] args){
        setLookAndFeel();
        frame = new JFrame("Meine kleine Musik-Datenbank");
        container = new SongUI().pnlFrame;
        container.setBorder(new EmptyBorder(5, 5, 2, 2));

        frame.setContentPane(container);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);


    }


    private void initActionListener(){
        btnSearchSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Song song =  DataStore.getInstance().getSongByTitle(txtfSong.getText());
               txtfSinger.setText(song.getSinger());
            }
        });


        btnSaveSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String song = txtfSong.getText();
                String singer = txtfSinger.getText();

            }
        });

    }






    private static void setLookAndFeel(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }


}


