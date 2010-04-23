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
	initialize : function(src, container, config) {
		if (config == undefined) {
			config = {max : 5, duracion: 10, offset : 0};
		}
	
		this.src = src;
		this.container = container;
		this.max = (config.max) ? config.max : 5;
		this.duration = (config.duration) ? config.duration : 10;
		this.offset = (config.offset) ? config.offset : 0;
		
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
			
			new Ajax.Request(this.src,  {
				method: 'post',
				parameters : {first : first, max : max},
				onComplete: function(transport) {
				 	response = transport.responseText.evalJSON(true);
					if (response.responseCode === 'success') {

						// parse listings source
						listings = response.listings;
						
						// start over listings, if empty
						if ($A(listings).size() === 0) {
							this.offset = 1;
							this.display(this.container, this.offset, this.max);
							return;
						}	
						
						// create table
						table = new Element('table',{
							id: 'last_added_items_table', 
							width: '100%', 
							style : 'display:none;'
						});

						
						// iterate listings
						$A(listings).each(function(e) {
							
							// table row
							tr = new Element('tr');
							
							// item image
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
							
							// new item icon
							td.insert(new Element('img', {
								src : 'images/new_transparent.gif'}
							));
							
							// item description
							desc = new Element('div').update(e.itemDesc);
							desc.addClassName('gray smaller');
							if (window.console) console.debug(e.itemDesc);
							td.insert(desc);
							
							
							// item price
							priceText = 
								e.currency.currencyAbrev + ' ' + 
								e.currency.currencySymbol + format_currency(e.itemPrice);
							price = new Element('div', { style : 'margin-top: 10px'
							}).update(priceText);
							price.addClassName('listingPriceMedium');
							td.insert(price);

							// buttons
							button = new Element('input', {
								type : 'button',
								value : 'Ver Detalle',
								style: 'margin-right: 2px; font-family: verdana; font-size: 11px'
							}).observe('click', function(event) {
								window.location.href='catalog.jspa?aid=detail&item='+e.itemId;
							});
							td.insert(button);
							button = new Element('input', {
								type : 'button',
								value : 'Comprar',
								style: 'margin-right: 2px; font-family: verdana; font-size: 11px'
							}).observe('click', function(event) {
								add_to_cart(e.itemId,1, false);
							});
							td.insert(button);
							tr.insert(td);
							

							// add row to table
							table.insert(tr);
						}); 
						
						// append table to container
						container.insert(table);
						
						// show table
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

function format_currency(num) {
	num = num.toString().replace(/\$|\,/g,'');
	if(isNaN(num))
	num = "0";
	sign = (num == (num = Math.abs(num)));
	num = Math.floor(num*100+0.50000000001);
	cents = num%100;
	num = Math.floor(num/100).toString();
	if(cents<10)
	cents = "0" + cents;
	for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
	num = num.substring(0,num.length-(4*i+3))+','+
	num.substring(num.length-(4*i+3));
	return (((sign)?'':'-') + num + '.' + cents);
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


function show_category_bubble(caller) {
	container = $('category_bubble');
	if (!container) return;
	new Effect.BlindDown(container,{duration: 0.3});
	Event.observe(window,'click', function () {
		container.hide({duration: 0.5});
		container.update('');
	});
	
	// ajax controller call
	new Ajax.Request('catalog.jspa?aid=allCategories',  {
		method: 'post',
		onComplete: function(transport) {
		 	response = transport.responseText.evalJSON();
		 	if (response.responseCode === 'success') {

		 		table = new Element('table',{ width: '100%'});
		 		
				// parse categories source
				categories = response.categories;
				tr = new Element('tr');
				td = new Element('td',{valign: 'top'});
				td.insert(new Element('h3').update('Categorias'));
				div = new Element('div',{
					style: 'overflow:auto;width:100%;height:300px'
				});
				$A(categories).each(function(e) {
					li = new Element('li');
					li.update(new Element(
						'a',{href:'catalog.jspa?aid=browse&c='+e.categoryId
					}).update(e.description));
					div.insert(li);					
				});
				td.insert(div);
				tr.insert(td);
				
				// featured stores and brands cell
				td = new Element('td', {valign: 'top', style: 'width: 170px'});
				td.insert(new Element('h3').update('Especiales'));
				
				ul = new Element('ul');
				ul.insert(new Element('li').update('Top 10').addClassName('top_ten'));
				ul.insert(new Element('li').update('Ofertas de Hoy').addClassName('today_deals'));
				td.insert(ul);
				
				// brands and stores
				
				div = new Element('div',{id : 'featured_brands'});
				td.insert(div);
				tr.insert(td);
				
				// update featured brands
				new Ajax.Request('catalog.jspa?aid=featuredBrands', {
					method: 'post',
					onComplete: function(transport) {
						response = transport.responseText.evalJSON();
						if (response.responseCode === 'success') {
							brands = response.brands;
							div.insert(new Element('h3').update('Recomendados'));
							$A(brands).each(function(e) {
								img = new Element('img',{
									src:'catalog.jspa?aid=brandImage&brand='+e.brandId,
									style : 'align: middle'
								});
								$('featured_brands').insert(img);					
							});
						}
					}
				});

				// add row to table
				table.insert(tr);
				container.insert(table);
		 	}
		},
		
		onFailure: function(transport) {
			alert('Error de Transporte');
		}
	});
	
}
