/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

import java.io.IOException;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author hugo
 */
public class Time {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args)throws  IOException {
        // TODO code application logic here
        tiempoDateTime();
        tiempoZoneDateTime();
        tiempoDuracion();
        obtenerFecha();
        
    }
    
    public static void obtenerFecha()
    {
        LocalDateTime hoy= LocalDateTime.now();
        
        int dia=hoy.getDayOfMonth();
        int mes=hoy.getMonthValue();
        int año=hoy.getMinute();
        int hora=hoy.getHour();
        int minuto=hoy.getMinute();
        int segundo=hoy.getSecond();
        //getDayYear,getDayOfMonth ---int   getDayWeek -- formato dia semana
        System.out.println("Obtener Fecha\n");
        System.out.println("Hoy: "+hoy);
        System.out.println("Dia: "+hoy.getDayOfMonth());
        System.out.println("mes: "+hoy.getMonth().toString());//formato Mes
        System.out.println("año: "+String.valueOf(hoy.getYear()));
        System.out.println("Hora: "+hoy.getHour());
        System.out.println("minuto: "+hoy.getMinute());
        System.out.println("MesValor: "+hoy.getMonthValue());//formatoInt
       String s = hoy.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
         System.out.println("Conversion fecha: "+s);        
        
        
        LocalDate hoy2= LocalDate.now();
        LocalDate mesSiguiente  =hoy2.plusDays(30);
        System.out.println("Pasado1mes: "+mesSiguiente);
        
        
    }
    
    
    public static void tiempoDateTime()
    {
        Clock reloj= Clock.systemUTC();
        
        LocalDate fecha= LocalDate.now();
        LocalDate fechaReloj= LocalDate.now(reloj);
        
       
        
        System.out.println("DATE/TIME\n");
        
        System.out.println("Fecha: "+fecha);
        System.out.println("Fecha reloj: "+fechaReloj);
       
        
        LocalTime tiempo=LocalTime.now();
        LocalTime tiempoReloj = LocalTime.now(reloj);
        
        System.out.println("Tiempo: "+tiempo);
        System.out.println("TiempoReloj: "+tiempoReloj);
        System.out.println("\n\n");
        
    }
    
    public static void tiempoZoneDateTime()
    {
        Clock reloj= Clock.systemUTC();
        
        System.out.println("ZONA HORARIA\n");
        
        ZonedDateTime  zdt = ZonedDateTime.now();
        ZonedDateTime  zdtReloj = ZonedDateTime.now(reloj);
        ZonedDateTime  zdtZona = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
        
        System.out.println("ZonaDateTime a secas: "+zdt);
        System.out.println("ZonaDateTime Reloj: "+zdtReloj);
        System.out.println("ZonaDateTime zobaHoraria: "+zdtZona);
        System.out.println("\n\n");
    }
    
    public static void tiempoDuracion()
    {
        
        LocalDateTime timePoint = LocalDateTime.now();
        LocalDateTime inicio= LocalDateTime.of(2015,9,16,22,30,45);
        ZoneId id = ZoneId.of("UTC+2");
        
        ZonedDateTime zdtInicio = ZonedDateTime.of(inicio,id);
        ZonedDateTime zdtFinal = ZonedDateTime.of(timePoint, id);
        
        Duration d=Duration.between(zdtInicio, zdtFinal);
        System.out.println("Duracion\n");
        System.out.println("Duracion Dias: "+d.toDays());
        System.out.println("Duracion Horas: "+d.toHours());
        System.out.println("Duration en String: "+d.toString());
        System.out.println("\n\n");
        
        
        
    }
    
}
