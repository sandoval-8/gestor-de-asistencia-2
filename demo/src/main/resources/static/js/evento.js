/**
 * 
 */
$(function() {
	console.log("Hola2");
});
$("a").click(
	function(e) {
/*		var option = $("option:selected"); */
        var option = $("e.target");
		console.log({"id": $(this).attr("value"), "nombreCentro": $(this).text()}),
		$.ajax({
			type: "POST",
			url: "/lista/forCentro",
	/*		data: JSON.stringify({ "id": option.attr("value"), "nombreCentro": option.text() }), */ 
			data: JSON.stringify({"id": $(this).attr("value"), "nombreCentro": $(this).text()}),
			dataType: "json",
			contentType: "application/json",
			success: function(response) {
				var element = response;
				
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
$("#asideItems a").click(function(){
	var elemento = e.target;
	$(this).css("background-color", "#53fc61");
});
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