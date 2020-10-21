$("nav .top").on("mouseenter", extendFont).on("mouseleave", recoverFont)
let controller1 = true;
function extendFont() {
    if(controller1){
        $(this).css({
            "font-size": "200%"
        })
    }
}

function recoverFont() {
    if(controller1){
        $(this).css({
            "font-size": "150%"
        })
    }
}

$("nav div").on("click",(function(){
    controller1 = false
}))

$("nav").on("mouseenter",function(){
    if(!controller1){
        controller1 = true;
        $("nav div").css("font-size","150%");
    }
})

$("#container").ready(function(){
	$('.loading').animate({'width':'33%'},50); 
})
$("#content").ready(function(){
	$('.loading').animate({'width':'55%'},250); 
})
$("footer").ready(function(){
	$('.loading').animate({'width':'100%'},250,function(){
					$('#loading').fadeOut(); 
				});  
})



