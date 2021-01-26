/**
 * 
 */
$(function() {
	console.log("Hola2");
});
var element;
function consultarCentro(id_centro,nombre_centro) {
	$.ajax({
		type: "POST",
		url: "/lista/forCentro",
		/*		data: JSON.stringify({ "id": option.attr("value"), "nombreCentro": option.text() }), */
		/* 		data: JSON.stringify({ "id": $(this).attr("value"), "nombreCentro": $(this).text() }),*/
		data: JSON.stringify({ "id": id_centro, "nombreCentro": nombre_centro }),
		dataType: "json",
		contentType: "application/json",
		success: function(response) {
			element = response;
			console.log("respuesta: " + element[1]);
			if (element.length > 0) {
				$("tbody").html("")
				for (var i = 0; i < element.length; i++) {
					console.log(element[i].centroSalud.nombreCentro);
					$("tbody").append("<tr><td>" + element[i].id + "</td>"
						+ "<td>" + element[i].nombre + "</td>"
						+ "<td>" + element[i].apellido + "</td>"
						+ "<td>" + element[i].centroSalud.nombreCentro + "</td>"
						+ "<td>" + element[i].funcion + "</td>"
						+ "<td>" + element[i].oficina + "</td>"
						+ "<td>" + element[i].horario + "</td>"
						+ "<td>" + element[i].legajo + "</td></tr>");
				}
			} else {
				$("tbody").html(
					"<tr><td>" + element.id + "</td>"
					+ "<td>" + element.nombre + "</td>"
					+ "<td>" + element.apellido + "</td>"
					+ "<td>" + element.centroSalud + "</td>"
					+ "<td>" + element.funcion + "</td>"
					+ "<td>" + element.oficina + "</td>"
					+ "<td>" + element.horario + "</td>"
					+ "<td>" + element.legajo + "</td></tr>");
			}

		}

	});
}
$(".opciones").click(
	function(e) {
		/*		var option = $("option:selected"); */
		var option = $("e.target");
		console.log({ "id": $(this).attr("value"), "nombreCentro": $(this).text() });
		var id_centro = $(this).attr("value");
		var nombre_centro = $(this).text();
		consultarCentro(id_centro,nombre_centro);		
			
	});
$("#asideItems a").click(function(e) {
	var elemento = e.target;
	$("#asideItems a").css("background-color", "#5c5c5c");
	$(this).css("background-color", "#787878");
});
$("#asideItems a").hover(function(e) {
	$("#asideItems a").css("background-color", "#5c5c5c");
	$(this).css("background-color", "#7091ff");
});

/*------------------------ EVENTOS DEL MODAL ----------------------------------------*/

/* MODAL */
var mostrarModal = {
	"opacity": "1",
	"z-index": "5",
	"pointer-events": "auto"
};
var ocultarModal = {
	"opacity": "0",
	"pointer-events": "none"
};
function actualizarMostrar() {
	$("#miModal_editar").css(mostrarModal);
}
function crearMostrar() {
	$("#miModal_create").css(mostrarModal);
}
function actualizarOcultar(){
	$("#miModal_editar").css(ocultarModal);
}
function crearOcultar(){
	$("#miModal_create").css(ocultarModal);
}

/*------------------------------------------------------------------------------------*/

/* Evento que almacena los datos de la etiqueta SELECT */
var id_crear;
var nombreCentro_crear;
$("#target_crear").change(function() {
	$("#target_crear option:selected").each(function() {
		id_crear = $(this).attr("value");
		nombreCentro_crear = $(this).text();
		console.log(id_crear + " - - " + nombreCentro_crear);
	});
})
/*  CREA NUEVA PERSONA (Envia los datos del formulario) */
function createPerson() {
	$.ajax({
		type: "POST",
		url: "/lista",
		data: JSON.stringify({
			"nombre": $("#nombre_crear").val(),
			"apellido": $("#apellido_crear").val(),
			"funcion": $("#funcion_crear").val(),
			"centroSalud": {
				"id": id_crear
				/*				"nombreCentro": nombreCentro */
			},
			"oficina": $("#oficina_crear").val(),
			"horario": $("#horario_crear").val(),
			"legajo": $("#legajo_crear").val()

		}),
		dataType: "json",
		contentType: "application/json",
		success: function(response){
			crearOcultar()
			consultarCentro(id_crear,nombreCentro_crear);
		}		
	});
}
/*------------------------------------------------------------------------------------*/
var id_editar;
var nombreCentro_editar;
function buscar_centro(){
	$("#target_editar option:selected").each(function() {
		id_editar = $(this).attr("value");
		nombreCentro_editar = $(this).text();
		console.log(id_editar + " - - " + nombreCentro_editar);
	});
}
$("#target_editar").change(function() {
	buscar_centro();
})
/*  EDITA NUEVA PERSONA (Envia los datos del formulario) */
function editPerson() {
	console.log(id_a_editar);
	console.log("-"+id_editar+"-")
	$.ajax({
		type: "PUT",
		url: "/lista",
		data: JSON.stringify({
			"id": id_a_editar,
			"nombre": $("#nombre_editar").val(),
			"apellido": $("#apellido_editar").val(),
			"funcion": $("#funcion_editar").val(),
			"centroSalud": {
				"id": id_editar,
				"nombreCentro": nombreCentro_editar
				/*				"nombreCentro": nombreCentro */
			},
			"oficina": $("#oficina_editar").val(),
			"horario": $("#horario_editar").val(),
			"legajo": $("#legajo_editar").val()

		}),
		dataType: "json", //Tipo de dato RECIBIDO del servidor
		contentType: "application/json", //Tipo de dato ENVIADO
		success: function(response) {
			actualizarOcultar();
			consultarCentro(id_editar,nombreCentro_editar);
		}
	});
}
/* Consulta la existencia de ésta persona */
var id_a_editar;
$("#legajo_editar").blur(function() {
	console.log("Se ejecuto evento blur");
	console.log("legajo " + $("#legajo_editar").val());
	$.ajax({
		type: "GET",
		url: "lista/persona/legajo/" + $("#legajo_editar").val(),
		dataType: "json", //Tipo de dato recibido del servidor
		success: function(response) {
			console.log("respuesta del servidor " + response.nombre);
			id_a_editar = response.id;
			$("#nombre_editar").val(response.nombre);
			$("#apellido_editar").val(response.apellido);
			$("#funcion_editar").val(response.funcion);
			$("#target_editar option[value=" + response.centroSalud.id + "]").attr("selected", true);
			$("#oficina_editar").val(response.oficina);
			$("#horario_editar").val(response.horario);
			buscar_centro();
		}
	});
})
//--------------------------------------------------------------------------------------
function descargar(){
	console.log(element);
	descargarPDF();
}

function descargarPDF(){
	$.ajax({
		type: "POST",
		url: "/download",
		data: JSON.stringify({element}),
		/*JSON.stringify({
//			"id": id_a_editar,
			"nombre": $("#nombre_editar").val(),
			"apellido": $("#apellido_editar").val(),
			"funcion": $("#funcion_editar").val(),
			"centroSalud": {
				"id": id_editar,
				"nombreCentro": nombreCentro_editar
				/*				"nombreCentro": nombreCentro */
	/*		},
			"oficina": $("#oficina_editar").val(),
			"horario": $("#horario_editar").val(),
			"legajo": $("#legajo_editar").val()

		}), */
		dataType: "json", //Tipo de dato RECIBIDO del servidor
		contentType: "application/json", //Tipo de dato ENVIADO
	});
}
/* $("a").click(
	function(e) {
		var id = $(this).attr("value");
		console.log(id);
		$.ajax({
			type: "GET",
			//      url: "/lista",
			url: "/lista/" + id,
			//     data: JSON.stringify({login: $(this).val()}),
			//      dataType: "dataType",
			success: function(response) {
				var element = response;
				//	        	console.log("tamaño respuesta: " + element.length);
				if (element.length > 0) {
					$("tbody").html("")
					for (var i = 0; i < element.length; i++) {
						//     		console.log(element[i].id + " " + element[i].nombre);
						$("tbody").append("<tr><td>" + element[i].id + "</td>"
							+ "<td>" + element[i].nombre + "</td>"
							+ "<td>" + element[i].apellido + "</td>"
							+ "<td>" + element[i].domicilio + "</td>"
							+ "<td>" + element[i].funcion + "</td>"
							+ "<td>" + element[i].oficina + "</td>"
							+ "<td>" + element[i].horario + "</td>"
							+ "<td>" + element[i].legajo + "</td></tr>");
					}
				} else {
					$("tbody").html(
						"<tr><td>" + element.id + "</td>"
						+ "<td>" + element.nombre + "</td>"
						+ "<td>" + element.apellido + "</td>"
						+ "<td>" + element.domicilio + "</td>"
						+ "<td>" + element.funcion + "</td>"
						+ "<td>" + element.oficina + "</td>"
						+ "<td>" + element.horario + "</td>"
						+ "<td>" + element.legajo + "</td></tr>");
				}
				          response.forEach(element => {
								console.log(element);
							  $("#tabla").append("<tr><td>"+element.id+"</td>"+
										"<td>"+element.nombre+"</td>"+
										"<td>"+element.apellido+"</td>"+
										"<td>"+element.domicilio+"</td>"+
										"<td>"+element.funcion+"</td>"+
										"<td>"+element.oficina+"</td>"+
										"<td>"+element.horario+"</td>"+
										"<td>"+element.legajo+"</td></tr>");
						  });
		});
		e.preventDefault();
	}); */