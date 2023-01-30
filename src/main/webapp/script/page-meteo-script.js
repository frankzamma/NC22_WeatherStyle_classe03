function changePage(myID){
    for(let i = 0; i < 3; i++){
        if(i != myID){
            let tab =  document.getElementById('tab-' + i);
            let div =  document.getElementById('meteo-' +i);
            tab.classList.remove("active");
            div.style.display = "none";
        }else{
            let tab =  document.getElementById('tab-' + i);
            let div =  document.getElementById('meteo-' +i);
            tab.classList.add("active");
            div.style.display = "block";
        }
    }
}