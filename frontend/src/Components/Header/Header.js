import React from "react";

const Header = (props) => {
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark navbar-fixed bg-dark">
                <a className="navbar-brand" href="/products">Movie Application</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">
                        <a href="/allfilms" className="nav-link active" style={{color: "white"}}>Films</a>
                    </ul>
                    <ul className="navbar-nav mr-auto">
                        <a href="/allwishlist" className="nav-link active" style={{color: "white"}}>Wishlist</a>
                    </ul>
                </div>
            </nav>
        </header>
    );
}

export default Header;