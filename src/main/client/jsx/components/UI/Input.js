import React from "react";

const Input = (props) => {
    return (
        <div>
            <label htmlFor="text">{props.label}</label>
            <input {...props.input}></input>
        </div>
    )
}

export default Input