package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Player {

    private static Logger LOGGER = LogManager.getLogger(Player.class.getSimpleName());

    private int x, y; // Player position
    private int width, height; // Player dimensions
    private int speed = 5;
    private Image sprite;

    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        // Load the sprite image
        try {
            URL imageURL = getClass().getResource("/rabbit2.png");
            LOGGER.info("imageURL: {}", imageURL);
            sprite = ImageIO.read(imageURL);
        } catch (IOException e) {
            LOGGER.error("Failed to load image", e);
        }

        LOGGER.info("Loaded sprite image.");
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        LOGGER.info("Drawing player at {}, {}", x, y);
        g.drawImage(sprite, x, y, width, height, null);
    }

    public void moveUp() {
        LOGGER.debug("moveUp");
        y -= speed;
    }

    public void moveDown() {
        LOGGER.debug("moveDown");
        y += speed;
    }

    public void moveLeft() {
        LOGGER.debug("moveLeft");
        x -= speed;
    }

    public void moveRight() {
        LOGGER.debug("moveRight");
        x += speed;
    }
}