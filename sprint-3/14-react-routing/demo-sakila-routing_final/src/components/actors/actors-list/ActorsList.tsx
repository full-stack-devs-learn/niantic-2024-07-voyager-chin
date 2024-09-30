import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { useLocation } from "react-router-dom";

export default function ActorsList()
{
    // state should only matter for this component
    const [actors, setActors] = useState<any>()

    const location = useLocation();
    const params = new URLSearchParams(location.search);
    // read query string for page key // ?page=3
    const page = params.get("page") ?? 1

    const prevPage = +page - 1;
    const nextPage = +page + 1;

    // useEffect is to load external data on compenent initialization
    useEffect(() => { loadActors() }, [])

    async function loadActors()
    {
        // const actors = await actorService.getActors(page);
        // setActors(actors)
    }

    return (
        <>
        <h4>Actors List</h4>
        <Link className="btn btn-success" to="/actors/add">Add</Link>
        <ul>
            <li><Link to="/actors/12">Actor 12</Link></li>
            <li><Link to="/actors/13">Actor 13</Link></li>
            <li><Link to="/actors/14">Actor 14</Link></li>
            <li><Link to="/actors/15">Actor 15</Link></li>
        </ul>

        {prevPage > 0 && <Link className="btn btn-secondary" to={`/actors?page=${prevPage}`}>&lt;&lt;</Link>}
        Page {page}
        <Link className="btn btn-secondary" to={`/actors?page=${nextPage}`}>&gt;&gt;</Link>
        </>
    )
}