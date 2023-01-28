function getCitta(id){
    let elem =  document.getElementById(id).value;
    let suggest =  document.getElementById('suggest');

    if(elem.length > 2){
        suggest.style.display = "block";
    }else{
        suggest.style.display = "none";
    }
}