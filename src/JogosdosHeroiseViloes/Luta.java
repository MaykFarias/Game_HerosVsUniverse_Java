package JogosdosHeroiseViloes;
import java.util.Random;
import java.util.Scanner;

public class Luta {
    private Heroi escolhaHeroi;
    private Vilao escolhaVilao;
    private int escolhaRounds;
    private IntensidadeAtaque numeroGolpeHeroi, numeroGolpeVilao;
    private int ataqueHeroi, ataqueVilao;
    private boolean defesaHeroi = false, defesaVilao = false;

    public void opcoesPersonagensHeroi(Heroi l1, Heroi l2, Heroi l3) {
        System.out.println(" -------------------------------");
        System.out.println("|        JOGO DOS HEROIS       |");
        System.out.println(" -------------------------------");
        for (int contador = 1; contador <= 3; contador++) {
            System.out.println("[" + contador + "] ");
            switch (contador) {
                case 1 -> l1.apresentar();
                case 2 -> l2.apresentar();
                case 3 -> l3.apresentar();
                default -> {
                }
            }
        }
        System.out.println("--------------------------------");
        System.out.println("  QUAL HEROI VOCÊ ESCOLHE ?");
        System.out.print("---> ");
        Scanner teclado = new Scanner(System.in);
        String usuario = teclado.nextLine();
        int teclado2 = Integer.parseInt(usuario);
        switch (teclado2) {
            case 1 -> {
                this.escolhaHeroi = l1;
            }
            case 2 -> {
                this.escolhaHeroi = l2;
            }
            case 3 -> {
                this.escolhaHeroi = l3;
            }
        }

    }

    public void opcoesPersonagensVilao(Vilao o1, Vilao o2, Vilao o3) {
        System.out.println("O COMPUTADOR VAI ESCOLHER O SEU OPONENTE !");
        Random random = new Random();
        int teclado = random.nextInt(2);
        int escolha = teclado +1;
        switch (escolha) {
            case 1 -> {
                escolhaVilao = o1;
                //o1.apresentar();
            }
            case 2 -> {
                escolhaVilao = o2;
                //o1.apresentar();
            }
            case 3 -> {
                escolhaVilao = o3;
                //o1.apresentar();
            }
        }
    }

    public void rounds() {
        System.out.println("Quantos Hound deseja jogar ?");
        System.out.print("---> ");
        Scanner teclado2 = new Scanner(System.in);
        String escolha2 = teclado2.nextLine();
        this.escolhaRounds = Integer.parseInt(escolha2);
    }

    public void apresentacao() {
        System.out.println("Escolhendo aleatoriamente o campo...");
        System.out.println("PREPARANDO CAMPO DE BATALHA");
        System.out.println("");
        System.out.println("|===================================|");
        System.out.println("    " + escolhaHeroi.getNome() + "   X   " + escolhaVilao.getNome());
        System.out.println("|===================================| ");
        System.out.println(" Vida " + escolhaHeroi.getVida() + " %" + "          " + " Vida " + escolhaVilao.getVida() + " %");
        System.out.println(" Categoria " + escolhaHeroi.getCategoria() + "    " + " Categoria " + escolhaVilao.getCategoria());
        System.out.println("_____________________________________");
        System.out.println("SERÁ UM PARTIDA DE " + escolhaRounds + " hounds.");
        System.out.println("O campo escolhido aleatoriamente foi...");
        System.out.println("Campo de gelo.");
        System.out.println("_____________________________________");
        System.out.println("");

    }

    public void escolhaAtaqueHeroi() {
        System.out.println("==================================");
        System.out.println("""
                                [1] ATAQUE FRACO 
                                [2] ATAQUE FORTE 
                                [3] ATAQUE CRITICO 
                                [4] DEFESA""");
        System.out.println("==================================");
        System.out.println("= QUAL O SEU COMANDO ?           =");
        System.out.print("=   -----> ");
        Scanner teclado = new Scanner(System.in);
        String escolha = teclado.nextLine();
        numeroGolpeHeroi = IntensidadeAtaque.converterOpcao(Integer.parseInt(escolha));
        System.out.println("==================================");
        System.out.println(numeroGolpeHeroi);
    }

    public void escolhaAtaqueVilao() {
        Random random = new Random();
        int aleatorio = random.nextInt(2);
        int escolha = aleatorio + 1;
        numeroGolpeVilao = IntensidadeAtaque.converterOpcao(escolha);
        System.out.println(numeroGolpeVilao);
    }

    public void danoHeroi()
    {
        if (null == numeroGolpeHeroi) {
            System.out.println("ERRO");
        } else {
            switch (numeroGolpeHeroi) {
                case ATAQUE_FRACO ->
                        ataqueHeroi = switch (escolhaHeroi.getCategoria()) {
                            case "Leve" ->
                                    30;
                            case "Médio" ->
                                    20;
                            default ->
                                    10;
                        };
                case ATAQUE_FORTE ->
                        ataqueHeroi = switch (escolhaHeroi.getCategoria()) {
                            case "Leve" ->
                                    40;
                            case "Médio" ->
                                    30;
                            default ->
                                    20;
                        };
                case ATAQUE_CRITICO ->
                        ataqueHeroi = switch (escolhaHeroi.getCategoria()) {
                            case "Leve" ->
                                    50;
                            case "Médio" ->
                                    40;
                            default ->
                                    30;
                        };
                case DEFESA -> {
                    if (numeroGolpeHeroi == IntensidadeAtaque.DEFESA && numeroGolpeVilao == IntensidadeAtaque.DEFESA) {
                        System.out.println("Os dois se defenderam");
                        defesaHeroi = true;
                        defesaVilao = true;
                    } else if (numeroGolpeHeroi == IntensidadeAtaque.DEFESA && numeroGolpeVilao != IntensidadeAtaque.DEFESA) {
                        escolhaVilao.setVida(escolhaVilao.getVida() - ataqueVilao);
                        System.out.println("O " + escolhaVilao.getNome() + " recebeu " + ataqueVilao + " de dano porque o " + escolhaHeroi.getNome() + " se defendeu");
                        defesaHeroi = true;
                    } else if (numeroGolpeHeroi != IntensidadeAtaque.DEFESA && numeroGolpeVilao == IntensidadeAtaque.DEFESA) {
                        escolhaHeroi.setVida(escolhaHeroi.getVida() - ataqueHeroi);
                        System.out.println("O " + escolhaHeroi.getNome() + " recebeu " + ataqueHeroi + " de dano porque o " + escolhaVilao.getNome() + " se defendeu");
                        defesaVilao = true;
                    }
                }
                default ->
                        System.out.println("ERRO");
            }
        }

    }

    public void danoVilao() {
        if (null == numeroGolpeVilao) {
            System.out.println("ERRO");
        } else {
            switch (numeroGolpeVilao) {
                case ATAQUE_FRACO ->
                        ataqueVilao = switch (escolhaVilao.getCategoria()) {
                            case "Leve" ->
                                    10;
                            case "Médio" ->
                                    20;
                            default ->
                                    30;
                        };
                case ATAQUE_FORTE ->
                        ataqueVilao = switch (escolhaVilao.getCategoria()) {
                            case "Leve" ->
                                    10;
                            case "Médio" ->
                                    20;
                            default ->
                                    40;
                        };
                case ATAQUE_CRITICO ->
                        ataqueVilao = switch (escolhaVilao.getCategoria()) {
                            case "Leve" ->
                                    10;
                            case "Médio" ->
                                    20;
                            default ->
                                    50;
                        };
                case DEFESA -> {
                    if (numeroGolpeHeroi == IntensidadeAtaque.DEFESA && numeroGolpeVilao == IntensidadeAtaque.DEFESA) {
                        System.out.println("Os dois se defenderam");
                        defesaHeroi = true;
                        defesaVilao = true;
                    } else if (numeroGolpeHeroi == IntensidadeAtaque.DEFESA && numeroGolpeVilao != IntensidadeAtaque.DEFESA) {
                        escolhaVilao.setVida(escolhaVilao.getVida() - ataqueVilao);
                        System.out.println("O " + escolhaVilao.getNome() + " recebeu " + ataqueVilao + " de dano porque o " + escolhaHeroi.getNome() + " se defendeu");
                        defesaHeroi = true;
                    } else if (numeroGolpeHeroi != IntensidadeAtaque.DEFESA && numeroGolpeVilao == IntensidadeAtaque.DEFESA) {
                        escolhaHeroi.setVida(escolhaHeroi.getVida() - ataqueHeroi);
                        System.out.println("O " + escolhaHeroi.getNome() + " recebeu " + ataqueHeroi + " de dano porque o " + escolhaVilao.getNome() + " se defendeu");
                        defesaVilao = true;
                    }
                }
                default ->
                        System.out.println("ERRO");
            }
        }

    }

    public void luta() {
        rounds();
        apresentacao();
        while (escolhaRounds > 0) {
            escolhaAtaqueHeroi();
            escolhaAtaqueVilao();
            System.out.println("");
            if(numeroGolpeHeroi != IntensidadeAtaque.DEFESA && numeroGolpeVilao != IntensidadeAtaque.DEFESA) {
                danoHeroi();
                escolhaVilao.setVida(escolhaVilao.getVida() - ataqueHeroi);
                System.out.println("O " + escolhaHeroi.getNome() + " causou " + ataqueHeroi + " de dano no " + escolhaVilao.getNome());
                System.out.println("------------------------------------");
                danoVilao();
                escolhaHeroi.setVida(escolhaHeroi.getVida() - ataqueVilao);
                System.out.println("O " + escolhaVilao.getNome() + " causou " + ataqueVilao + " de dano no " + escolhaHeroi.getNome());
                System.out.println("------------------------------------");
            } else {
                System.out.println("DEFESA !.");
                danoHeroi();
                danoVilao();
            }
            System.out.println(escolhaHeroi.getNome() + " VIDA: " + escolhaHeroi.getVida());
            System.out.println(escolhaVilao.getNome() + " VIDA: " + escolhaVilao.getVida());
            if (this.escolhaHeroi.getVida() <= 0 || this.escolhaVilao.getVida() <= 0) {
                break;
            }
            escolhaRounds -= 1;
        }
        System.out.println("");
        if (this.escolhaHeroi.getVida() > this.escolhaVilao.getVida()) {
            this.escolhaHeroi.ganharLuta();
            this.escolhaVilao.perderLuta();
        } else if (this.escolhaHeroi.getVida() < this.escolhaVilao.getVida()) {
            this.escolhaHeroi.perderLuta();
            this.escolhaVilao.ganharLuta();
        } else {
            this.escolhaHeroi.empatarLuta();
            this.escolhaVilao.empatarLuta();
        }

        System.out.println("");
        System.out.println("   STATUS ATUAL ");
        this.escolhaHeroi.status();
        System.out.println("VIDA "+escolhaHeroi.getNome()+" :" +escolhaHeroi.getVida());
        System.out.println("");
        this.escolhaVilao.status();
        System.out.println("VIDA "+escolhaVilao.getNome()+" :" +escolhaVilao.getVida());

    }

}
