package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame implements KeyListener {

    private static Logger LOGGER = LogManager.getLogger(GameWindow.class.getSimpleName());

    // dimensions
    public static final int WIDTH = 400;
    public static final int HEIGHT = 240;
    public static final int SCALE = 3;

    private Timer timer;

    private Player player;

    private GamePanel gamePanel;
    
    public GameWindow() {

        setTitle("Grabbit Rabbit!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH*SCALE, HEIGHT*SCALE);
        setLocationRelativeTo(null);
        addKeyListener(this);
        setFocusable(true);

        player = new Player(50, 50, 50, 50);
        gamePanel = new GamePanel(player);
        add(gamePanel);

        timer = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gamePanel.repaint();
            }
        });

        timer.start();

        setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W:
                LOGGER.debug("calling moveUp");
                player.moveUp();
                break;
            case KeyEvent.VK_S:
                player.moveDown();
                break;
            case KeyEvent.VK_A:
                player.moveLeft();
                break;
            case KeyEvent.VK_D:
                player.moveRight();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
