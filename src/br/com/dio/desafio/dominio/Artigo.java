package br.com.dio.desafio.dominio;

import java.util.LinkedHashMap;
import java.util.Map;

public class Artigo extends Conteudo {
    private Dev autor;
    private String titulo;
    private int numerolinhas;
    private Map<Dev, Character> votosPositivos = new LinkedHashMap<>();
    private Map<Dev, Character> votosNegativos = new LinkedHashMap<>();

    public Dev getAutor() {
        return autor;
    }

    public void setAutor(Dev autor) {
        this.autor = autor;
    }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumerolinhas() { return numerolinhas; }

    public void setNumerolinhas(int numerolinhas) {
        this.numerolinhas = numerolinhas;
    }

    public Map<Dev, Character> getVotosPositivos() { return votosPositivos; }

    public Map<Dev, Character>  getVotosNegativos() {
        return votosNegativos;
    }

    public void receberVoto(Dev dev, char valor){
        if(dev != this.autor){
            if(valor == '+') votosPositivos.putIfAbsent(dev,valor);
            else if (valor == '-') votosNegativos.putIfAbsent(dev, valor);
            else System.out.println("O voto precisa ser '+' ou '-'");
        } else System.out.println("Apenas outros devs podem votar");
    }
    public int contarVotosPositivos(){
        return this.votosPositivos.size();
    }
    public int contarVotosNegativos(){
        return this.votosNegativos.size();
    }

    @Override
    public double calcularXp() {
        int votosPositivos = contarVotosPositivos();
        int votosNegativos = contarVotosNegativos();
        double linhasTotal = Math.min(this.numerolinhas, 50);
        int votosValidos = votosPositivos - (votosNegativos/2);
        return  linhasTotal + (double) votosValidos;
    }

    @Override
    public String toString() {
        return String.format( "Artigo {" +
                "Título: %s " +
                ", Autor: %s " +
                ", Número de linhas: %d" +
                ", Votos Positivos: %d " +
                ", Votos Negativos: %d }",
                this.titulo,this.autor.getNome(),this.numerolinhas, contarVotosPositivos(), contarVotosNegativos());
    }


}
