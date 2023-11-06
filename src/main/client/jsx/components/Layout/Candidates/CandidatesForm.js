import React, { useRef, useEffect, useState } from "react";
import Select from "../../UI/Select";
import Button from "../../UI/Button";

import AreaService from "../../../service/area-service";
import PhaseService from "../../../service/phase-service";

import classes from "./CandidatesForm.module.css"

const CandidatesForm = props => {
    const phaseSelectRef = useRef()
    const areaSelectRef = useRef()
    const [areas, setAreas] = useState([])
    const [phases, setPhases] = useState([])
    const [loading, setLoading] = useState(true)


    useEffect(() => {
        // Define load data async method
        const loadData = async () => {
            setLoading(true)
            const retrievedAreas = await AreaService.getAllAreas()
            const retrievedPhases = await PhaseService.getAllPhases()
            setAreas(retrievedAreas)
            setPhases(retrievedPhases)
            setLoading(false)
        }
        // Call load data
        loadData().catch(console.error);
    }, [])


    const submitHandler = event => {
        props.onChangeFilters({
            phase: phaseSelectRef.current.value,
            area: areaSelectRef.current.value
        })
    }

    const form =         
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