import { createRoot } from 'react-dom/client'
import App from './App.tsx'
import './index.css'

import 'bootstrap/dist/js/bootstrap.min.js'
import 'bootswatch/dist/united/bootstrap.min.css'

createRoot(document.getElementById('root')!).render(
  
    <App />
  ,
)
