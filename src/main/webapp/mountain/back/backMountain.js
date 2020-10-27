
$("#nPSelect").on("change",function(){
	
	let val = $(this).val() ;
	console.log(val);
	if( val == 300){
		$(".scopeQuery").hide();
		$(".scopeQuery").eq(0).show();
	}else if( val == 301){
		$(".scopeQuery").hide();
		$(".scopeQuery").eq(1).show();
	}else if( val == 302 ){
		$(".scopeQuery").hide();
		$(".scopeQuery").eq(2).show();
	}
	
});