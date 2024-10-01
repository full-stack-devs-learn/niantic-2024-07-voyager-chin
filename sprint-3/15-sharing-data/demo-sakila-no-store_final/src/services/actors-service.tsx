import axios from "axios";
import { Actor } from "../models/actor";

class ActorService
{
    baseUrl = `${import.meta.env.VITE_API_BASE_URL}/actors`

    async getActors(): Promise<Actor[]>
    {
        const response = await axios.get<Actor[]>(this.baseUrl)
        return response.data
    }
    
    async getActorById(id: number): Promise<Actor>
    {
        const response = await axios.get<Actor>(`${this.baseUrl}/${id}`)
        return response.data
    }

    async addActor(actor: Actor): Promise<Actor>
    {
        const response = await axios.post<Actor>(this.baseUrl, actor)
        return response.data
    }

    async updateActor(actor: Actor): Promise<void>
    {
        const url = `${this.baseUrl}/${actor.actorId}`
        await axios.put<void>(url, actor)
    }

    async deleteActor(id: number)
    {
        const url = `${this.baseUrl}/${id}`
        await axios.delete<void>(url)
    }
}

const actorService = new ActorService()
export default actorService