function validatePassword(id){
    let checkBox = document.getElementById("password-check");

    checkBox.style.display = "block";

    let password =  document.getElementById(id).value;

    let state = true;

    let liLenght = document.getElementById("min-lenght");
    let iconLenght = document.querySelector("li#min-lenght > i");

    if(password.toString().length >= 8)
        correctField(liLenght, iconLenght);
    else{
        errorField(liLenght, iconLenght);
        state = false;
    }


    let liSymbol = document.getElementById("min-symbol");
    let iconSymbol = document.querySelector("li#min-symbol > i");

    if(/(?=[!_;,:.+-]+)/.test(password))
        correctField(liSymbol, iconSymbol);
    else{
        errorField(liSymbol, iconSymbol);
        state = false;
    }


    let liLetter = document.getElementById("min-letter");
    let iconLetter = document.querySelector("li#min-letter > i");

    if(/(?=[A-Z]+)/.test(password) && /(?=[a-z]+)/.test(password) )
        correctField(liLetter, iconLetter);
    else {
        errorField(liLetter, iconLetter);
        state = false;
    }

    let liNumber = document.getElementById("min-number");
    let iconNumber = document.querySelector("li#min-number > i");

    if(/(?=[0-9]+)/i.test(password))
        correctField(liNumber, iconNumber);
    else {
        errorField(liNumber, iconNumber);
        state = false;
    }

    return state;
}

function correctField(li, icon){
    li.style.color =  "green";
    icon.setAttribute("class", "fa fa-check-circle");
}

function errorField(li, icon){
    li.style.color =  "red";
    icon.setAttribute("class", "fa fa-circle-o");
}

function validateForm(){
    let state =  validatePassword('password');

    if(!state)
        window.alert("Rispettare il formato della password")

    return state;
}
