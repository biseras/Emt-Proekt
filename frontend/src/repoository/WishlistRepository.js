import axiosw from "../costum-axios/axiosw";

const WishlistService={
    getAll:()=>{
        return axiosw.get("/wihslist");
    },
    additem:(id)=>{
        console.log(id)
        let text=id.toString()
        return axiosw.post("/wihslist/additem", {
            "filmId": text
        })
    }

}
export default WishlistService;