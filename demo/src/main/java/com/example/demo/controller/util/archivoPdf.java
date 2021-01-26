package com.example.demo.controller.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import com.example.demo.DTO.personDTO;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


public class archivoPdf {
	
	private String nombre;
	private String funcion;
	private String domicilio;
	private String oficina;
	private String horario;
	private String legajo;
	private String fechaInicial;	
	private String fechaFinal;
	private BufferedOutputStream salida;
	private FileInputStream entrada;

	public archivoPdf(String nombre, String funcion, String domicilio, String oficina, String horario, String legajo,
			String fechaInicial, String fechaFinal) {
		
		this.nombre = nombre;
		this.funcion = funcion;
		this.domicilio = domicilio;
		this.oficina = oficina;
		this.horario = horario;
		this.legajo = legajo;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}
	public archivoPdf(personDTO persona, String fechaInicial, String fechaFinal, BufferedOutputStream salida, FileInputStream entrada) {
		this.nombre = persona.getNombre();
		this.funcion = persona.getFuncion();
		this.domicilio = "NO SABO";
		this.oficina = persona.getOficina();
		this.horario = persona.getHorario();
		this.legajo = persona.getLegajo();
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.salida = salida;
		this.entrada = entrada;
	}

	public PdfReader campoTextos() {
		PdfReader reader = null;
		
		try {
			reader = new PdfReader(entrada);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//ESPECIFICA DONDE VA A CREAR EL ARCHIVO PDF

		File file = new File("C:\\planillas\\" + this.legajo + ".pdf");
		PdfStamper stamper = null;
		try {
			stamper = new PdfStamper(reader, salida);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			stamper.getAcroFields().setField("textLegajo", this.legajo);
			stamper.getAcroFields().setField("textQuincena", fechaInicial + " a " + fechaFinal);
			stamper.getAcroFields().setField("oficina", this.oficina);
			stamper.getAcroFields().setField("domicilio", this.domicilio);
			stamper.getAcroFields().setField("nombre", this.nombre);
			stamper.getAcroFields().setField("funcion", this.funcion);
			stamper.getAcroFields().setField("horario", this.horario);
			calendario CALENDARIO = new calendario();
			ArrayList<Calendar> lista = CALENDARIO.rangoDias(
					CALENDARIO.comprobar(fechaInicial),
					CALENDARIO.comprobar(fechaFinal));
			int tama = lista.size();
			int contador = 1;
			for (Calendar calendario : lista) {
				int mes = calendario.get(2) + 1;
				stamper.getAcroFields().setField("fecha" + contador, String.valueOf(calendario.get(5)) + "/" + mes);
				stamper.getAcroFields().setField("diaSemana" + contador, CALENDARIO.diaDeLaSemana(calendario));
				contador++;
			}
			stamper.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return reader;
	}

	public boolean existe() {
		return true;
	}
}
