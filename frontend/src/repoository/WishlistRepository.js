import axiosw from "../costum-axios/axiosw";

const WishlistService={
    getAll:()=>{
        return axiosw.get("/wihslist");
    },
    additem:(id)=>{
        console.log(id)
        let text=id.toString()
        console.log(id.id)
        return axiosw.post("/wihslist/additem", {
            "filmId": id.id
        })
    }

}
export default WishlistService;