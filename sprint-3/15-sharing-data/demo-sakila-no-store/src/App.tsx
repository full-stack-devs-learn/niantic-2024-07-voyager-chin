import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import ActorsList from './components/actors/actors-list/ActorsList'
import Home from './components/home/Home'
import MoviesList from './components/movies/movies-list/MoviesList'
import Header from './components/shared/header/Header'
import ActorDetails from './components/actors/actor-details/ActorDetails'
import ActorAdd from './components/actors/actor-add/ActorAdd'
import ActorsPage from './components/actors/actors-page/ActorsPage'

function App() {

  return (
    <Router>
      <Header />

      <main className="container mt-4">
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/actors' element={<ActorsPage />}>
          <Route path='' element={<ActorsList />} />
          <Route path=':actorId' element={<ActorDetails />} />
          <Route path='add' element={<ActorAdd />} />
        </Route>
        <Route path='/movies' element={<MoviesList />} />
      </Routes>
      </main>

      <footer>
        &copy; Sakila Movies 2024
      </footer>

    </Router>
  )
}

export default App
