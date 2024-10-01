import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import actorService from "../../../services/actors-service"
import { Actor } from "../../../models/actor"


export default function ActorDetails()
{
    const [actor, setActor] = useState<Actor>();

    const params = useParams()
    const actorId = params.actorId ?? 0

    useEffect(() => { loadActor()}, [])

    async function loadActor()
    {
        const searchResult = await actorService.getActorById(+actorId)
        setActor(searchResult)
    }


    return (
        <>
        <h4>Actor Details</h4>
        <p>{actor?.firstName} {actor?.lastName}</p>
        </>
    )
}