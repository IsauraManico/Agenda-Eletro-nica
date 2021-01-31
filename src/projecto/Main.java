package projecto;
import java.time.LocalDate;  // import the LocalDate class
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        //LocalDateTime myObj = LocalDateTime.now(); 
        Scanner input = new Scanner(System.in);
        HashMap geral = new HashMap();
        int ano;
        
        System.out.println("Inserção da Data:");
        System.out.println("Ano: ");
        ano = input.nextInt();
        System.out.println("Mês: ");
        int mes = input.nextInt();
        System.out.println("Dia: ");
        int dia = input.nextInt();
        
        
        System.out.println("Hora: ");
        int hora = input.nextInt();
        System.out.println("Minutos: ");
        int minutos = input.nextInt();
        
        System.out.println("Descrição: ");
        String descString = input.next();
        
        System.out.println("Local: ");
        String local = input.next();
        
        System.out.println("Lembrete: ");
        int lembrete = input.nextInt();
        
        System.out.println("Periocidade: ");
        int periocidade = input.nextInt();
        
        Tarefa novaTarefa = new Tarefa(LocalDateTime.of(ano, mes, dia, hora, minutos, LocalDateTime.now().getSecond()),
                descString, local, lembrete, periocidade);
        
        
        geral.inserirAno(ano, novaTarefa);
        
        
        LocalDateTime myObj = LocalDateTime.of(2030, Month.MARCH, 14, 18, 30, 59);
        System.out.println(myObj.getYear());
        System.out.println(myObj.getMonth());
        System.out.println(myObj.getDayOfMonth());
        System.out.println(myObj.getDayOfWeek());
        System.out.println(myObj.getHour());
        System.out.println(myObj.getMinute());
        System.out.println(myObj.getSecond());
        System.out.println(myObj.getNano());
        System.out.println(myObj);
    }
}
