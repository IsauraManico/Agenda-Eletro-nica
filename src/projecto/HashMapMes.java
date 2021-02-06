/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;
import java.util.ArrayList;

/**
 *
 * @author kenny
 */
public class HashMapMes {
    private ListaDeTarefasDoDia listaDias[];
    private ArrayList<Integer> arrayChaves;
    final int TAMANHO = 31;
    int quantidade;
    private int idMes = 0;
    
    public HashMapMes(){
        this.listaDias = new ListaDeTarefasDoDia[this.TAMANHO];
        this.quantidade = 0;
        this.arrayChaves = new ArrayList<>();
        this.inicializarHashMap();
    }
    
    private void inicializarHashMap(){
        for(int i = 0; i < this.TAMANHO; i++){
            this.listaDias[i] = null;
        }
    }
    
    private int funcaoHash(final int chaveDia){
        return chaveDia - 1;
    }
    
    private boolean estaVazia(){
        return this.quantidade == 0;
    }
    private boolean estaCheia(){
        return this.quantidade == this.TAMANHO;
    }
    
    public void inserir(int chaveDia, Tarefa tarefa){
        if(!this.estaCheia()){
 
            int index = this.funcaoHash(chaveDia);
            
            if(this.listaDias[index] == null){
                this.listaDias[index] = new ListaDeTarefasDoDia();
                this.listaDias[index].setDia(index);
            }
            if (!this.arrayChaves.contains(chaveDia)) {
                 this.arrayChaves.add(chaveDia);
            }
            this.listaDias[index].inserirFim(tarefa);
            this.quantidade++;
        }
    }
    
    public ListaDeTarefasDoDia buscar(int chaveDia){
        if(!this.estaVazia()){
            int index = this.funcaoHash(chaveDia);
            
            if(this.listaDias[index] != null){
                return this.listaDias[index];
            }
        }
        return null;
    }
    
    
    public ListaDeTarefasDoDia remover(int chaveDia)
    {
        
        if(!this.estaVazia())
        {
            int index = this.funcaoHash(chaveDia);
            
            if( this.listaDias[index] !=  null)
            {
                this.arrayChaves.remove(chaveDia);
                this.quantidade--;
                return this.listaDias[index];
            }
        }
        
        return null;
    }
    
    public ArrayList getChaves()
    {
        return this.arrayChaves;
    }

    public int getIdMes() {
        return idMes;
    }

    public void setIdMes(int idMes) {
        this.idMes = idMes;
    }
    
    

    @Override
    public String toString() {
        return "";
    }
    
    
    
}
