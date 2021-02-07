package projecto;
import java.time.LocalDate;  // import the LocalDate class
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner input = new Scanner(System.in);
    static HashMap geral = new HashMap();
    static int ano,  mes, dia, hora, minutos, lembrete, periocidade;
    static String descString, local;
        
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu(){
        int op;
        boolean flag = true;
        
        
        do{
            System.out.println("\n");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\t\t\t\t\t\tSeja Bem Vindo ao Programa O Que Deseja Fazer?");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n1  - Inserir Tarefa" + 
                              "\n2  - Remover Tarefa" + 
                              "\n3  - Editar Uma Tarefa" + 
                              "\n4  - Verificar Existencia de uma Tarefa" +
                              "\n5  - Ver Tarefas De Uma Data" + 
                              "\n6  - Verificar Tarefas Em Um Horário" +
                              "\n7  - Verificar se a Agenda está vazia" +
                              "\n8  - Verificar Dias Livres Em Um Mês" +
                              "\n9  - Verificar Meses Sem Atividade" +
                              "\n10 - Ver Mês mais Atarefado" +
                              "\n11 - Ver Mês menos Atarefado" +
                              "\n12 - Ver Todas AS Tarefas" +
                              "\n13 - Fechar o Programa");

            System.out.print(": ");
            op = input.nextInt();
            
            switch(op){
                case 1:
                    inserirTarefa();
                    break;
                case 2:
                    removerTarefa();
                    break;
                case 3:
                    editarTarefa();
                    break;   
                case 4:
                    verificarExistenciaTarefa();
                    break; 
                case 5:
                    verTarefasDeUmaData();
                    break;
                case 6:
                    verificarTarefasEmUmHorario();
                    break;
                case 7:
                    verificarSeAgendaEstaVazia();
                    break;
                case 8:
                    verificarDiasLivresEmUmMes();
                    break;
                case 9:
                    verificarMesesSemAtividade();
                    break;
                case 10:
                    verMesMaisAtarefado();
                    break;
                case 11:
                    verMesMenosAtarefado();
                    break;    
                case 12:
                    verTodasAsTarefas();
                    break;  
                case 13:
                    flag = false;
                    break;    
                default:
                    System.out.println("Opção Errada");

            }
        } while (flag);
        
        
    }

    private static void inserirTarefa() {
        System.out.println("\n*****************************************");
        System.out.println("\tInserção de uma Nova Tarefa");
        System.out.println("*****************************************");
        
        System.out.print("Descrição: ");
        descString = input.next();
        
        System.out.print("\nAno: ");
        ano = input.nextInt();
        System.out.print("\nMês: ");
        mes = input.nextInt();
        System.out.print("\nDia: ");
        dia = input.nextInt();      
        
        System.out.print("\nHora: ");
        hora = input.nextInt();
        System.out.print("\nMinutos: ");
        minutos = input.nextInt();
        
        System.out.print("\nLocal: ");
        local = input.next();
        
        System.out.print("\nLembrete: ");
        lembrete = input.nextInt();
        
        System.out.print("\nPeriocidade: ");
        periocidade = input.nextInt();
        
        Tarefa novaTarefa = new Tarefa(LocalDateTime.of(ano, mes, dia, hora, minutos, LocalDateTime.now().getSecond()),
                descString, local, lembrete, periocidade);
        
        geral.inserirTarefa(novaTarefa);
        System.out.println("*****************************************");
        System.out.println("*****************************************");
    }

    private static void removerTarefa() {
        System.out.println("\n");
        System.out.println("\n*****************************************");
        System.out.println("\tRemover uma Tarefa");
        System.out.println("*****************************************");
        System.out.println("Inserção da Data:");
        System.out.print("Ano: ");
        ano = input.nextInt();
        System.out.print("\nMês: ");
        mes = input.nextInt();
        System.out.print("\nDia: ");
        dia = input.nextInt();
        
        
        try {
            ListaDeTarefasDoDia tarefasDaData = geral.buscarAno(ano).buscar(mes).buscar(dia);
            
            System.out.println(geral.buscarAno(ano).buscar(mes).buscar(dia).toString());
            System.out.println("");
            System.out.print("Qual Tarefa Pretendes Remover?\n: ");
            int op = input.nextInt();
            System.out.println("");
            
            geral.buscarAno(ano).buscar(mes).buscar(dia).removerMeio(op - 1);
            System.out.println("Tarefa removida");
        } catch (Exception e) {
            System.out.println("Não há tarefas registradas nessa Data");
        }
        
    }

    private static void editarTarefa() {
        System.out.println("\n");
        System.out.println("\n*****************************************");
        System.out.println("\tEditar Tarefa");
        System.out.println("*****************************************");
        System.out.println("Inserção data:");
        System.out.print("\nAno: ");
        Main.ano = input.nextInt();
        System.out.print("\nMês: ");
        Main.mes = input.nextInt();
        System.out.print("\nDia: ");
        Main.dia = input.nextInt();
        
        
        try {
            String ano,  mes, dia, hora, minutos, lembrete, periocidade;
            ListaDeTarefasDoDia tarefasDaData = geral.buscarAno(Main.ano).buscar(Main.mes).buscar(Main.dia);
            
            System.out.println(geral.buscarAno(Main.ano).buscar(Main.mes).buscar(Main.dia).toString());
            System.out.println("");
            System.out.print("Qual Tarefa Pretendes Editar?(Para não alterar digite .)\n: ");
            int op = input.nextInt();
            System.out.println("");
            
            Tarefa tarefaSerEditada = geral.buscarAno(Main.ano).buscar(Main.mes).buscar(Main.dia).removerMeio(op - 1);
          
            System.out.print("\nDescrição: ");
            descString = input.next();
            System.out.print("Ano: ");
            ano = input.next();
            System.out.print("\nMês: ");
            mes = input.next();
            System.out.print("\nDia: ");
            dia = input.next();   
            System.out.print("\nHora: ");
            hora = input.next();
            System.out.print("\nMinutos: ");
            minutos = input.next(); 
            System.out.print("\nLocal: ");
            local = input.next();        
            System.out.print("\nLembrete: ");
            lembrete = input.next();        
            System.out.print("\nPeriocidade: ");
            periocidade = input.next();

            
            tarefaSerEditada.setAno((ano.equals(".") ? tarefaSerEditada.getAno() : Integer.parseInt(ano)));
            tarefaSerEditada.setMes((mes.equals(".") ? tarefaSerEditada.getMes(): Integer.parseInt(mes)));
            tarefaSerEditada.setDia((dia.equals(".") ? tarefaSerEditada.getDia(): Integer.parseInt(dia)));
            tarefaSerEditada.setHora((hora.equals(".") ? tarefaSerEditada.getHora(): Integer.parseInt(hora)));
            tarefaSerEditada.setMinuto((minutos.equals(".") ? tarefaSerEditada.getMinuto(): Integer.parseInt(minutos)));
            tarefaSerEditada.setData(LocalDateTime.of(tarefaSerEditada.getAno(), tarefaSerEditada.getMes(),
                    tarefaSerEditada.getDia(), tarefaSerEditada.getHora(), tarefaSerEditada.getMinuto()));
            tarefaSerEditada.setDescricao((descString.equals(".") ? tarefaSerEditada.getDescricao(): descString));
            tarefaSerEditada.setLocal((local.equals(".") ? tarefaSerEditada.getLocal(): local));
            tarefaSerEditada.setLembrete((lembrete.equals(".") ? tarefaSerEditada.getLembrete(): Integer.parseInt(lembrete)));
            tarefaSerEditada.setPeriocidade((periocidade.equals(".") ? tarefaSerEditada.isPeriocidade(): Integer.parseInt(periocidade)));                  
            
            
            geral.inserirTarefa(tarefaSerEditada);
            System.out.println("Tarefa alterada!");
        } catch (Exception e) {
            System.out.println("Não há tarefas registradas nessa Data");
        }
    }

    private static void verificarExistenciaTarefa() {
        System.out.println("\n*****************************************");
        System.out.println("\tVerificar Existência Tarefa");
        System.out.println("*****************************************");
        
        ArrayList <Integer> anosRegistrados = geral.getChaves();
        System.out.print    ("Digite uma descrição para procurar: ");
        String descString = input.next();
        
        for(final int ano : anosRegistrados)
        {
            ArrayList <Integer> mesesRegistrados = geral.buscarAno(ano).getChaves();
            
            for (final int mes : mesesRegistrados) {
                ArrayList<Integer> diasRegistrados = geral.buscarAno(ano).buscar(mes).getChaves();
                        
                for (final int dia : diasRegistrados)
                {
                    Tarefa tarefaAux = geral.buscarAno(ano).buscar(mes).buscar(dia).primeiro;
                    while (tarefaAux != null) 
                    {
                        if(tarefaAux.getDescricao().contains(descString)) {
                            System.out.println("Tarefa: " + tarefaAux.getDescricao() + " Data: " +tarefaAux.getData());
                        }
                        tarefaAux = tarefaAux.proximo;
                    }
                }
            }
        }
    }

    private static void verTarefasDeUmaData() {
        System.out.println("\n");
        System.out.println("Ver Tarefa de uma Data:");
        System.out.println("Ano: ");
        ano = input.nextInt();
        System.out.println("Mês: ");
        mes = input.nextInt();
        System.out.println("Dia: ");
        dia = input.nextInt();
        
        try {
            ListaDeTarefasDoDia tarefasDaData = geral.buscarAno(ano).buscar(mes).buscar(dia);
            
            if (tarefasDaData.contList() == 0) {
                System.out.println("Não há tarefas registradas nessa Data");
            } else {
                System.out.println(geral.buscarAno(ano).buscar(mes).buscar(dia).toString());
            }
        } catch (Exception e) {
            System.out.println("Não há tarefas registradas nessa Data");
        }
    }

    private static void verificarTarefasEmUmHorario() {
        System.out.println("\n");
        System.out.println("Ver Tarefa de uma Data:");
        System.out.println("Ano: ");
        ano = input.nextInt();
        System.out.println("Mês: ");
        mes = input.nextInt();
        System.out.println("Dia: ");
        dia = input.nextInt();
        System.out.println("Hora: ");
        hora = input.nextInt();
        
        try {
            ListaDeTarefasDoDia tarefasDaData = geral.buscarAno(ano).buscar(mes).buscar(dia);
            
            if (tarefasDaData.contList() == 0) {
                System.out.println("Não há tarefas registradas nessa Data");
            } else {
                Tarefa tarefaAux = tarefasDaData.primeiro;
                
                while (tarefaAux != null) {
                    if (tarefaAux.getHora() == hora) {
                        System.out.println(tarefaAux);
                    }
                    tarefaAux = tarefaAux.proximo;
                }
            }
        } catch (Exception e) {
            System.out.println("Não há tarefas registradas nessa Data");
        }
    }

    private static void verificarSeAgendaEstaVazia() {
        ArrayList <Integer> anosRegistrados = geral.getChaves();
        boolean agendaEstaVazia = true;
        
        for(final int ano : anosRegistrados) {
            ArrayList <Integer> mesesRegistrados = geral.buscarAno(ano).getChaves();
            
            for (final int mes : mesesRegistrados) {
                ArrayList<Integer> diasRegistrados = geral.buscarAno(ano).buscar(mes).getChaves();
                
                for (final int dia : diasRegistrados) {
                    if (geral.buscarAno(ano).buscar(mes).buscar(dia).contList() != 0) {
                        agendaEstaVazia = false;
                        break;
                    }
                }
                if (agendaEstaVazia == false) {
                    break;
                }
            }
            if (agendaEstaVazia == false) {
                break;
            }
        }
        if (agendaEstaVazia == true) {
            System.out.println("A agenda está vazia");
        } else {
            System.out.println("A agenda não está vazia");
        }
    }

    private static void verificarDiasLivresEmUmMes() {
        System.out.println("\n");
        System.out.println("Ver Tarefa de uma Data:");
        System.out.println("Ano: ");
        ano = input.nextInt();
        System.out.println("Mês: ");
        mes = input.nextInt();
        
        try {
            ArrayList<Integer> diasRegistrados = geral.buscarAno(ano).buscar(mes).getChaves();
            
            for (int dia = 1; dia <= LocalDate.of(ano, mes, 1).lengthOfMonth(); dia++) {
                if (!diasRegistrados.contains(dia)) {
                    System.out.println("O dia " + dia + " está livre.");
                } else {
                    if (geral.buscarAno(ano).buscar(mes).buscar(dia).contList() == 0) {
                        System.out.println("O dia " + dia + " está livre.");
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private static void verificarMesesSemAtividade(){
        System.out.println("\n");
        System.out.println("Ano: ");
        ano = input.nextInt();
        
        if(geral.getChaves().contains(ano)){
            ArrayList <Integer> mesesCadastrados = geral.buscarAno(ano).getChaves();
            
            for(int mes = 1; mes < 13; mes++){
                if(!mesesCadastrados.contains(mes)){
                    System.out.println("Meses Sem atividades: " + mes + ",");
                }
            }
        }
        else{
            System.out.println("Ano não registrado");
        }
    }

    private static void verMesMaisAtarefado() {
        System.out.println("\nQual ano deseja verificar");
        System.out.println("Ano: ");
        ano = input.nextInt();
        
        int quantidadeMaximaDeTarefasVistasNosMeses = -1;
        int mesComMaiorQuantidadeDeTarefas = 0;
        int quantidadeTarefasNoMes = 0;
        
        ArrayList<Integer> mesesRegistrados = geral.buscarAno(ano).getChaves();
        
        for (int mes = 1; mes <= 12; mes++) {
            if (mesesRegistrados.contains(mes)) {
                final ArrayList<Integer> diasRegistrados = geral.buscarAno(ano).buscar(mes).getChaves();
            
                for (int dia = 1; dia <= LocalDate.of(ano, mes, 1).lengthOfMonth(); dia++) {
                    if (diasRegistrados.contains(dia)) {
                        quantidadeTarefasNoMes += geral.buscarAno(ano).buscar(mes).buscar(dia).contList();
                    }
                }
                if (quantidadeTarefasNoMes > quantidadeMaximaDeTarefasVistasNosMeses) {
                    quantidadeMaximaDeTarefasVistasNosMeses = quantidadeTarefasNoMes;
                    mesComMaiorQuantidadeDeTarefas = mes;
                }
                quantidadeTarefasNoMes = 0;
            }
        }
        
        if (quantidadeMaximaDeTarefasVistasNosMeses == -1 || mesComMaiorQuantidadeDeTarefas == 0) {
            System.out.println("Agenda Sem Tarefas Inicializadas");
        } else {
            System.out.println("O Mês Com Mais Tarefas é: " + mesComMaiorQuantidadeDeTarefas + 
                    "\nCom " + quantidadeMaximaDeTarefasVistasNosMeses + " tarefa(s)");
        }
        
        
    }

    private static void verMesMenosAtarefado() {
        System.out.println("\nQual ano deseja verificar");
        System.out.println("Ano: ");
        ano = input.nextInt();
        
        int quantidadeMaximaDeTarefasVistasNosMeses = -1;
        int mesComMenorQuantidadeDeTarefas = Integer.MAX_VALUE;
        int quantidadeTarefasNoMes = 0;
        
        ArrayList<Integer> mesesRegistrados = geral.buscarAno(ano).getChaves();
        
        for (int mes = 1; mes <= 12; mes++) {
            if (mesesRegistrados.contains(mes)) {
                final ArrayList<Integer> diasRegistrados = geral.buscarAno(ano).buscar(mes).getChaves();
            
                for (int dia = 1; dia <= LocalDate.of(ano, mes, 1).lengthOfMonth(); dia++) {
                    if (diasRegistrados.contains(dia)) {
                        quantidadeTarefasNoMes += geral.buscarAno(ano).buscar(mes).buscar(dia).contList();
                    }
                }
                if (quantidadeMaximaDeTarefasVistasNosMeses > quantidadeTarefasNoMes) {
                    quantidadeMaximaDeTarefasVistasNosMeses = quantidadeTarefasNoMes;
                    mesComMenorQuantidadeDeTarefas = mes;
                }
                
                quantidadeTarefasNoMes = 0;
            }
        }
        
        if (quantidadeMaximaDeTarefasVistasNosMeses == -1 || mesComMenorQuantidadeDeTarefas == Integer.MAX_VALUE) {
            System.out.println("Agenda Sem Tarefas Inicializadas");
        } else {
            System.out.println("O Mês Com Menos Tarefas é: " + mesComMenorQuantidadeDeTarefas + 
                    "\nCom " + quantidadeMaximaDeTarefasVistasNosMeses + " tarefa(s)");
        }
    }

    private static void verTodasAsTarefas(){
        ArrayList <Integer> anosRegistrados = geral.getChaves();
        
        for(final int ano : anosRegistrados)
        {
            System.out.print(ano);
            ArrayList <Integer> mesesRegistrados = geral.buscarAno(ano).getChaves();
            
            for (final int mes : mesesRegistrados) {
                System.out.print("/" + mes);
                ArrayList<Integer> diasRegistrados = geral.buscarAno(ano).buscar(mes).getChaves();
                
                for (final int dia : diasRegistrados) {
                    System.out.println("/" + dia);
                    System.out.println(geral.buscarAno(ano).buscar(mes).buscar(dia));
                }
            }
        }
    }
}
