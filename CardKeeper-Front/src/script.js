
const url = 'http://localhost:8080/cards';
const cardForm = document.querySelector("#card-input-form")
const cardName = document.querySelector("#input-CardName")
const cardCode = document.querySelector("#input-CardCode")
const cardAmount = document.querySelector("#input-CardAmount")
const cardQuality = document.querySelector("#input-CardQuality")
const cardSleeve = document.querySelector("#input-CardSleeve")
const cardImage = document.querySelector("#input-CardImage")
async function getAllCards(){
    const response = await fetch(url);
    console.log(response);
    const data = await response.json();
    console.log(data);
    data.map((card) => cardBuilder(card))
}
function isSleeved(cardData){
    let isCardSleeved;
    if(cardData.CardSleeve == 0){
        isCardSleeved = " No"
    }
    else{
        isCardSleeved = " Yes"
    }
    return isCardSleeved;
}
function cardBuilder(cardData){
    let main = document.getElementById("mainRow")

    let col = document.createElement("div");
    let card = document.createElement("div")
    let cardBody = document.createElement("div");
    let cardText = document.createElement("div")
    let cardImage = document.createElement("img")
    
   
    let cardName = document.createElement("p")
    let cardCode = document.createElement("p")
    let cardsAmount = document.createElement("p")
    let cardQuality = document.createElement("p")
    let cardSleeve = document.createElement("p")
    
    
    cardImage.src = cardData.CardImage
    cardName.innerHTML = `Name: ${cardData.CardName}`
    cardCode.innerHTML = `Code: ${cardData.CardCode}`
    cardsAmount.innerHTML = `Number of cards: ${cardData.CardsAmount}`
    cardQuality.innerHTML = `Card Quality: ${cardData.CardQuality}`
   
    cardSleeve.innerHTML = `Card Sleeved:` + isSleeved(cardData)


    cardText.classList.add("card-text")
    cardText.classList.add("border")
    cardText.classList.add("border-secondary")
    cardText.classList.add("text-light")
    cardImage.classList.add("card-img-top")
    cardImage.classList.add("mb-3")
    cardName.classList.add("mt-2")
    col.classList.add("col-2")
    col.classList.add("text-center")
    card.classList.add("card")
    card.classList.add("bg-dark")
    cardBody.classList.add("card-body")
    cardBody.classList.add("border")
    cardBody.classList.add("border-secondary")
   
    
    cardText.appendChild(cardName)
    cardText.appendChild(cardCode)
    cardText.appendChild(cardsAmount)
    cardText.appendChild(cardQuality)
    cardText.appendChild(cardSleeve)

    cardBody.appendChild(cardImage)
    cardBody.appendChild(cardText)
    

    card.appendChild(cardBody)
    col.appendChild(card)
    main.appendChild(col)
}
async function registerCard(card){

    const response = await fetch(url, {
        method: "POST",
        body: card,
        headers:{
            "Content-type": "application/json"
        },
    })
    const data = await response.json();
    console.log(data)


}


getAllCards();

cardForm.addEventListener("submit", (e) => {
    e.preventDefault();

    let card = {
        CardName: cardName.value,
        CardCode: cardCode.value,
        CardQuality: cardQuality.value,
        CardsAmount: cardAmount.value,
        CardSleeve: cardSleeve.value,
        CardImage: cardImage.value
    }
    card = JSON.stringify(card)
    registerCard(card)

})


