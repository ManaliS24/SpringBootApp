$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(vehicleType, status){
			$('#idedit').val(vehicleType.id);
			$('#descriptionedit').val(vehicleType.description);
			$('#detailsedit').val(vehicleType.details);
		});
		$('#editModal').modal();
	});
	
	$('table #detailButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(vehicleType, status){
			$('#iddetail').val(vehicleType.id);
			$('#descriptiondetail').val(vehicleType.description);
			$('#detailsdetail').val(vehicleType.details);
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