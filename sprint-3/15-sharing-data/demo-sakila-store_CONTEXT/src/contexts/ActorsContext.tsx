import React from 'react';
import { Actor } from '../models/actor';

export interface ActorsContextType {
    actors: Actor[];
    addActor: (actor: Actor) => Promise<void>;
    updateActor: (actor: Actor) => Promise<void>;
    deleteActor: (actorId: number) => Promise<void>;
    refreshActors: () => Promise<void>;
  }

export const ActorsContext = React.createContext<ActorsContextType | undefined>(undefined);