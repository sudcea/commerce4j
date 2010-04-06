function highlight(id, ok) {
	if ($(id) && ($(id).type === 'text' || $(id).type === 'password' || $(id).type === 'select')) {
		$(id).addClassName('highlight');
	}
}

function display_form_messages(id, arr, className, input_errors) {

	d_title = document.createElement('strong');
	Element.insert(d_title,'Por favor verifique lo siguiente');
	
	$(id).update(d_title);
	$(id).addClassName(className);
	ul = document.createElement('ul');
	
	$A(arr).each(function(e) {
		li = document.createElement('li');
		Element.insert(li, e.value);
		ul.appendChild(li);	
		
		if (input_errors === true) {
			highlight(e.key);
			if ($(e.key) && ($(e.key).type === 'text' || $(e.key).type === 'password')) {
				errimg = new Element('img', {
					src : 'images/error.png',
					alt : e.value,
					style : 'margin-left: 2px; display: none'
				});
				errimg.addClassName('highlight');
				$(e.key).insert({after : errimg});
				new Effect.Appear(errimg);
			}
		}
		
	});
	
	$(id).appendChild(ul);
	new Effect.Appear(id);
}


function add_to_cart(item, quantity, redirect) {
	if (item == undefined) return false;
	
	var params = {
		item : item, 
		quantity : quantity
	};
	
	// ajax controller call
	new Ajax.Request('cart.jspa?aid=add',  {
		method: 'post',
		parameters: params,
		onComplete: function(transport) {
		 	response = transport.responseText.evalJSON();
		 	alert(response);
//			if (response.responseCode === 'success') 
//				process_registered_user(response.userId); 
//			else if (response.responseCode === 'failure') 
//				display_form_messages('d_msgs', response.errors, 'errors', true);
		},
		
		onFailure: function(transport) {
			alert('Error de Transporte');
		}
	});
	
}