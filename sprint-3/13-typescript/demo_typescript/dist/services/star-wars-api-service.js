"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const axios_1 = __importDefault(require("axios"));
class SwapiService {
    async getAllPeople() {
        const response = await axios_1.default.get("https://www.swapi.tech/api/people");
        return response.data;
    }
}
const swapiService = new SwapiService();
exports.default = swapiService;
