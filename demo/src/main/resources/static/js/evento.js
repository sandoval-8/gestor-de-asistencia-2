/**
 * 
 */
$(function() {
	console.log("Hola2");
});
$(".opciones").click(
	function(e) {
		/*		var option = $("option:selected"); */
		var option = $("e.target");
		console.log({ "id": $(this).attr("value"), "nombreCentro": $(this).text() }),
			$.ajax({
				type: "POST",
				url: "/lista/forCentro",
				/*		data: JSON.stringify({ "id": option.attr("value"), "nombreCentro": option.text() }), */
				data: JSON.stringify({ "id": $(this).attr("value"), "nombreCentro": $(this).text() }),
				dataType: "json",
				contentType: "application/json",
				success: function(response) {
					var element = response;
					console.log("respuesta: "+element[1]);
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
var id;
var nombreCentro;
$("#target").change(function() {
	$("select option:selected").each(function() {
		id = $(this).attr("value");
		nombreCentro = $(this).text();
		console.log(id + " " + nombreCentro);
	});
})
$("#legajo").blur(function(){
	console.log("Se ejecuto evento blur");
	console.log("legajo " + $("#legajo").val());
	$.ajax({
		type: "GET",
		url: "lista/persona/legajo",
		data: JSON.stringify({
//			"id": $("#id").val()
			"legajo": $("#legajo").val()
		}),
		dataType: "json",
		contentType: "application/json",
		success: function(response){
			console.log("respuesta del servidor "+response);
		}
	});
})
var mostrarModal = {"opacity": "1",
	"z-index": "5",
	"pointer-events": "auto"};
function actualizar(){
	$("#miModal2").css(mostrarModal);
}
function crear(){
	$("#miModal").css(mostrarModal);
}
function cargarDatos() {
	console.log({
		"nombre": $("#nombre").val(),
		"apellido": $("#apellido").val(),
		"funcion": $("#funcion").val(),
		"centroSalud": {
			"id": id,
			"nombreCentro": nombreCentro
		},
		"oficina": $("#oficina").val(),
		"horario": $("#horario").val(),
		"legajo": $("#legajo").val()

	});
	$.ajax({
		type: "POST",
		url: "/lista",
		data: JSON.stringify({
			"nombre": $("#nombre").val(),
			"apellido": $("#apellido").val(),
			"funcion": $("#funcion").val(),
			"centroSalud": {
				"id": id
/*				"nombreCentro": nombreCentro */
			},
			"oficina": $("#oficina").val(),
			"horario": $("#horario").val(),
			"legajo": $("#legajo").val()

		}),
		dataType: "json",
		contentType: "application/json"
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