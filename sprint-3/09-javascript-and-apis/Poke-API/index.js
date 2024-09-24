document.addEventListener("DOMContentLoaded", function()
{
    // const pikachuBtn = document.getElementById("pikachu-btn");
    // const squirtleBtn = document.getElementById("squirtle-btn");
    // const charizardBtn = document.getElementById("charizard-btn");
    // const bulbasaurBtn = document.getElementById("bulbasaur-btn");
    // const starmieBtn = document.getElementById("starmie-btn");
    // const diglettBtn = document.getElementById("diglett-btn");
    // const meowthBtn = document.getElementById("meowth-btn");
    // const togepiBtn = document.getElementById("togepi-btn");

    document.getElementById("pikachu-btn").addEventListener("click", function() { pokeFetch("pikachu") });
    document.getElementById("squirtle-btn").addEventListener("click", function() { pokeFetch("squirtle") });
    document.getElementById("charizard-btn").addEventListener("click", function() { pokeFetch("charizard") });
    document.getElementById("bulbasaur-btn").addEventListener("click", function() { pokeFetch("bulbasaur") });
    document.getElementById("starmie-btn").addEventListener("click", function() { pokeFetch("starmie") });
    document.getElementById("diglett-btn").addEventListener("click", function() { pokeFetch("diglett") });
    document.getElementById("meowth-btn").addEventListener("click", function() { pokeFetch("meowth") });
    document.getElementById("togepi-btn").addEventListener("click", function() { pokeFetch("togepi") });

    
})

function pokeFetch(pokemon)
{
    try
    {
        const response = fetch(`https://pokeapi.co/api/v2/pokemon/${pokemon}`)
                                    .then(async response => {

                                        if(!response.ok)
                                        {
                                            throw new Error("Oops something went wrong")
                                        }
                                        
                                        const data = await response.json()
                                        const imageLink = data.sprites.front_default;
                                        const name = pokemon.toUpperCase();
                                        const type = JSON.stringify(data.types[0].type.name);
                                        const ability = JSON.stringify(data.abilities[0].ability.name);

                                        const imgHolder = document.getElementById("image-holder");
                                        const nameHolder = document.getElementById("name");
                                        const typeHolder = document.getElementById("type");
                                        const abilityHolder = document.getElementById("ability");

                                        imgHolder.src = imageLink;
                                        nameHolder.textContent = `${name}`;
                                        typeHolder.textContent = `Type: ${type}`;
                                        abilityHolder.textContent = `Ability: ${ability}`;

                                        imgHolder.style.display = "block";
                                    })
                                    .catch(error =>  console.log(error))

    }
    catch(error)
    {
        console.log(error)
    }
}