import React from "react";

const Wishlist = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Date Created</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.wishlist.map((term) => {
                            return (
                                <tr>
                                    <td>{term.addedOn}</td>
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