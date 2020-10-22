function checkName(){
    let theNameObj = document.getElementById("memberId");
    let theNameObjVal = theNameObj.value;
    let theNameObjValLen = theNameObjVal.length;
    let sp = document.getElementById("mbIdsp");
    let flag = false;

    if(theNameObjVal == ""){
        sp.innerHTML = "請輸入帳號";
    } else if(theNameObjValLen >= 6){
        for(let i = 0; i < theNameObjValLen; i++){
            let re = new RegExp(/[A-Za-z]+[0-9]/);
            let re2 = new RegExp(/[0-9]+[A-Za-z]/);
            if(theNameObjVal.match(re)){
                flag = true;
            }else if(theNameObjVal.match(re2)){
                flag = true;
            }else{
                flag = false;
            }

            if(flag){
                sp.innerHTML = "正確";
            }else{
                sp.innerHTML = "帳號必須包含大小寫英文與數字";
            }
        }
    }else{
        sp.innerHTML = "密碼長度最少6個字元";
    }
}