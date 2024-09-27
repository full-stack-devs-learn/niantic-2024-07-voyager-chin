"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const star_wars_api_service_1 = __importDefault(require("./services/star-wars-api-service"));
async function getAllPeople() {
    const response = await star_wars_api_service_1.default.getAllPeople();
    //console.log(response);
    response.results.forEach(person => {
        console.log(person.name);
    });
}
getAllPeople();
