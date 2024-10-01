import { Suspense, lazy } from 'react'
import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import ActorsList from './components/actors/actors-list/ActorsList'
import ActorDetails from './components/actors/actor-details/ActorDetails'
import ActorAdd from './components/actors/actor-add/ActorAdd'
import Home from './components/home/Home'
import MoviesList from './components/movies/movies-list/MoviesList'
import Header from './components/shared/header/Header'
const ActorsPage = lazy(() => import('./components/actors/actors-page/ActorsPage'))

function App() {

  return (
    <Router>
      <Header />

      <main className="container mt-4">
      <Suspense fallback={<div>Loading...</div>}>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/actors' element={<ActorsPage />}>
          <Route path='' element={<ActorsList />} />
          <Route path=':actorId' element={<ActorDetails />} />
          <Route path='add' element={<ActorAdd />} />
        </Route>
        <Route path='/movies' element={<MoviesList />} />
      </Routes>
      </Suspense>
      </main>

      <footer>
        &copy; Sakila Movies 2024
      </footer>

    </Router>
  )
}

export default App
