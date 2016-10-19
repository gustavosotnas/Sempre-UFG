package br.ufg.inf.abstratas;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public abstract class AreaDeConhecimento {
    private String nome;
    private int codigo;

    public AreaDeConhecimento(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}