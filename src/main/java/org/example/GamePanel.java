package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {

    private static Logger LOGGER = LogManager.getLogger(GamePanel.class.getSimpleName());

    private Player player;

    public GamePanel(Player player) {
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        // Draw other entities and background
    }

}