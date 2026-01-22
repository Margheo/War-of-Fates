package battle;

import characters.Personagem;

public class Batalha {
    public static double atacar1v1(Personagem atacante, Personagem alvo) {
        double dano = atacante.atacar();
        alvo.receberDano(dano);
        return dano;
    }
}