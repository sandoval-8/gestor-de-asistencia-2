package com.example.demo.controller.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class calendario {
	
	//---------------- DEVUELVE EL DIA DE LA SEMANA ----------------------
	
	public String diaDeLaSemana(Calendar primeraFecha) {
	    int d = primeraFecha.get(7);
	    switch (d) {
	      case 1:
	        return "DOM";
	      case 2:
	        return "LUN";
	      case 3:
	        return "MAR";
	      case 4:
	        return "MIER";
	      case 5:
	        return "JUEV";
	      case 6:
	        return "VIER";
	      case 7:
	        return "SAB";
	    } 
	    return null;
	  }
	  
	//--------------------- DEVUELVE RANGO DE DIAS ---------------------------
	
	  public ArrayList<Calendar> rangoDias(Calendar fechaInicial, Calendar fechaFinal) {
		  
	    ArrayList<Calendar> listaDias = new ArrayList<>();
	    
	    Calendar fecha = fechaInicial;
	    
	    System.out.println("MES NUMERO: " + fechaInicial.get(2));
	    System.out.println("MES NUMERO: " + fechaFinal.get(2));
	    
	    int diaInicial = fecha.get(5);
	    int mesInicial = fecha.get(2);
	    
	    System.out.println(String.valueOf(diaInicial) + "/" + mesInicial);
	    
	    int diaFinalMes = fecha.getMaximum(5);
	    int contadorDias = diaInicial;
	    int contadorMeses = mesInicial;
	    
	    while (!fecha.equals(fechaFinal)) {
	      if (contadorDias == diaFinalMes) {
	        fecha.set(5, contadorDias);
	        fecha.set(2, contadorMeses);
	        Calendar calendar = Calendar.getInstance();
	        calendar.set(fecha.get(1), fecha.get(2), fecha.get(5));
	        listaDias.add(calendar);
	        contadorMeses++;
	        contadorDias = 1;
	        continue;
	      } 
	      fecha.set(5, contadorDias);
	      fecha.set(2, contadorMeses);
	      System.out.println(String.valueOf(fecha.get(5)) + "/" + fecha.get(2) + "/" + fecha.get(1));
	      contadorDias++;
	      Calendar FECHA = Calendar.getInstance();
	      FECHA.set(fecha.get(1), fecha.get(2), fecha.get(5));
	      listaDias.add(FECHA);
	    } 
	    return listaDias;
	  }
	  
	  public Calendar comprobar(String fecha) {
	    SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = null;
	    try {
	      date = d.parse(fecha);
	      System.out.println("MES DE LA FECHA: " + date.getMonth());
	    } catch (ParseException e) {
	      JOptionPane.showMessageDialog(null, "Formato Incorrecto");
	      e.printStackTrace();
	    } 
	    Calendar FECHA = Calendar.getInstance();
	    FECHA.setTime(date);
	    System.out.println("MES DE LA FECHA::" + FECHA.get(2));
	    return FECHA;
	  }
}
