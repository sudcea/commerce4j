
		

function register_user() {

	if (!$('f_registration'))  {
		alert('Form f_registration not found');
		return false;
	}
	
	// remover mensajes y alertas
	$$('input.highlight').each(function(e) {
		e.removeClassName('highlight');
	});
	$$('img.highlight').each(function(e) {
		e.remove();
	});
	
	// ajax controller call
	new Ajax.Request('profile.jspa?aid=processRegistration',  {
		method: 'post',
		parameters: $('f_registration').serialize(true),
		onComplete: function(transport) {
		 	response = transport.responseText.evalJSON();
			if (response.responseCode === 'success') 
				process_registered_user(response.userId); 
			else if (response.responseCode === 'failure') 
				display_form_messages('d_msgs', response.errors, 'errors', true);
		},
		
		onFailure: function(transport) {
			alert('Error de Transporte');
		}
	});

}

function process_registered_users(user_id) {
	alert('Usuario Registrado Exitosamente ' +  response.userId);
	window.location.href='home.jspa';
}
