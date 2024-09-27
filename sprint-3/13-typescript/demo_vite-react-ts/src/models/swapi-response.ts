import { Person } from "./person"

export class SwapiResponse
{
    message!: string
    total_records!: number
    total_pages!: number
    previous?: string
    next?: string
    results!: Person[]
}