import axios from "axios";
const instance=axios.create({
    baseURL: 'http://localhost:9090/api/film',
    headers: {
        'Access-Control-Allow-Origin' : '*'
    }

})
export default instance;