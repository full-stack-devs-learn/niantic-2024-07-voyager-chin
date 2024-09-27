import { useState, useEffect } from 'react'
import './App.css'
import swapiService from './services/star-wars-api-service'
import { Person } from './models/person';

function App() {
  const [people, setPeople] = useState<Person[]>([]);

  useEffect(() => {
    callGetPeople()
  }, []);

  async function callGetPeople()
  {
      const response = await swapiService.getAllPeople();
      setPeople(response.results)
  }

  return (
    <>
    <table>
    {
      people.map((person) => (
        <tr>
          <td>{person.uid}</td>
          <td>{person.name}</td>
          <td>{person.url}</td>
        </tr>
      ))
    }
    </table>
    </>
  )
}

export default App
