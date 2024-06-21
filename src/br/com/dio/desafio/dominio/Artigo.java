package br.com.dio.desafio.dominio;

public class Artigo extends Conteudo {
    private int votosPositivos;
    private int votosNegativos;
    private int numerolinhas;

    public Artigo(int numeroLinhas){
        this.numerolinhas = numeroLinhas;
    }

    public int getVotosPositivos() {
        return votosPositivos;
    }

    public void setVotosPositivos(int votosPositivos) {
        this.votosPositivos = votosPositivos;
    }

    public int getVotosNegativos() {
        return votosNegativos;
    }

    public void setVotosNegativos(int votosNegativos) {
        this.votosNegativos = votosNegativos;
    }

    @Override
    public double calcularXp() {
        // TODO: algoritmo mais justo para calcular o valor do XP baseado no número de linhas, votos positivos e negativos
        double percentualVotos = (double) this.votosNegativos / this.votosPositivos;
        double linhasTotal = Math.min(this.numerolinhas, 500);
        if(percentualVotos >= 1)  linhasTotal *= 0.3;
        else linhasTotal *= 1/percentualVotos;
        return linhasTotal;
    }

    @Override
    public String toString() {
        return null;
    }
}
