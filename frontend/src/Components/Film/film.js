import React from "react";

const Film = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Number Added</th>
                            <th scope={"col"}>Price</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.film.map((term) => {
                            return (
                                <tr>
                                    <td>{term.filmName}</td>
                                    <td>{term.numadded}</td>
                                    <td>{term.price.amount}</td>
                                    <td scope={"col"} className={"text-right"}>
                                        <a title={"Add to Wishlist"} className={"btn btn-danger"}
                                           onClick={() => props.onadd(term.id)}>
                                            Add to WishList
                                        </a>
                                    </td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default Film;