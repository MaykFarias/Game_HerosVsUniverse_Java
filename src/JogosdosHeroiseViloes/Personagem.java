package JogosdosHeroiseViloes;

public class Personagem {
    private String nome;
    private String categoria;
    private int vida, vitorias, derrotas, empates;


    public Personagem(String no, String cat, int vi, int vit, int de, int em) {
        this.nome = no;
        this.categoria = cat;
        this.vida = vi;
        this.vitorias = vit;
        this.derrotas = de;
        this.empates = em;
    }

    public void apresentar() {
        //System.out.println("--------------------------");
        System.out.println(this.getNome());
        System.out.println("Vida " + this.getVida()+"%");
        System.out.println("Categoria " + this.getCategoria());
        //System.out.println("--------------------------");
    }

    public void status() {
        System.out.println(this.getNome() + " é um " + this.getCategoria());
        System.out.println("Ganhou " + this.getVitorias() + " vezes");
        System.out.println("Perdeu " + this.getDerrotas() + " vezes");
        System.out.println("Empatou " + this.getEmpates() + " vezes");
    }

    public void ganharLuta() {
        this.setVitorias(this.getVitorias() +1);
        System.out.println(getNome()+" GANHOU !!!");
    }

    public void perderLuta() {
        this.setDerrotas(this.getDerrotas() + 1);
        System.out.println(getNome()+" PERDEU !!!");
    }

    public void empatarLuta() {
        this.setEmpates(this.getEmpates() +1);
        System.out.println("EMPATE !!!");
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
        //this.setCategoria();
    }

    public String getCategoria() {
        return categoria;
    }

    private void setCategoria(String categoria) {
        this.categoria = categoria;

    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

}
