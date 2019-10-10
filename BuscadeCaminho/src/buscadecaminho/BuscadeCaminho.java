
package buscadecaminho;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;

public class BuscadeCaminho{

    //Fução para trilhar os caminhos posiveis
    //Passando um [parametro tipo No]
    public static void trilhar(No atualNo){
    
        System.out.println("\n Trilhar o caminho: ");//Enquanto o parametro atualNo for diferente, represente o estado atual
        while(atualNo != null){
            System.out.println("-" +atualNo.estado);
            atualNo = atualNo.noPai; //Recebendo a variavel da classe [No -- noPai]   
        }        
        System.out.println("-"+atualNo.estado);//Recebendo a variavel da classe [No -- estado] 
        
    }
 
    //Função para expandir os possiveis No
    //Passando os [parametros tipo No,List,Stack,]
    public static void expandirNo(No no , List<AcaoResultado> listaResultado, Stack<No> borda, List<No> analizadoNo ){
        for (AcaoResultado resultado : listaResultado) { //Criando um for otimizado,com uma variavel resultado
            if (resultado.estadoInical == no.estado){ 
                boolean encontrado = false ;
                No noExpandido =  new No(resultado.estadoFinal, no , no.custo +resultado.custo, no.profundidade +1);//Cria-se uma variavel [noExpandido] que inplementa os estados final, custo e a profundide
                System.out.println("\n\n    ------------------------ "+noExpandido.estado);//Mostra na tela o resultado, do custo de em Km rodados, o caminho eo estado desejado
                for (No analizado : analizadoNo) {//Criando um for otimizado, com uma variavel analizado
                    if (analizado.estado == noExpandido.estado ){
                      encontrado = true ;
                      break;                        
                    }
                }
                if(!encontrado){
                    borda.add(noExpandido);
                }
            }
        }
    }
    
    //Função mostra as informação do percurso
    //Passando os [parametros tipo Problemae e Pilha]
    public static void solucao(Problema pro, Stack<No> borda){
        borda.add(new No(pro.estadoIncial, null, 0,0));//Iniciando a borda zerada
        List<No> analizadoNo = new ArrayList<No>();//Uma ordem pré-determinada [List]
        
        while(!borda.isEmpty()){//Enquanto a borda estiver vazia
            No nodaVez = borda.pop();//Apresenta o primeiro da pilha
            System.out.print("Analisando o Nó da vez: " +nodaVez.estado);
            if(nodaVez.estado == pro.estadoFinal){//Verifica se o caminho percorrido
                System.out.print("  Chegou no seu destino");
                System.out.print("  Distancia percorrida foi ----> " +nodaVez.custo+ " Quilômetros percorrido");
                System.out.print("  Profundidade de " +nodaVez.profundidade);
                trilhar(nodaVez);
            }else{//Se não, verificar ainda os posiveis caminhos 
                analizadoNo.add(nodaVez);
                System.out.println("  Não é meu destino, vou procura o caminho.\n");
                System.out.println("  Para quais estados eu posso ir a partir de "  +nodaVez.estado+" ?");
                expandirNo(nodaVez, pro.mapa,borda,analizadoNo);
                System.out.println("\n \n \n");
                
            }
        }
    }
    
    
    public static void main(String[] args) {
      /*(1-PASSO) Criando a Lista 
        (2-PASSO) Adicionando os caminhos possiveis na lista
        (3-PASSO) Criando a função Trilhar 
        (4-PASSO) Cria uma Stack que é uma pilha
        (5-PASSO) Assim criando a função expandirNo
        (6-PASSO) Cria a função solucao para, mostra os resultados dos caminhos
        (7-PASSO) Mostra no terminal o resultado final
        */ 
     
        //Informando o percuros que ira tomar, estado atual ao estado desejado           
      
      //Criação da pilha para organizar dados que iram ser inserido
      Stack<No> pilha = new Stack<>();
        
      //Uma ordem pré-determinada [List]  
      List<AcaoResultado> mapa = new ArrayList<>();
      
      //Criando todos os caminhos possiveis na lista 
      AcaoResultado 
              
              caminho = new AcaoResultado("BAHIA","SERGIPE",1,320);
              mapa.add(caminho);
      
              caminho = new AcaoResultado("SERGIPE","ALAGOAS",2,270);
              mapa.add(caminho);
              
              caminho = new AcaoResultado("ALAGOAS","PERNANBUCO",5,250);
              mapa.add(caminho);
              
              caminho = new AcaoResultado("PERNANBUCO","PARAÍBA",7,120);
              mapa.add(caminho);
              
              caminho = new AcaoResultado("PARAÍBA","RIO GRANDE DO NORTE",9,180);
              mapa.add(caminho);
              
              caminho = new AcaoResultado("RIO GRANDE DO NORTE","CEARÁ",10,550);
              mapa.add(caminho);
        
              caminho = new AcaoResultado("CEARÁ","PIAUÍ",11,790);
              mapa.add(caminho);
              
              caminho = new AcaoResultado("PIAUÍ","MARANHÃO",12,800);
              mapa.add(caminho);
              
              caminho = new AcaoResultado("SERGIPE","PIAUÍ",3,1112);
              mapa.add(caminho);
              
              caminho = new AcaoResultado("ALAGOAS","PIAUÍ",4,1120);
              mapa.add(caminho);
              
              caminho = new AcaoResultado("PERNANBUCO","PIAUÍ",6,1130);
              mapa.add(caminho);
              
              caminho = new AcaoResultado("PARAÍBA","PIAUÍ",8,1160);
              mapa.add(caminho);

              JOptionPane.showInputDialog("Informe o seu lugar de origem: ");          
              String atual = "AL";
              JOptionPane.showInputDialog("Informe o estado que deseja ir: ");
              String ir = "PE";
                     
              //Criando problema
             Problema pro = new Problema(atual,ir, (ArrayList<AcaoResultado>) mapa);
             
             //Executando a função solução
             solucao(pro,pilha);
              
              
    }
        
    
    
}
