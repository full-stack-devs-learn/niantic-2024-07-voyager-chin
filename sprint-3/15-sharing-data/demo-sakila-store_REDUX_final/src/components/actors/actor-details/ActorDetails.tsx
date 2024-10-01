
import { useParams } from "react-router-dom"
import { ActorsContext } from "../../../contexts/ActorsContext"
import { useDispatch } from "react-redux"
import { AppDispatch, RootState } from "../../../store/store"
import { useSelector } from "react-redux"


export default function ActorDetails()
{
    const dispatch = useDispatch<AppDispatch>()
    const { actors, loading , error } = useSelector((state: RootState) => state.actors )

    const {actorId} = useParams()

    const actor = actors.filter(a => +a.actorId == +(actorId??0))[0];

    return (
        <>
        <h4>{actor.actorId}</h4>
        <p>{actor.firstName} {actor.lastName}</p>
        </>
    )
}