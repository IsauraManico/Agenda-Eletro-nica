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
public class HashMap {
    private final HashMapAno anos[];
    private final ArrayList<Integer> arrayChaves;
    private final int TAMANHO = 20;
    private int quantidade;
    
    
    public HashMap(){
        this.anos = new HashMapAno[this.TAMANHO];
        this.quantidade = 0;
        this.arrayChaves = new ArrayList<>();
        this.inicializarHashMap();
    }
    
    private void inicializarHashMap(){
        for(int i = 0; i < this.TAMANHO; i++){
            this.anos[i] = null;
        }
    }
    
    private int funcaoHash(final int numCamisola){
        return ((numCamisola * 49) / 2) % this.TAMANHO;
    }
    
    private boolean estaVazia(){
        return this.quantidade == 0;
    }
    private boolean estaCheia(){
        return this.quantidade == this.TAMANHO;
    }
    public void inserirAno(int chaveAno, Tarefa novaTarefa){
        if(!this.estaCheia()){
            int index = this.funcaoHash(chaveAno);
            int indexAUX = index;
            
            if(this.anos[index] == null) {
                this.anos[index] = new HashMapAno();
                this.anos[index].inserir(novaTarefa.getData().getMonthValue(), novaTarefa);
                this.arrayChaves.add(chaveAno);
            } else {
                while(this.anos[index] != null ||
                     (this.anos[index] != null ? this.anos[index].getChaves().isEmpty() : false)){
                    index = (index + 1) % this.TAMANHO;
                    if (indexAUX == index) {
                      break;
                    }
                }
                this.anos[index].inserir(novaTarefa.getData().getMonthValue(), novaTarefa);
            }
            this.quantidade++;
        }
    }
    
    public HashMapAno buscarAno(int chaveAno){
        if(!this.estaVazia()){
            int index = this.funcaoHash(chaveAno);
            int indexAUX = index;
            
            if(this.anos[index].getIdAno() == chaveAno){
                return this.anos[index];
            }
            else{
                while(this.anos[index] != null ||
                     (this.anos[index] != null ? this.anos[index].getChaves().isEmpty() : false)){
                     if(this.anos[index].getIdAno() == chaveAno){
                        return this.anos[index];
                     }
                     index = (index + 1) % this.TAMANHO;
                     
                     if (indexAUX == index) {
                      break;
                    }
                }
            }
        }
        return null;
    }
    
    
    public HashMapAno removerAno(int chaveAno)
    {
        
        if(!this.estaVazia())
        {
            int index = this.funcaoHash(chaveAno);
            int indexAUX = index;
            
            if( this.anos[index].getIdAno() ==  chaveAno)
            {
                this.anos[index].setIdAno(-chaveAno);
                this.arrayChaves.remove(chaveAno);
                this.quantidade--;
                return this.anos[index];
            }
            else
            {
               while(this.anos[index] != null)
               {
                  if( this.anos[index].getIdAno() ==  chaveAno)
                  {

                    this.anos[index].setIdAno(-chaveAno);
                    this.arrayChaves.remove(chaveAno);
                    this.quantidade--;
                    return this.anos[index];
                    
                  }
                  index = (index + 1) % this.TAMANHO;
                  
                  if (indexAUX == index) {
                      break;
                  }
               }
                    
            }
            
        }
        
        return null;
    }
    
    public ArrayList getChaves()
    {
        return this.arrayChaves;
    }

    @Override
    public String toString() {
        return "";
    }
    
    
}