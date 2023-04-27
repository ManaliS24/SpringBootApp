$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(invoice, status){
			$('#idEdit').val(invoice.id);
			var invoiceDate=invoice.invoiceDate.substr(0,10);
			$('#invoiceDateEdit').val(invoiceDate);
			$('#remarksEdit').val(invoice.remarks);
			$('#ddlClientEdit').val(invoice.clientid);
			$('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);
			
		});
		$('#editModal').modal();
	});
	
	$('table #detailButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(invoice, status){
			$('#idDetails').val(invoice.id);
			var invoiceDate=invoice.invoiceDate.substr(0,10);
			$('#invoiceDateDetails').val(invoiceDate);
			$('#remarksDetails').val(invoice.remarks);
			$('#ddlClientDetails').val(invoice.clientid);
			$('#ddlInvoiceStatusDetails').val(invoice.invoicestatusid);
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