import axios from 'axios'
import { SwapiResponse } from '../models/swapi-response';

class SwapiService
{

    async getAllPeople(): Promise<SwapiResponse>
    {
        const response = await axios.get<SwapiResponse>("https://www.swapi.tech/api/people");
        return response.data
    }
}

const swapiService = new SwapiService()
export default swapiService;