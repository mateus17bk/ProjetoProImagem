package buscadecaminho;

public class No {
  
    //Variaveis da classe [No]
    String estado;
    No noPai;
    int profundidade;
    int custo;

    //Construtor um metodo que é chamado na hora de ser instanciar a objeto
    public No(String estado, No noPai, int profundidade, int custo) {
        this.estado = estado;
        this.noPai = noPai;
        this.custo = custo;
        this.profundidade = profundidade;
    }
    
}
