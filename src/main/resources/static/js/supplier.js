	$('document').ready(function() {
		
		$('.table .btn-primary').on('click',function(event){		
			event.preventDefault();		
			var href= $(this).attr('href');		
			$.get(href, function(supplier, status){
				$('#txtAddressEdit').val(supplier.address);
				$('#txtCityEdit').val(supplier.city);
				$('#ddlCountryEdit').val(supplier.countryid);
				$('#txtDetailsEdit').val(supplier.details);
				$('#txtEmailEdit').val(supplier.email);
				$('#txtIdEdit').val(supplier.id);
				$('#txtMobileEdit').val(supplier.mobile);
				$('#txtNameEdit').val(supplier.name);	
				$('#txtPhoneEdit').val(supplier.phone);			
				$('#ddlStateEdit').val(supplier.stateid);	
				$('#txtWebsiteEdit').val(supplier.website);
			});			
			$('#editModal').modal();		
		});
		
		$('table #detailsButton').on('click',function(event){
			event.preventDefault();
			var href=$(this).attr('href');
			$.get(href, function(supplier, status){
				$('#txtAddressDetail').val(supplier.address);
				$('#txtCityDetail').val(supplier.city);
				$('#ddlCountryDetail').val(supplier.countryid);
				$('#txtDetailsDetail').val(supplier.details);
				$('#txtEmailDetail').val(supplier.email);
				$('#txtIdDetail').val(supplier.id);
				$('#txtMobileDetail').val(supplier.mobile);
				$('#txtNameDetail').val(supplier.name);	
				$('#txtPhoneDetail').val(supplier.phone);			
				$('#ddlStateDetail').val(supplier.stateid);	
				$('#txtWebsiteDetail').val(supplier.website);
			});
			$('#detailModal').modal();
		});
		
		$('.table #deleteButton').on('click',function(event) {
			event.preventDefault();
			var href = $(this).attr('href');
			$('#confirmDeleteButton').attr('href',href);
			$('#deleteModal').modal();		
		});	
	});