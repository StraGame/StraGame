var contatore=0;

function upgradeMiPiace(){
    contatore++
    document.getElementById("voti").innerHTML = contatore
}

function returnRating(){
    const container= document.querySelector('.star-rating');
    const items=container.querySelectorAll('.rating')

    container.onclick= e =>{
        const elClass=e.target.classList;
        console.log(e.target.getAttribute("value"));
    }
}