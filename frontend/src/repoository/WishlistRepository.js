import axios from "../costum-axios/axios";
const WishlistService={
    getAll:()=>{
        return axios.get("/wihslist");
    }

}
export default WishlistService;