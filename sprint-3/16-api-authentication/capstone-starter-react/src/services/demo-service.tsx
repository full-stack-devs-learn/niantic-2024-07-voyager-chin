import axios, { AxiosRequestConfig } from "axios";
import store, { RootState } from "../store/store";

class DemoService
{
    baseUrl = `${import.meta.env.VITE_API_BASE_URL}/demo`

    getHeaders(): AxiosRequestConfig
    {
        const state: RootState = store.getState()
        const token = state.authentication.token

        const config: AxiosRequestConfig<any> = {
            headers: {
                'Content-Type': 'application/json'
            }
        }

        if(token !== null) 
        {
             config.headers!['Authorization'] = `Bearer ${token}`
        }

        return config
        
    }

    async getDemo(): Promise<string[]>
    {
        const response = await axios.get<string[]>(this.baseUrl, this.getHeaders())

        return response.data
    }
}

const demoService = new DemoService()
export default demoService