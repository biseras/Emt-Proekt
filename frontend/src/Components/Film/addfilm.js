import React from "react";


const AddFilm = (props) => {

    const [formData, updateFormData] = React.useState({
        filmname:"",
        numadded:0,
        currency:"",
        amount: 0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const filmname=formData.filmname;
        const numadded=formData.numadded;
        const currency=formData.currency;
        const amount = formData.amount;
        props.onAddFilm(filmname, numadded, currency, amount);
    }

    return (
        <div className={"row"}>
            <div className={"col-md-6 offset-md-3"}>
                <div className="form">
                    <div className="form-body">
                        <form onSubmit={onFormSubmit}>
                            <div className="form-group">
                                <label htmlFor="filmname">Film Name</label>
                                <input type="text"
                                       className="form-control"
                                       id="filmname"
                                       name="filmname"
                                       required
                                       placeholder="Enter amount you want toa add"
                                       onChange={handleChange}
                                />
                                <label htmlFor="numadded">Number Added</label>
                                <input type="number"
                                       className="form-control"
                                       id="numadded"
                                       name="numadded"
                                       required
                                       placeholder="Enter amount you want toa add"
                                       onChange={handleChange}
                                /><label htmlFor="currency">Currency</label>
                                <input type="text"
                                       className="form-control"
                                       id="currency"
                                       name="currency"
                                       required
                                       placeholder="Enter amount you want toa add"
                                       onChange={handleChange}
                                /><label htmlFor="amount">Amount</label>
                                <input type="number"
                                       className="form-control"
                                       id="amount"
                                       name="amount"
                                       required
                                       placeholder="Enter amount you want toa add"
                                       onChange={handleChange}
                                />

                            </div>
                            <br/>
                            <button id="submit" type="submit" className="btn btn-outline-dark">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )

}

export default AddFilm