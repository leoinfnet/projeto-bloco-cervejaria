package br.com.acme.cervejaria.model;

public class CervejaPojo {
    private int codigo;
    private String nome;

    public CervejaPojo() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
