import { useParams } from "react-router-dom"


export default function ActorDetails()
{
    const params = useParams()


    return (
        <>
        <h4>Actor Details - Actor Id: {params.actorId}</h4>
        </>
    )
}