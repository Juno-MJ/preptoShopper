$(function(){
	//Solving the active menu problem
	//retrieves the global object menu
	
	switch(menu){
		
		case 'preptoShopper': $('#home').addClass('active');
	 				 	 	  break;
		
		case 'About Us': $('#about').addClass('active');
						 break;
						 
		case 'Contact': $('#contact').addClass('active');
		 			     break;
		 			     
		case 'All Products' : $('#listProducts').addClass('active');
							  break;
							  
							  
        default : $('#listProducts').addClass('active');
		  		  break;
	    
	}
	
});
