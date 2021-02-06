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
public class HashMapAno {
    private final HashMapMes listaMes[];
    private final ArrayList<Integer> arrayChaves;
    final int TAMANHO = 12;
    int quantidade;
    int idAno = 0;
    
    public HashMapAno(){
        this.listaMes = new HashMapMes[this.TAMANHO];
        this.quantidade = 0;
        this.arrayChaves = new ArrayList<>();
        
        this.inicializarHashMap();
    }
    
    private void inicializarHashMap(){
        for(int i = 0; i < this.TAMANHO; i++){
            this.listaMes[i] = null;
        }
    }
    
    private int funcaoHash(final int chaveMes){
        return chaveMes - 1;
    }
    
    private boolean estaVazia(){
        return this.quantidade == 0;
    }
    private boolean estaCheia(){
        return this.quantidade == this.TAMANHO;
    }
    
    public void inserir(int chaveMes, Tarefa tarefa){
        if(!this.estaCheia()){
 
            int index = this.funcaoHash(chaveMes);
            final int indexAUX = index;
            
            if(this.listaMes[index] == null){
                this.listaMes[index] = new HashMapMes();
                this.listaMes[index].setIdMes(chaveMes);
            } 
            if (!this.arrayChaves.contains(chaveMes)) {
                this.arrayChaves.add(chaveMes);   
            }
            this.listaMes[index].inserir(tarefa.getData().getDayOfMonth(), tarefa);
            
            this.quantidade++;
        }
    }
    
    public HashMapMes buscar(int chaveMes){
        if(!this.estaVazia()){
            int index = this.funcaoHash(chaveMes);
            
            if(this.listaMes[index] != null){
                return this.listaMes[index];
            }
        }
        return null;
    }
    
    
    public HashMapMes remover(int chaveMes)
    {
        
        if(!this.estaVazia())
        {
            int index = this.funcaoHash(chaveMes);
            
            if( this.listaMes[index] !=  null)
            {
                this.arrayChaves.remove(chaveMes);
                this.quantidade--;
                return this.listaMes[index];
            }
        }
        
        return null;
    }
    
    public ArrayList getChaves()
    {
        return this.arrayChaves;
    }

    public int getIdAno() {
        return idAno;
    }

    public void setIdAno(int idAno) {
        this.idAno = idAno;
    }

    
    
    @Override
    public String toString() {
        return "";
    }
    
    
}
