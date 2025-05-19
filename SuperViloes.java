public class SuperViloes {
  private String nome;
  private int nivelDeMaldade;
  private SuperViloes esquerda;
  private SuperViloes direita;

  public SuperViloes(String nome, int nivelDeMaldade) {
      this.nome = nome;
      this.nivelDeMaldade = nivelDeMaldade;
      this.esquerda = null;
      this.direita = null;
  }

  public String getNome() {
    
    return nome;
}

public int getNivelDeMaldade() {
    return nivelDeMaldade;
}

public SuperViloes getEsquerda() {
    return esquerda;
}

public SuperViloes getDireita() {
    return direita;
}

public void setNome(String nome) {
    this.nome = nome;
}

public void setNivelDeMaldade(int nivelDeMaldade) {
    this.nivelDeMaldade = nivelDeMaldade;
}

public void setEsquerda(SuperViloes esquerda) {
    this.esquerda = esquerda;
}

public void setDireita(SuperViloes direita) {
    this.direita = direita;
}
}
