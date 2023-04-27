$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(employeeType, status){
			$('#idedit').val(employeeType.id);
			$('#descriptionedit').val(employeeType.description);
			$('#detailsedit').val(employeeType.details);
		});
		$('#editModal').modal();
	});
	
	$('table #detailButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(employeeType, status){
			$('#iddetail').val(employeeType.id);
			$('#descriptiondetail').val(employeeType.description);
			$('#detailsdetail').val(employeeType.details);
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