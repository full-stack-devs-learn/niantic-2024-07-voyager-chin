import { useContext } from "react"
import { useParams } from "react-router-dom"
import { ActorsContext } from "../../../contexts/ActorsContext"


export default function ActorDetails()
{
    const {actorId} = useParams()
    const context = useContext(ActorsContext)

    if(!context){
        throw new Error('ActorList must be used within an ActorsContextProvider')
    }

    const {actors} = context

    const actor = actors.filter(a => +a.actorId == +(actorId??0))[0];

    return (
        <>
        <h4>{actor.actorId}</h4>
        <p>{actor.firstName} {actor.lastName}</p>
        </>
    )
}