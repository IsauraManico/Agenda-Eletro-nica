/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

/**
 *
 * @author kenny
 */
public class ListaDuplamenteLigadaTarefas {
    
    Tarefa primeiro;
    Tarefa ultimo;
    int quant;
    int id = 0;
    
    public ListaDuplamenteLigadaTarefas(){
        this.primeiro = null;
        this.ultimo = null;
    }
    
    public boolean isEmpty(){
        return this.quant == 0;
    }
    
    public void inserirInicio(Tarefa tarefa){
        if(isEmpty()){
            this.ultimo = tarefa;
        }
        else{
            tarefa.proximo = this.primeiro;
            this.primeiro.anterior = tarefa;
        }
        this.primeiro = tarefa;
        this.quant += 1;
    }
    
    public void inserirFim(Tarefa tarefa){
        if(isEmpty()){
            this.inserirInicio(tarefa);
        }
        else{
            this.ultimo.proximo = tarefa;
            tarefa.anterior = this.ultimo;
            this.ultimo = tarefa;
            
            this.quant += 1;
        }
    }
    
    
    public int contList() {
        return this.quant;
    }
    
    public void inserirMeio(Tarefa tarefa, int pos){
        if(pos == 0){
            this.inserirInicio(tarefa);
        }
        else if(pos == contList()){
           this.inserirFim(tarefa);
        }
        else{
            int i = 0;
            Tarefa atual = this.primeiro;
            
            while(i < pos){
                atual = atual.proximo;
                i++;
            }
            
            tarefa.proximo = atual;
            tarefa.anterior = atual.anterior;
            atual.anterior.proximo = tarefa;
            atual.proximo.anterior = tarefa;
            this.quant += 1;
        }
    }
    
    public Tarefa removerInicio(){
       Tarefa aux = this.primeiro;
        if (!isEmpty()) {
           this.primeiro = this.primeiro.proximo;
           this.primeiro.anterior = null;
           this.quant -= 1;
       }
       return aux;
    }
    
    public Tarefa removerFim(){
        Tarefa aux = ultimo;
        
        if (!this.isEmpty()) {
            this.ultimo = this.ultimo.anterior;
        }
        this.quant -= 1;
        return aux;
    }
    
    public Tarefa removerMeio(int pos){
        int i = 0;
        Tarefa aux = primeiro;
        Tarefa resposta = null;
        
        if(pos == 0){
          resposta = this.removerInicio();
        }
        else if(pos >= contList() - 1){
          resposta = this.removerFim();
        }
        else{
            
            while(i < pos){
                aux = aux.proximo;
                i++;
            }
            resposta = aux;
            
            aux.anterior.proximo = aux.proximo;
            aux.proximo.anterior = aux.anterior;
            this.quant -= 1;
        }
        return resposta;
    }
    
    public Tarefa busca(int pos) {
        if (!this.isEmpty()) {
            Tarefa tarefaAux = this.primeiro;
            
            while(pos > 0) {
                tarefaAux = tarefaAux.proximo;
                pos--;
            }
            return tarefaAux;
        }
        return null;
    }

    public int getDia() {
        return id;
    }

    public void setDia(int id) {
        this.id = id;
    }
    
    


}