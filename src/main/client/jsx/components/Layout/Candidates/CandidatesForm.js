import React, { useRef } from "react";
import Select from "../../UI/Select";

import classes from "./CandidatesForm.module.css"

const phases = [
    { id: 1, value: "application", name: "Application" },
    { id: 2, value: "approved", name: "Approved" },
    { id: 3, value: "declined", name: "Declined" }
]

const areas = [
    { id: 1, value: "data", name: "Data" },
    { id: 2, value: "tech", name: "Tech" },
    { id: 3, value: "risk", name: "Risk" },
    { id: 4, value: "legal", name: "Legal" }
]

const CandidatesForm = props => {
    const phaseSelectRef = useRef()
    const areaSelectRef = useRef()

    const submitHandler = event => {
        props.onChangeFilters({
            phase: phaseSelectRef.current.value,
            area: areaSelectRef.current.value
        })
    }

    return (
        <div className={classes["candidates-form"]}>
            <Select 
                label="Phase" 
                ref={phaseSelectRef} 
                options={phases}
            />
            <Select 
                label="Area" 
                ref={areaSelectRef} 
                options={areas} 
            />
            <button onClick={submitHandler}>Search</button>
        </div>
    )
}

export default CandidatesForm 