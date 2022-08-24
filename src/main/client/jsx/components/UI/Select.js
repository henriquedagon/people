import React from "react";
import classes from "./Select.module.css"

const Select = React.forwardRef((props, ref) => {

    const options = props.options.map(option => 
        <option key={option.id} value={option.value}>{option.name}</option>
    )

    // const optionsWithSelected = options.filter(option => option.value === props.defaultValue)
    // optionsWithSelected.selected=true

    return (
        <div className={classes.select}>
            <label htmlFor="text">{props.label}</label>
            <select ref={ref} {...props.input} /* selectedValue={options.filter(option => option.value === props.defaultValue)} */ >
                {options}
            </select>
        </div>
    )
})

export default Select