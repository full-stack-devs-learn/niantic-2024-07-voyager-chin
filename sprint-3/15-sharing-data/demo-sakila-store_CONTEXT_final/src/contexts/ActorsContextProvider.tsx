import React, { useState, useEffect } from 'react';
import { ActorsContext, ActorsContextType } from './ActorsContext';
import { Actor } from '../models/actor';
import actorService from '../services/actors-service';

interface Props {
    children: React.ReactNode;
}

export default function ActorsContextProvider({ children }: Props) {
    const [actors, setActors] = useState<Actor[]>([]);


    useEffect(() => { 
        fetchActors()
    }, []);


    // Fetch actors from the API
    async function fetchActors() {
        try 
        {
            const actors = await actorService.getActors()
            setActors(actors)
        } catch (error) {
            console.error('Error getting actors:', error);
        }
    }

    // Add a new actor
    async function addActor(actor: Actor) {
        try {
            const newActor = await actorService.addActor(actor)
            
            setActors(prevActors => [...prevActors, newActor]);
        } catch (error) {
            console.error('Error adding actor:', error);
        }
    };

    // Update an existing actor
    async function updateActor(actor: Actor) {
        try {
            await actorService.updateActor(actor)
            setActors(prevActors =>
                prevActors.map(a => (a.actorId === actor.actorId ? actor : a))
            );
        } catch (error) {
            console.error('Error updating actor:', error);
        }
    };

    // Delete an actor
    async function deleteActor(actorId: number) {
        try {
            await actorService.deleteActor(actorId)
            
            setActors(prevActors => prevActors.filter(actor => actor.actorId !== actorId));
        } catch (error) {
            console.error('Error deleting actor:', error);
        }
    };

    // Refresh actors from the backend
    async function refreshActors() {
        
        await fetchActors() 
    };

    const contextValue: ActorsContextType = {
        actors,
        addActor,
        updateActor,
        deleteActor,
        refreshActors,
    };

    return <ActorsContext.Provider value={contextValue}>{children}</ActorsContext.Provider>;
};
