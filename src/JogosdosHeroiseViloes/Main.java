package JogosdosHeroiseViloes;

public class Main {
    public static void main(String[] args) {
        Heroi l[] = new Heroi[3];
        l[0] = new Heroi("Super Man","Pesado", 120, 0, 0, 0);
        l[1] = new Heroi("Batmam Dark", "Médio", 90, 0, 0,0);
        l[2] = new Heroi("Homem Aranha", "Leve",80, 0, 0,0);

        Vilao o[] = new Vilao[3];
        o[0] = new Vilao("Coringa", "Leve",80,0,0,0);
        o[1] = new Vilao("Lex Lutor", "Pesado", 100,0,0,0);
        o[2] = new Vilao("Duende Verde", "Médio",90,0,0,0);

        Luta UEC01 = new Luta();
        UEC01.opcoesPersonagensHeroi(l[0], l[1], l[2]);
        UEC01.opcoesPersonagensVilao(o[0], o[1], o[2]);
        UEC01.luta();
    }
}