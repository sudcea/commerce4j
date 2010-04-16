if(typeof(Prototype) == "undefined")
    throw "Commerce4j Client Side Library Requires Prototype to be loaded.";

if(typeof(C4JBlocks) == 'undefined') 
	C4JBlocks = {};

/**
 * Last Added Items Block.
 */
C4JBlocks.LastAddedItems = Class.create({
	
	/**
	 * Block constructor, initializer.
	 * 
	 * @container the container to be painted with.
	 * @offset the first record to start with
	 * @max The max number of records to be shown.
	 * @duration The transition duration, in seconds.
	 */
	initialize : function(container, offset, max, duration) {
		this.offset = offset;
		this.max = max;
		this.duration = duration;
		this.container = container;
	},
	
	/**
	 * Start the transitions.
	 */
	start : function() {
		this.display(this.container , this.offset, this.max);
		this.offset += this.max;
		
		this.executer = new PeriodicalExecuter(function() {
			
			if ($('last_added_items_table')) {
				new Effect.Fade('last_added_items_table',{afterFinish: function() {
					$('last_added_items_table').remove();
					this.display(this.container, this.offset, this.max);	
				}.bind(this)});
				
			}
			this.offset += this.max;

		}.bind(this), this.duration);
	},
	
	/**
	 * Load and display data.
	 * 
	 */
	display : function(id ,first, max) {
		var container = $(id);
		if (container) {
			// ajax controller call
			
			new Ajax.Request('catalog.jspa?aid=lastAddedItems',  {
				method: 'post',
				parameters : {first : first, max : max},
				onComplete: function(transport) {
				 	response = transport.responseText.evalJSON();
					if (response.responseCode === 'success') {

						listings = response.listings;
						
						table = new Element('table',{id: 'last_added_items_table', width: '100%', style : 'display:none;'});

						if ($A(listings).size() === 0) {
							this.offset = 1;
							this.display(this.container, this.offset, this.max);
							return;
						}	
						
						$A(listings).each(function(e) {
							
							tr = new Element('tr');
							
							// imagen
							td = new Element('td', {width: 100});
							img = new Element('img', {src : 'images/img_not_available.png'});
							td.insert(img);
							tr.insert(td);

							// item title
							td = new Element('td', {valign: 'top'});
							a = new Element('a', {
								href:'catalog.jspa?aid=detail&item='+e.itemId
							}).update(e.itemTitle);
							td.insert(new Element('strong').insert(a));
							td.insert(new Element('img', {
								src : 'images/new_transparent.gif'}
							));
							
							// item description
							desc = new Element('div').update(e.itemDesc);
							desc.addClassName('gray smaller');
							td.insert(desc);
							
							
							// item price
							price = new Element('div', {style : 'margin-top: 10px'}).update(
								e.currency.currencyAbrev + ' ' + e.currency.currencySymbol + 
								e.itemPrice
							);
							price.addClassName('listingPriceMedium');
							td.insert(price);
							tr.insert(td);
							

							// add row to table
							
							table.insert(tr);
						}); 
						container.insert(table);
						table.appear();	
						
					}
					
				}.bind(this),
				
				onFailure: function(transport) {
					alert('Error de Transporte');
					this.executer.stop();
				}.bind(this)
			});
		}
	}
});

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