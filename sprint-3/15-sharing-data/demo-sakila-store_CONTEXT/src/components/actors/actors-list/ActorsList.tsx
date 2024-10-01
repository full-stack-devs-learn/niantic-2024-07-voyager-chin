import { useContext } from "react";
import { Link } from "react-router-dom";

import { ActorsContext } from "../../../contexts/ActorsContext";
import { Actor } from "../../../models/actor";

export default function ActorsList()
{
    const context = useContext(ActorsContext)


    if (!context) {
        throw new Error('ActorList must be used within an ActorsContextProvider');
    }

    const { actors} = context;

    return (
        <>
        <h4>Actors List</h4>
        <Link className="btn btn-success" to="/actors/add">Add</Link>
        <ul>
            {
                actors.map((actor: Actor) => (
                    <li key={actor.actorId}><Link to={`/actors/${actor.actorId}`}>{actor.firstName} {actor.lastName}</Link></li>
                ))
            }
        </ul>
        </>
    )
}