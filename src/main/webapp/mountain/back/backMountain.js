
$("#nPSelect").on("change",function(){
	
	let val = $(this).val() ;
	if( val == '太魯閣國家公園'){
		$(".route").hide();
		$(".route").eq(0).show();
	}else if( val == '玉山國家公園'){
		$(".route").hide();
		$(".route").eq(1).show();
	}else if( val == '雪霸國家公園' ){
		$(".route").hide();
		$(".route").eq(2).show();
	}
	
});