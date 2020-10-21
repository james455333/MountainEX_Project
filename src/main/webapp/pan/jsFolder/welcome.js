

$("#container").css("display","none")
$("body").append('<div id="homeCon">')
$("#homeCon").css( {
   
    "height" : $(window).height(),
    "width" : $(window).width(),
    "background-image" : "url('images/topBar1.png')", 
    "background-size":"cover",
    "overflow" : "auto"
    // "background"
}).append('<H1 id="bigTitle">岳進者</H1>');


$(window).on("resize",function(){
	$("#homeCon").css({
		 "height" : $(window).height(),
    "width" : $(window).width(),
	})
	if($("#homeCon").height()<450){
		$("#sliderCon").find("li").addClass("welcome_shrik").removeClass("wlecom_normal_li")
	}else {
		$("#sliderCon").find("li").removeClass("welcome_shrik").addClass("wlecom_normal_li")
	}

}).on("scroll",function(){
	$("#homeCon").css({
		 "height" : $(window).height(),
    "width" : $(window).width(),
	})
})

console.log(  )

$("#bigTitle").css({
    "position": "absolute",
    "top" : "0%",
    "left" : "10%",
    // "border" : "1px solid red",
    "font-size" : "600%",
    "text-align" : "center",
    "opacity" : "0",
    "cursor" : "pointer"
});



$('#homeCon').append('<ul id="sliderCon"></ul>')
$("#sliderCon").css({
    "list-style-type" : "none",
    "position" : "absolute",
    "top" : "45%",
    "left" : "3%",
    "width" : "30%",
    "height" : "40%",
})

for (let i = 1; i <= 3; i++) {
    $("#sliderCon").append(`<li id="sliderLi${i}" class="wlecom_normal_li" ></li>`);
    $(`#sliderLi${i}`).css({
        "position" : "relative",
        "top" : (i-1)*5+"%",
        "left" : (i-1)*20+"%",
        "transition" : "2s",
        "opacity" : "0",
        "cursor" : "pointer",
        // "border" : "1px solid red",

    })
}

$("#sliderLi1").text("購物商城").css({
    "list-style-image" : "url('images/indexLi2.png')",
    "width" : "200px"
})
$("#sliderLi2").text("山岳查詢").css({
    "list-style-image" : "url('images/indexLi1.png')",
    "width" : "200px"
})
$("#sliderLi3").text("露營地/山中小屋查詢").css({
    "list-style-image" : "url('images/indexLi3.png')",
    "width" : "400px"
})



window.setTimeout(function(){
    $("#bigTitle").css({
        "top" : "10%",
        "opacity" : "1",
        "transition" : "2S"

    })
    
},0)

for (let i = 1; i <= 4; i++) {
    window.setTimeout(function(){
        $(`#sliderLi${i}`).css({
            "left" :  "+=200px",
            "opacity":"1"
        })
    },800*(i))
    
}

$("#bigTitle").click(function(){
    $("#homeCon").fadeOut(1500,function(){
        $("#container").css("display","block")
    });
   

})

