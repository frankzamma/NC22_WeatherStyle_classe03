function getCitta(id){
    let elem =  document.getElementById(id).value;
    let suggest =  document.getElementById('suggest');

    const xhttp =  new XMLHttpRequest();

    xhttp.onreadystatechange = function(){
        if(this.readyState  == 4){
            if(this.status == 200){
                suggest.innerText = "";
                let response = this.responseText;
                let cittaList =  JSON.parse(response);
                let ul =  document.createElement('ul')

                ul.id = "result"

                if(cittaList.length > 0){
                    for(let citta of cittaList){
                        let li =  document.createElement('li');
                        let a =  document.createElement('a');

                        a.addEventListener('click', function (){
                            scegliCitta(citta);
                        })
                        let txt =  document.createTextNode(citta.nome);

                        a.appendChild(txt);
                        li.appendChild(a);
                        ul.appendChild(li);
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

function scegliCitta(citta) {
    let suggest = document.getElementById('suggest');
    let input = document.getElementById('citta');
    suggest.style.display = "none";

    input.value = citta.nome;

    setLatAndLong(citta.lat, citta.lon)
}

function setLatAndLong(lat, long){
    let latInput = document.getElementById('lat');
    let longInput = document.getElementById('lon');

    latInput.value = lat;
    longInput.value = long;
}