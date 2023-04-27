$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(jobTitle, status){
			$('#idedit').val(jobTitle.id);
			$('#descriptionedit').val(jobTitle.description);
			$('#detailsedit').val(jobTitle.details);
		});
		$('#editModal').modal();
	});
	
	$('table #detailButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(jobTitle, status){
			$('#iddetail').val(jobTitle.id);
			$('#descriptiondetail').val(jobTitle.description);
			$('#detailsdetail').val(jobTitle.details);
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