$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(vehicleStatus, status){
			$('#idedit').val(vehicleStatus.id);
			$('#descriptionedit').val(vehicleStatus.description);
			$('#detailsedit').val(vehicleStatus.details);
		});
		$('#editModal').modal();
	});
	
	$('table #detailButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(vehicleStatus, status){
			$('#iddetail').val(vehicleStatus.id);
			$('#descriptiondetail').val(vehicleStatus.description);
			$('#detailsdetail').val(vehicleStatus.details);
		});
	$('#detailModal').modal();
	});
	
	$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		
		var href=$(this).attr('href');
		$('#confirmDeleteButton').attr('href',href);
		$('#deleteModal').modal();
	});
});