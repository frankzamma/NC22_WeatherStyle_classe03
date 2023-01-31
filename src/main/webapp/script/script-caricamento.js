function changeSelectedParameter(){
    let x = document.getElementById("tipologia").value;
    if(x === "maglia"){
        document.getElementById("materiale").removeAttribute("disabled");
        document.getElementById("colore").removeAttribute("disabled");
        document.getElementById("manica").removeAttribute("disabled");
        document.getElementById("stagione").removeAttribute("disabled");
        document.getElementById("lungPantalone").setAttribute("disabled","");
        document.getElementById("tipoScarpa").setAttribute("disabled","");
        document.getElementById("scivsi").setAttribute("disabled","");
        document.getElementById("scivno").setAttribute("disabled","");
        document.getElementById("impsi").setAttribute("disabled","");
        document.getElementById("impno").setAttribute("disabled","");
    }else if(x === "pantaloni"){
        document.getElementById("materiale").removeAttribute("disabled");
        document.getElementById("colore").removeAttribute("disabled");
        document.getElementById("manica").setAttribute("disabled","");
        document.getElementById("stagione").removeAttribute("disabled");
        document.getElementById("lungPantalone").removeAttribute("disabled");
        document.getElementById("tipoScarpa").setAttribute("disabled","");
        document.getElementById("scivsi").setAttribute("disabled","");
        document.getElementById("scivno").setAttribute("disabled","");
        document.getElementById("impsi").setAttribute("disabled","");
        document.getElementById("impno").setAttribute("disabled","");
    }else if(x === "scarpe"){
        document.getElementById("materiale").setAttribute("disabled","");
        document.getElementById("colore").removeAttribute("disabled");
        document.getElementById("manica").setAttribute("disabled","");
        document.getElementById("stagione").removeAttribute("disabled");
        document.getElementById("lungPantalone").setAttribute("disabled","");
        document.getElementById("tipoScarpa").removeAttribute("disabled");
        document.getElementById("scivsi").removeAttribute("disabled");
        document.getElementById("scivno").removeAttribute("disabled");
        document.getElementById("impsi").removeAttribute("disabled");
        document.getElementById("impno").removeAttribute("disabled");
    }
    else{
        document.getElementById("materiale").setAttribute("disabled","");
        document.getElementById("colore").setAttribute("disabled","");
        document.getElementById("manica").setAttribute("disabled","");
        document.getElementById("stagione").setAttribute("disabled","");
        document.getElementById("lungPantalone").setAttribute("disabled","");
        document.getElementById("tipoScarpa").setAttribute("disabled","");
        document.getElementById("scivsi").setAttribute("disabled","");
        document.getElementById("scivno").setAttribute("disabled","");
        document.getElementById("impsi").setAttribute("disabled","");
        document.getElementById("impno").setAttribute("disabled","");
    }
}
