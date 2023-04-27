$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(invoiceStatus, status){
			$('#idedit').val(invoiceStatus.id);
			$('#descriptionedit').val(invoiceStatus.description);
			$('#detailsedit').val(invoiceStatus.details);
		});
		$('#editModal').modal();
	});
	
	$('table #detailButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(invoiceStatus, status){
			$('#iddetail').val(invoiceStatus.id);
			$('#descriptiondetail').val(invoiceStatus.description);
			$('#detailsdetail').val(invoiceStatus.details);
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