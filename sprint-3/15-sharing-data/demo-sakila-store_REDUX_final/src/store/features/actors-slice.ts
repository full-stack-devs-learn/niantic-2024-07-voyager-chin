import { createSlice, PayloadAction, createAsyncThunk } from "@reduxjs/toolkit";
import { Actor } from "../../models/actor";
import actorService from "../../services/actors-service";

interface ActorsState
{
    actors: Actor[]
    loading: boolean
    error: string | null
}

const initialState: ActorsState = {
    actors: [],
    loading: false,
    error: null
}


export const loadActors = createAsyncThunk('actors/getActors', async (name: string | null)=> {
    let actors = await actorService.getActors()
    if(name !== null)
    {
      actors = actors.filter(actor => actor.lastName == name)
    }
    return actors
})

export const addActor = createAsyncThunk('actors/addActor', async (actor: Actor) => {
    const newActor = await actorService.addActor(actor)
    return newActor
})

export const updateActor = createAsyncThunk('actors/udpateActor', async (actor: Actor) => {
    await actorService.updateActor(actor)
    return actor
})

export const deleteActor = createAsyncThunk('actors/deleteActor', async (actorId: number) => {
    await actorService.deleteActor(actorId)
    return actorId
})

const actorsSlice = createSlice({
    name: 'actors',
    initialState,
    reducers: {

    },
    extraReducers: (builder) => {
        // Fetch Actors
      builder.addCase(loadActors.pending, (state) => {
        state.loading = true;
        state.error = null;
      });
      builder.addCase(loadActors.fulfilled, (state, action: PayloadAction<Actor[]>) => {
        state.loading = false;
        state.actors = action.payload;
      });
      builder.addCase(loadActors.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message || 'Failed to fetch actors';
      });
  
      // Add Actor
      builder.addCase(addActor.pending, (state) => {
        state.loading = true;
        state.error = null;
      });
      builder.addCase(addActor.fulfilled, (state, action: PayloadAction<Actor>) => {
        state.loading = false;
        state.actors.push(action.payload);
      });
      builder.addCase(addActor.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message || 'Failed to add actor';
      });
  
      // Update Actor
      builder.addCase(updateActor.pending, (state) => {
        state.loading = true;
        state.error = null;
      });
      builder.addCase(updateActor.fulfilled, (state, action: PayloadAction<Actor>) => {
        state.loading = false;
        const index = state.actors.findIndex(actor => actor.actorId === action.payload.actorId);
        if (index !== -1) {
          state.actors[index] = action.payload;
        }
      });
      builder.addCase(updateActor.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message || 'Failed to update actor';
      });
  
      // Delete Actor
      builder.addCase(deleteActor.pending, (state) => {
        state.loading = true;
        state.error = null;
      });
      builder.addCase(deleteActor.fulfilled, (state, action: PayloadAction<number>) => {
        state.loading = false;
        state.actors = state.actors.filter(actor => actor.actorId !== action.payload);
      });
      builder.addCase(deleteActor.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message || 'Failed to delete actor';
      });
    }
})

const actorsReducer = actorsSlice.reducer
export default actorsReducer