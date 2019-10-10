package buscadecaminho;

public class AcaoResultado {
 
 //Variaveis da classe [AcaoResultado]
  String estadoInical;
  String estadoFinal;
  int acao;
  int custo;
 
     //Construtor um metodo que é chamado na hora de ser instanciar a objeto
    public AcaoResultado(String estadoInical, String estadoFinal, int custo, int acao) {
        this.estadoInical = estadoInical;
        this.estadoFinal = estadoFinal;
        this.custo = custo;
        this.acao = acao;
    }
 
}
