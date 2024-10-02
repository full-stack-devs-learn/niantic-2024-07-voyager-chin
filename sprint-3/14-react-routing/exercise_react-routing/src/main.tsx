import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import 'bootstrap/dist/js/bootstrap.min.js'
import 'bootswatch/dist/cosmo/bootstrap.min.css'
import './index.css'
import App from './App'
import { Provider } from 'react-redux'
import store from './store/store'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <Provider store={store}>
    <App />
    </Provider>
  </StrictMode>,
)
