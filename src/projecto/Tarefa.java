
package projecto;

import java.util.Date;
import java.time.LocalDateTime;

/**
 *
 * @author kenny
 */
public class Tarefa 
{
    private LocalDateTime data;
    private String diaSemana;
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minuto;
    private String descricao;
    private String local;
    private int lembrete;
    private int periocidade;
    Tarefa proximo;
    Tarefa anterior;

    public Tarefa(LocalDateTime data, String descricao, String local, 
            int lembrete, int periocidade) 
    {
        this.data = data;
        this.diaSemana = data.getDayOfWeek().toString();
        this.hora = data.getHour();
        this.minuto = data.getMinute();
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
        this.diaSemana = data.getDayOfWeek().toString();
        this.hora = data.getHour();
        this.minuto = data.getMinute();
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
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

    public int getAno() {
        return ano == 0 ? this.data.getYear() : this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes == 0 ? this.data.getMonthValue(): this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia == 0 ? this.data.getDayOfMonth(): this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    
    @Override
    public String toString() 
    {
        return "Tarefa{" + "data=" + data + ", diaSemana=" + diaSemana + 
                ", hora=" + hora + ", descricao=" + descricao + ", local=" + local
                + ", lembrete=" + lembrete + ", periocidade=" + periocidade + '}';
    }
    
    
}
