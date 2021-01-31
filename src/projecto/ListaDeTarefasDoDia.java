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
public class ListaDeTarefasDoDia extends ListaDuplamenteLigadaTarefas {
    
    public void inserir(Tarefa tarefa){
        super.inserirFim(tarefa);
    }
    
    public Tarefa buscar(int pos){
        return super.busca(pos);
    }
    
    
    public Tarefa remover(int pos)
    {
        return super.removerMeio(pos);
    }

    @Override
    public String toString() {
        return "";
    }
    
}
