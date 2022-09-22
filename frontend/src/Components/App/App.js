import './App.css';
import React from "react";
import {Component} from "react";
import Film from '../Film/film'
import Header from '../Header/Header'
import {
  Routes,
  Navigate,
  Route
} from 'react-router-dom';
import FilmService from "../../repoository/FilmRepository";
import AddFilm from "../Film/addfilm";
import Wishlist from "../Wishlist/wishlist";
import WishlistService from "../../repoository/WishlistRepository";


class App extends Component{
  constructor(props) {
    super(props);
    this.state={
      film:[],
      wishlist:[]
    }
  }
  render() {
    return (

        <main>
          <Header/>
          <div className="container">
            <Routes>
              <Route path={"/allfilms"} exact element={<Film film={this.state.film} onadd={this.addtowish}/>}/>
              <Route path={"/addfilm"} exact element={<AddFilm onAddFilm={this.addfilm}/>}/>
              <Route path={"/allwishlist"} exact element={<Wishlist wishlist={this.state.wishlist}/>}/>
            </Routes>
          </div>
        </main>

    );
  }

  componentDidMount() {
    this.getfilm();
    this.getwishlist();
  }
  getfilm=()=>{
    FilmService.getAll().then((data)=>{

      this.setState({
        film:data.data
      })
    });
  }
  addfilm=(filmName, numaded, currency, amount)=>{
    FilmService.addfilm(filmName, numaded, currency, amount).then(()=>
    {
      window.location.href="/allfilms"
    })

  }
  getwishlist=()=>{
    WishlistService.getAll().then((data)=>{

      this.setState({
        wishlist:data.data
      })
    });
  }
  addtowish=(id)=>{
    console.log(id)
    WishlistService.additem(id).then(()=>
    {

      window.location.href="/allwishlist"
    })

  }


}

export default App;