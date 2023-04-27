$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(state, status){
			$('#idedit').val(state.id);
			$('#nameedit').val(state.name);
			$('#capitaledit').val(state.capital);
			$('#codeedit').val(state.code);
			$('#detailsedit').val(state.details);
			//$('#ddlCountryedit').val(state.countryid);
		});
		$('#editModal').modal();
	});
	
	$('table #detailButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(state, status){
			$('#iddetail').val(state.id);
			$('#namedetail').val(state.name);
			//$('#ddlCountrydetail').val(state.countryid);
			$('#capitaldetail').val(state.capital);
			$('#codedetail').val(state.code);
			$('#detailsdetail').val(state.details);
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