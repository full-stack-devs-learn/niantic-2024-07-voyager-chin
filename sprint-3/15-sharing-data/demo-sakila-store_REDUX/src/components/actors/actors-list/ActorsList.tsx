
import { Link } from "react-router-dom";

import { Actor } from "../../../models/actor";
import { useDispatch } from "react-redux";
import { AppDispatch, RootState } from "../../../store/store";
import { useSelector } from "react-redux";
import { useEffect } from "react";
import { loadActors } from "../../../store/features/actors-slice";

export default function ActorsList()
{
    const dispatch = useDispatch<AppDispatch>()
    const { actors, loading , error } = useSelector((state: RootState) => state.actors )

    useEffect(() => { 
        // tell the store to load the actors
        dispatch(loadActors())
    }, [dispatch])


    if (loading) return <p>Loading actors...</p>;
    if (error) return <p>Error: {error}</p>;

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