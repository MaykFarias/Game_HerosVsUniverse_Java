package JogosdosHeroiseViloes;

public enum IntensidadeAtaque {
    ATAQUE_FRACO, ATAQUE_FORTE, ATAQUE_CRITICO, DEFESA;
    public static IntensidadeAtaque converterOpcao(int numero) {
        return switch (numero) {
            case 1 -> IntensidadeAtaque.ATAQUE_FRACO;
            case 2 -> IntensidadeAtaque.ATAQUE_FORTE;
            case 3 -> IntensidadeAtaque.ATAQUE_CRITICO;
            default -> IntensidadeAtaque.DEFESA;
        };
    }
}

