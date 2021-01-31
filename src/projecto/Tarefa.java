/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.util.Date;
import java.time.LocalDateTime;

/**
 *
 * @author kenny
 */
public class Tarefa {
    private LocalDateTime data;
    private int diaSemana;
    private int hora;
    private String descricao;
    private String local;
    private int lembrete;
    private int periocidade;
    Tarefa proximo;
    Tarefa anterior;

    public Tarefa(LocalDateTime data, String descricao, String local, int lembrete, int periocidade) {
        this.data = data;
        
        this.descricao = descricao;
        this.local = local;
        this.lembrete = lembrete;
        this.periocidade = periocidade;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getLembrete() {
        return lembrete;
    }

    public void setLembrete(int lembrete) {
        this.lembrete = lembrete;
    }

    public int isPeriocidade() {
        return periocidade;
    }

    public void setPeriocidade(int periocidade) {
        this.periocidade = periocidade;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "data=" + data + ", diaSemana=" + diaSemana + ", hora=" + hora + ", descricao=" + descricao + ", local=" + local + ", lembrete=" + lembrete + ", periocidade=" + periocidade + '}';
    }
    
    
}
