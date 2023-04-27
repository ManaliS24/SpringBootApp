$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(country, status){
			$('#idedit').val(country.id);
			$('#descriptionedit').val(country.description);
			$('#capitaledit').val(country.capital);
			$('#codeedit').val(country.code);
			$('#continentedit').val(country.continent);
			$('#nationalityedit').val(country.nationality);
		});
		$('#editModal').modal();
	});
	$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		
		var href=$(this).attr('href');
		$('#confirmDeleteButton').attr('href',href);
		$('#deleteModal').modal();
	});
});