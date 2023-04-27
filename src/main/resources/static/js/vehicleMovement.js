$('document').ready(function() {

	$('.table .btn-primary').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicleMovement, status) {
			$('#idEdit').val(vehicleMovement.id);
			$('#ddlVehicleEdit').val(vehicleMovement.vehicleid);
			$('#ddlLocation1Edit').val(vehicleMovement.locationid1);
			$('#ddlLocation2Edit').val(vehicleMovement.locationid2);

			var date1 = vehicleMovement.date1.substr(0, 10);
			var date2 = vehicleMovement.date2.substr(0, 10);
			$('#date1Edit').val(date1);
			$('#date2Edit').val(date2);
			$('#remarksEdit').val(vehicleMovement.remarks);
		});
		$('#editModal').modal();
	});

	$('table #detailsButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicleMovement, status) {
			$('#idDetail').val(vehicleMovement.id);
			$('#ddlVehicleDetail').val(vehicleMovement.vehicleid);
			$('#ddlLocation1Detail').val(vehicleMovement.locationid1);
			$('#ddlLocation2Detail').val(vehicleMovement.locationid2);

			var date1 = vehicleMovement.date1.substr(0, 10);
			var date2 = vehicleMovement.date2.substr(0, 10);
			$('#date1Detail').val(date1);
			$('#date2Detail').val(date2);
			$('#remarksDetail').val(vehicleMovement.remarks);
		});
		$('#detailModal').modal();
	});

	$('.table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();
	});
});