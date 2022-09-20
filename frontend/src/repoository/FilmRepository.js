import axios from "../costum-axios/axios";
const FilmService={
    getAll:()=>{
        return axios.get("");
    },
    addfilm:(filmname, numadded, currency, amount)=>{
        return axios.post("/create", {
            "filmName":filmname,
            "numadded":numadded,
            "price": {
                "currency": currency,
                "amount": amount
            }
        })
    }


}
export default FilmService;