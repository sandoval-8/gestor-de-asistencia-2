package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.personDTO;
import com.example.demo.controller.util.archivoPdf;
import com.itextpdf.text.pdf.PdfReader;

@Controller
public class resourceController {

	private Logger log = LoggerFactory.getLogger(resourceController.class);

	@PostMapping("/download")
	@ResponseBody
	public void descargar(@RequestBody personDTO persona, HttpServletResponse response) throws IOException {
		log.info("Comenzo el evento descarga");
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + "planilla-asistencia.pdf");
		response.setHeader("Content-Transfer-Encoding", "binary");

		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		personDTO persona2 = new personDTO("lucas", "sandoval", "Promotor de salud", "CIC LA PAZ", "8hs a 14hs", "37006");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\lucas\\Desktop\\planilla.pdf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		archivoPdf archivoDescarga = new archivoPdf(persona, "01/01/2021", "15/01/2021", bos, fis);
		PdfReader arch = archivoDescarga.campoTextos();

		bos.close();
		response.flushBuffer();
	}
}
