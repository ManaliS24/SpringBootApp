$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(vehicleMake, status){
			$('#idedit').val(vehicleMake.id);
			$('#descriptionedit').val(vehicleMake.description);
			$('#detailsedit').val(vehicleMake.details);
		});
		$('#editModal').modal();
	});
	
	$('table #detailButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(vehicleMake, status){
			$('#iddetail').val(vehicleMake.id);
			$('#descriptiondetail').val(vehicleMake.description);
			$('#detailsdetail').val(vehicleMake.details);
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