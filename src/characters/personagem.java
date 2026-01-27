import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Personagem guerreiro = new Personagem("O Guerreiro", 65, 0);
        Personagem ranger = new Personagem("O Patrulheiro", 45, 10);
        Personagem mago = new Personagem("O Mago", 35, 40);
        Personagem tank = new Personagem("A MURALHA", 100, 0);
        guerreiro.mostrarStatus();
        ranger.mostrarStatus();
        mago.mostrarStatus();
        tank.mostrarStatus();

        guerreiro.atacar(inimigo, 10);
        ranger.atacar(inimigo, 15);
        tank.atacar(inimigo, 6);
        mago.atacar(inimigo, 10);
        mago.gastarMana(5);
        mago.recuperarMana(2);

        // Tornar objeto Personagem em alvo [inimigo] (ao selecionar e entrar em arena, igualar e, ao fim, deletar a equalidade)
    }
}

public class Personagem {
    private String nome;
    private int vida;
    private int mana;
    private int defesa;

    public Personagem(String nome, int vida, int mana) {
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.defesa = defesa;
    }

    public void receberDano(int dano) {
        vida -= dano;

        if (vida < 0) {
            vida = 0;
        }

        System.out.println(vida);
    }

    public void personagemVivo(int vida){
        if (vida > 0) {
            System.out.println(nome + "está vivo.");
        } else {
            System.out.println(nome + "está morto.");
        }
    }

    public void atacar(Personagem inimigo, int dano) {
        System.out.println(nome + " atacou " + inimigo.nome);
        inimigo.receberDano(dano-defesa);
    }
    
    public void usarMagia(Personagem mago, int mana, int dano) {
        System.out.println(nome + "Usou sua magia!");
        mago.gastarMana();
        mago.atacar(inimigo, 30);
    }

    public void gastarMana(int custo) {
        if (mana >= custo) {
            mana -= custo;
            System.out.println("-" + custo + " mana.");
        } else {
            System.out.println("Mana insuficiente!");
        }
    }

    public void recuperarMana(int quantidade) {
        mana += quantidade;
        System.out.println(nome + " recuperou " + quantidade + " de mana.");
    }

    public void mostrarStatus() {
        System.out.println("Status de " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Mana: " + mana);
        System.out.println("Defesa:" + defesa);
    }
}
