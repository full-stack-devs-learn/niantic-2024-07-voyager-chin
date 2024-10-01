import { useState } from "react";
import { useDispatch } from "react-redux";
import { Link, NavLink } from "react-router-dom"
import { AppDispatch } from "../../../store/store";
import { loadActors } from "../../../store/features/actors-slice";

export default function Header() {

    const dispatch = useDispatch<AppDispatch>()


    const [searchName, setSearchName] = useState<string>()

    async function searchHandler(event: any)
    {
        event.preventDefault();

        dispatch(loadActors(searchName!))

    }
    return (
        <nav className="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
            <div className="container-fluid">
                <Link className="navbar-brand" to="/">Sakila</Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarColor02">
                    <ul className="navbar-nav me-auto">
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/">Home</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/actors">Actors</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/movies">Movies</NavLink>
                        </li>
                    </ul>
                    <form className="d-flex" onSubmit={searchHandler}>
                        <input className="form-control me-sm-2" type="search" onChange={(e) => {setSearchName(e.target.value)}} placeholder="Search" />
                        <button className="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    )
}