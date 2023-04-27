$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(location, status){
			$('#idedit').val(location.id);
			$('#descriptionedit').val(location.description);
			$('#cityedit').val(location.city);
			$('#addressedit').val(location.address);
			$('#ddlCountryedit').val(location.countryid);
			$('#ddlStateedit').val(location.stateid);
			$('#detailsedit').val(location.details);
		});
		$('#editModal').modal();
	});
	
	$('table #detailButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(location, status){
			$('#iddetail').val(location.id);
			$('#descriptiondetail').val(location.description);
			$('#citydetail').val(location.city);
			$('#addressdetail').val(location.address);
			$('#ddlCountrydetail').val(location.countryid);
			$('#ddlStatedetail').val(location.stateid);
			$('#detailsdetail').val(location.details);
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