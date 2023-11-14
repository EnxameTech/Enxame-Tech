// const form = document.getElementById('form');
const campos = document.querySelectorAll('.required');
const spans = document.querySelectorAll('.span-required')
const emailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/
const form = document.getElementById('form');

form.addEventListener("submit", async (e) => {
    try {

    } catch (error) {
        console.error('Erro ao validar o formulário:', error);
        e.preventDefault();
    }
});

function setError(index){
 campos[index].style.border = "3px solid #e6363660";
 spans[index].style.display = "block";
}



function removeError(index){
    campos[index].style.border = "";
    spans[index].style.display = "none";
}


function cpfValidate(){
    if(campos[0].value.length < 14){
     setError(0)
    }
    else{
      removeError(0)
    }
}
function nomeValidate(){
    if(campos[1].value.length < 5){
     setError(1)
    }
    else{
      removeError(1)
    }
}

function emailCheck(){
    if(!emailRegex.test(campos[3].value)){
        setError(3)
    }else{
        removeError(3)
    }
}

function password(){
    if(campos[4].value.length < 6){
        setError(4)
    }
    else{
        removeError(4)
    }
}

function tel(){
    if(campos[5].value.length < 12){
        setError(5)
    }
    else{
        removeError(5)
    }
}
function endereco(){
    if(campos[6].value.length < 8){
        setError(6)
    }
    else{
        removeError(6)
    }
}







