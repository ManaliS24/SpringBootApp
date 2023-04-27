$('document').ready(function() {
	$('table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(employee, status) {
			$('#txtUsernameEdit').val(employee.username);
			$('#txtAddressEdit').val(employee.address);
			$('#txtCityEdit').val(employee.city);
			$('#ddlNationalityEdit').val(employee.countryid);			
			var dob = employee.dateOfBirth.substr(0,10);
			$('#txtDateOfBirthEdit').val(dob);
			$('#txtEmailEdit').val(employee.email);
			$('#txtFirstnameEdit').val(employee.firstname);
			$('#ddlGenderEdit').val(employee.gender);
			$('#txtIdEdit').val(employee.id);
			$('#txtInitialsEdit').val(employee.initials);
			$('#txtLastnameEdit').val(employee.lastname);
			$('#ddlMaritalStatusEdit').val(employee.maritalStatus);
			$('#txtMobileEdit').val(employee.mobile);
			$('#txtOthernameEdit').val(employee.othername);		
			$('#txtPhoneEdit').val(employee.phone);			
			$('#fupPhotoEdit').val(employee.photo);			
			$('#txtSSNEdit').val(employee.socialSecurityNumber);			
			$('#ddlStateEdit').val(employee.stateid);	
			$('#ddlTitleEdit').val(employee.title);			
			$('#ddlEmployeeTypeEdit').val(employee.employeetypeid);				
			var hireDate = employee.hireDate.substr(0,10);
			$('#txtHireDateEdit').val(hireDate);
			$('#ddlJobTitleEdit').val(employee.jobtitleid);
		});
		$('#editModal').modal();
	});

	/*$('table #detailsButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicleHire, status) {
			$('#idDetails').val(vehicleType.id);
			$('#descriptionDetails').val(vehicleType.description);
			$('#detailsDetails').val(vehicleType.details);
			$('#lastModifiedByDetails').val(vehicleType.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleType.lastModifiedDate.substr(0,19).replace("T", " "));
		});
		$('#detailModal').modal();
	});*/

	$('.table #photoButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #employeePhoto').attr('src', href);
		$('#photoModal').modal();
	});
	
	
});