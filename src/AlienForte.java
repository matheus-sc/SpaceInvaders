package src;

public class AlienForte extends Nave {
    private int velocidade;

    public AlienForte() {
        setVida(30);
        this.velocidade = 15;

       setSprite("C:\\Users\\mathe\\Downloads\\SpaceInvaders\\assets\\AlienForte.png");
    }

    public void atirar(int dano, int velocidade, int cooldown) {
        
    }

    public void moverEsquerda() {
        if (getX() > 0) {
            setX(getX() - velocidade);
        }
    }

    public void moverDireita() {
        if (getX() < getFundoWidth() - getWidth()) {
            setX(getX() + velocidade);  // move 10 units to the right
        }
    }
}