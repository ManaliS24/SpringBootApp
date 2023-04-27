$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(vehicleModel, status){
			$('#idedit').val(vehicleModel.id);
			$('#descriptionedit').val(vehicleModel.description);
			$('#detailsedit').val(vehicleModel.details);
		});
		$('#editModal').modal();
	});
	
	$('table #detailButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(vehicleModel, status){
			$('#iddetail').val(vehicleModel.id);
			$('#descriptiondetail').val(vehicleModel.description);
			$('#detailsdetail').val(vehicleModel.details);
			$('#createdbydetail').val(vehicleModel.createdBy);
			var createddate=vehicleModel.createdDate;
			if(createddate != undefined && createddate !== null){
				$('#createddatedetail').val(vehicleModel.createdDate.substr(0,19).replace("T", " "));}
			$('#lastupdatedbydetail').val(vehicleModel.lastModifiedBy);
			$('#lastupdatedondetail').val(vehicleModel.lastModifiedDate.substr(0,19).replace("T", " "));
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