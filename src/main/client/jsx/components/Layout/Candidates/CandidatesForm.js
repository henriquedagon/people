import React, { useRef, useEffect, useState } from "react";
import Select from "../../UI/Select";
import Button from "../../UI/Button";

import AreaService from "../../../service/area-service";
import StateService from "../../../service/state-service";

import classes from "./CandidatesForm.module.css"

const CandidatesForm = props => {
    const stateSelectRef = useRef()
    const areaSelectRef = useRef()
    const [areas, setAreas] = useState([])
    const [states, setStates] = useState([])
    const [loading, setLoading] = useState(true)


    useEffect(() => {
        // Define load data async method
        const loadData = async () => {
            setLoading(true)
            const retrievedAreas = await AreaService.getAllAreas()
            const retrievedStates = await StateService.getAllStates()
            setAreas(retrievedAreas)
            setStates(retrievedStates)
            setLoading(false)
        }
        // Call load data
        loadData().catch(console.error);
    }, [])


    const submitHandler = event => {
        props.onChangeFilters({
            state: stateSelectRef.current.value,
            area: areaSelectRef.current.value
        })
    }

    const form =         
        <div className={classes["candidates-form"]}>
            <Select 
                label="State"
                ref={stateSelectRef} 
                options={states}
            />
            <Select 
                label="Area" 
                ref={areaSelectRef} 
                options={areas} 
            />
            <Button label="Search" onClick={submitHandler}/>
        </div>


    return (
        <React.Fragment>
            {loading && <p>Loading...</p>}
            {!loading && form}
        </React.Fragment>
    )
}

export default CandidatesForm 