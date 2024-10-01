import { useContext, useState } from "react"
import { Link, useNavigate } from "react-router-dom"
import { ActorsContext } from "../../../contexts/ActorsContext"
import { Actor } from "../../../models/actor"

export default function ActorAdd()
{
    const navigate = useNavigate()
    const context = useContext(ActorsContext)

    if(!context)
    {
        throw new Error('No Actors Context found')
    }

    const { addActor } = context

    const [firstName, setFirstName] = useState<string>()
    const [lastName, setLastName] = useState<string>()

    async function addActorHandler()
    {
        const actor = new Actor()
        actor.firstName = firstName!
        actor.lastName = lastName!

        await addActor(actor)
        navigate('/actors')
    }

    return (
        <div className="container">
        <h2>Add New Category</h2>
        <form onSubmit={addActorHandler} method="post">
            <div className="row">
                <label htmlFor="first-name">First Name:</label>
                <input type="text" className="form-control" name="first-name" id="first-name"
                    onChange={(e) => setFirstName(e.target.value)}
                />
            </div>

            <div className="row">
                <label htmlFor="last-name">Last Name:</label>
                <input type="text" className="form-control" name="last-name" id="last-name"
                    onChange={(e) => setLastName(e.target.value)}
                />
            </div>
            <button className="btn btn-success mr-3" type="submit">Add Category</button>
            <Link className="btn btn-danger" to="/actors">Cancel</Link>
        </form>
        </div>
    )
}