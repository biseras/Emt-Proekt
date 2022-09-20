import React from "react";

const Wishlist = (props) => {
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
                        {props.wishlist.map((term) => {
                            return (
                                <tr>
                                    <td>{term.addedOn}</td>
                                    <td>{term.price.amount}</td>
                                    <td>{term.map((term2)=>{
                                        term2.
                                    })}</td>
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

export default Wishlist;