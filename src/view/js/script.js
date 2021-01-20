

function upgradeMiPiace(){
    var e = document.getElementById("voti");
    e.innerHTML = Math.min(1,+e.innerHTML+1);
}

function returnRatingGP(){
    const container= document.querySelector('.star-ratingGP');
    const items=container.querySelectorAll('.rating')

    container.onclick= e =>{
        const elClass=e.target.classList;
        console.log(e.target.getAttribute("value"));
    }
}

function returnRatingT(){
    const container= document.querySelector('.star-ratingT');
    const items=container.querySelectorAll('.rating')

    container.onclick= e =>{
        const elClass=e.target.classList;
        console.log(e.target.getAttribute("value"));
    }
}

function returnRatingG(){
    const container= document.querySelector('.star-ratingG');
    const items=container.querySelectorAll('.rating')

    container.onclick= e =>{
        const elClass=e.target.classList;
        console.log(e.target.getAttribute("value"));
    }
}

function returnRatingVC(){
    const container= document.querySelector('.star-ratingVC');
    const items=container.querySelectorAll('.rating')

    container.onclick= e =>{
        const elClass=e.target.classList;
        console.log(e.target.getAttribute("value"));
    }
}