
package br.com.clientes.model.entities;

import br.com.clientes.util.Utilidades;

public class Usuario {
    private String nome;
  private String senha;

  public String getNome(){
    return this.nome;
  }

  public void setNome(String no){
    this.nome = no;
  }

  public String getSenha(){
    return this.senha;
  }

  public void setSenha(String se){
    this.senha = se;
  }

  public String verificarUsuario(){
    if(Utilidades.isUsuarioValido(nome, senha))
      return "sucesso";
    else
      return "erro";
  }
}