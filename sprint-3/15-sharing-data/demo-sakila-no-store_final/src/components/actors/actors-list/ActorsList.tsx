import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import actorService from "../../../services/actors-service";
import { Actor } from "../../../models/actor";

export default function ActorsList()
{
    // // state should only matter for this component
    const [actors, setActors] = useState<Actor[]>([])

    // useEffect is to load external data on compenent initialization
    useEffect(() => { loadActors() }, [])

    async function loadActors()
    {
        try
        {
            const actors = await actorService.getActors();
            setActors(actors)
        }
        catch(error)
        {
            console.log(error);
            
        }
    }

    return (
        <>
        <h4>Actors List</h4>
        <Link className="btn btn-success" to="/actors/add">Add</Link>
        <ul>
            {
                actors.map((actor: Actor) => (
                    <li><Link to={`/actors/${actor.actorId}`}>{actor.firstName} {actor.lastName}</Link></li>
                ))
            }

        </ul>

        </>
    )
}