import {Person} from "./models/person";
import swapiService from "./services/star-wars-api-service";

async function getAllPeople()
{
    const response = await swapiService.getAllPeople();

    //console.log(response);
    response.results.forEach(person => {
        console.log(person.name);
        
    });
    
}

getAllPeople()



