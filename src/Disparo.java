package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Disparo {
    private int dano, velocidade, cooldown, x, y;
    private Image sprite;

    public Disparo(int dano, int velocidade, int cooldown, String spritePath, Nave atirador) {
        this.dano = dano;
        this.velocidade = velocidade;
        this.cooldown = cooldown;

        x = atirador.getX() + atirador.getWidth() / 2;
        y = atirador.getY() + atirador.getHeight() / 2;

        try {
            sprite = ImageIO.read(new File(spritePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Disparo(int dano, int velocidade, int cooldown, Nave atirador) {
        this.dano = dano;
        this.velocidade = velocidade;
        this.cooldown = cooldown;

        x = atirador.getX() + atirador.getWidth() / 2 - 4;
        y = atirador.getY() + atirador.getHeight() / 2 - 30;

        try {
            sprite = ImageIO.read(new File("C:\\Users\\mathe\\Downloads\\SpaceInvaders\\assets\\TiroPlayer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return sprite.getWidth(null);
    }

    public int getHeight() {
        return sprite.getHeight(null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDano() {
        return dano;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void draw(Graphics g) {
        g.drawImage(sprite, x, y, null);

        g.setColor(Color.RED);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    public boolean seColidiu(AlienFraco inimigos) {
        Rectangle disparo = new Rectangle(getX(), getY(), getWidth(), getHeight());
        Rectangle inimigo = new Rectangle(inimigos.getX(), inimigos.getY(), inimigos.getWidth(), inimigos.getHeight());
        if (disparo.intersects(inimigo)) {
            return true;
        }
        return false;
    }

    public void mover() {
        y -= velocidade;
    }
}
