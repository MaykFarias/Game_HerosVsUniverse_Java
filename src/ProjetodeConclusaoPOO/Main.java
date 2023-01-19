package ProjetodeConclusaoPOO;

public class Main {
    public static void main(String[] args) {
        Video v[] = new Video[2];
        v[0] = new Video("Aula 1 de POO");
        v[1] = new Video("Aula 10 de PYTHON");

        Gafanhoto g[] = new Gafanhoto[2];
        g[0] = new Gafanhoto("Mayk",23,"M","Yank");

        Visualizacao vis[] = new Visualizacao[2];
        vis[0] = new Visualizacao(g[0], v[1]);
        vis[0].avaliar(87.0f);
        System.out.println(vis.toString());


        //System.out.println(v[0].toString());
        //System.out.println(g[0].toString());

    }
}