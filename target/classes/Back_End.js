counter = 0;
stockCounter = 0;

//an Artist would also be qualified as an User first and foremost: Java stuff
class Artist extends User{
    /*constructor(artistName, projects){
        super(this.firstName,this.lastName,this.amount);
        this.artistName = artistName;
        this.projects = [];
        id = counter;
        counter++;
    }*/
}

class Projects{
    constructor(projName, description, releaseDate, genre){
        this.projName = projName;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }
}

class User{
    //assume user makes an initial deposit onto the website before trading
    constructor(firstName, lastName, amount){
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
        //stocksOwned = [];
    }
}

class StockObj{
    constructor(artist, value){
        this.artist = artist;
        this.value = value;
        //stockId = stockCounter;
        stockCounter++;
    }
}

class Market{
    constructor(){
        /*usersOnTheMarket = [];
        stocksOnTheMarket = [];*/
    }
}


function add(artist, newProj, market){
    //Check if the artist is on the market already:
    artistIndex = market.usersOnTheMarket.findIndex((e) => e.id == artist.id);
    if(artistIndex == -1){
        //Create new Artist:
        market.usersOnTheMarket.push(artist);
    }else{
        //add newProject to existing artist
        market.usersOnTheMarket[artistIndex].projects.push(newProj);
    }
}

function deleteStock(stock,market){
    //Find stock to delete Index 
    deleteIndex = stmarket.stocksOnTheMarket.findIndex((e) => e.stockId != -1);
    market.stocksOnTheMarket.splice(deleteIndex,1);
    //Deduce Amount from Every User that Had Access to the Stock
    for(let i = 0; i < market.usersOnTheMarket.length; i++){
        if(stock.artist.id == market.usersOnTheMarket[i].id){
            usersOnTheMarket[i].amount = usersOnTheMarket[i].amount - stock.value;
        }
    }
}

/*
Idea for the Sell Function:
-> function sell(artist, value, stockObject)
-> listen on a socket for an answer/offer of buy method from a user
-> if offer matches sell -> perform buy and sell correctly
-> otherwise: put sell and buy queries on a queue and continue updating the spotifyAPI get function every say 10sec (might be problematic since 
    it could lead to a deadlock tho!)
   


*/
 





