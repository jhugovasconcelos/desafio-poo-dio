package br.com.dio.desafio.dominio;

import java.util.LinkedHashMap;
import java.util.Map;


public class Plataforma {
    private static Plataforma instance;
    private Map<String, Artigo> artigos = new LinkedHashMap<>();
    
    private Plataforma(){}

    public static Plataforma getInstance() {
        if (instance == null) {
            instance = new Plataforma();
        }
        return instance;
    }

    public void inserirArtigo(Artigo artigo){
        this.artigos.put(artigo.getTitulo(), artigo);
    }
    public Artigo acharArtigo(String titulo){
        Artigo artigoEncontrado = null;
        if (this.artigos.containsKey(titulo)) artigoEncontrado = this.artigos.get(titulo);
        else System.err.println("Não existe artigo com este título!");
        return artigoEncontrado;
    }



}
