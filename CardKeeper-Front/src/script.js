
const url = 'http://localhost:8080/cards';
async function getAllCards(){
    const response = await fetch(url);
    console.log(response);
    const data = await response.json();
    console.log(data);
    data.map((card) => cardBuilder(card))
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
    
    //This will get the json field in the future
    cardImage.src = "https://www.duelshop.com.br/5728-large_default/blue-eyes-white-dragon-ldk2-enk01-common.jpg"
    cardName.innerHTML = `Name: ${cardData.CardName}`
    cardCode.innerHTML = `Code: ${cardData.CardCode}`
    cardsAmount.innerHTML = `Number of cards: ${cardData.CardsAmount}`
    cardQuality.innerHTML = `Card Quality: ${cardData.CardQuality}`
    //This will get the json field in the future
    cardSleeve.innerHTML = `Card Sleeved: Yes`


    cardText.classList.add("card-text")
    cardText.classList.add("border")
    cardText.classList.add("border-info")
    cardImage.classList.add("card-img-top")
    cardImage.classList.add("mb-3")
    cardName.classList.add("mt-2")
    col.classList.add("col-2")
    col.classList.add("text-center")
    card.classList.add("card")
    card.classList.add("bg-light")
    cardBody.classList.add("card-body")
   
    
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

getAllCards();

