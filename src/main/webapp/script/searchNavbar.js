function getCittaNav(){
    let elem =  document.getElementById("name-citta").value;
    let suggest =  document.getElementById('suggest');

    const xhttp =  new XMLHttpRequest();

    xhttp.onreadystatechange = function(){
        if(this.readyState  == 4){
            if(this.status == 200){
                suggest.innerText = "";
                let response = this.responseText;
                let cittaList =  JSON.parse(response);
                let ul =  document.createElement('ul');

                ul.id = "result"

                if(cittaList.length > 0){
                    for(let citta of cittaList){
                        let li =  document.createElement('li');

                        let txt =  document.createTextNode(citta.nome);

                        li.appendChild(txt);
                        ul.appendChild(li);

                        li.addEventListener('click' , function (){
                            location.href = "cerca-meteo?lat=" + citta.lat + "&lon=" + citta.lon + "&citta-nome="+ citta.nome;
                        })
                    }

                    suggest.appendChild(ul);
                }else{
                    inserisciLoader();
                }
            }else{
                window.alert("Si è verificato un errore, riprovare più tardi");
            }
        }
    }

    xhttp.open("GET" ,"get-citta?citta=" + elem)
    suggest.style.display = "block";

    if(elem.length > 2){
        xhttp.send();
    }else{
        inserisciLoader();
    }
}


function inserisciLoader(){
    let tmp =  document.getElementById("loading-image");
    if(tmp == null) {
        let suggest = document.getElementById("suggest")
        let node = document.createElement('img');
        node.id = "loading-image";
        node.src = "./image/load.gif";
        node.classList.add("rounded");
        node.classList.add("mx-auto");
        node.classList.add("d-block");

        node.width = 100;
        node.height = 100;
        suggest.appendChild(node);
    }
}

