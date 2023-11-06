import React, { useRef, useEffect } from "react";
import Modal from "../../UI/Modal";
import Input from "../../UI/Input";
import Button from "../../UI/Button";
import Select from "../../UI/Select";

import CandidateService from "../../../service/candidate-service"
import AreaService from "../../../service/area-service";

import classes from "./AddCandidateModal.module.css"

// const areas = [
//     { id: 1, value: "data", name: "Data" },
//     { id: 2, value: "tech", name: "Tech" },
//     { id: 3, value: "risk", name: "Risk" },
//     { id: 4, value: "legal", name: "Legal" }
// ]

const AddCandidateModal = (props) => {
    const nameRef = useRef()
    const positionRef = useRef()
    const areaRef = useRef()
    const areas = null


    useEffect(() => {
        console.log('loading...')
        areas = AreaService.getAllAreas()
        console.log(areas)
    }, [])


    const cleanRef = refs => {
        for(let ref of refs){
            ref.current.value = ''
        }
    }


    const addCandidateHandler = (name, position, area) => {
        CandidateService.addCandidate(name, position, area.toUpperCase())
    }


    const submitHandler = (event) => {
        event.preventDefault()
        const name = nameRef.current.value
        const position = positionRef.current.value
        const area = areaRef.current.value
        addCandidateHandler(name, position, area)
        cleanRef([nameRef, positionRef, areaRef])
        props.onClose()
    }


    return (
        <Modal onClose={props.onClose}>
            <form className={classes["add-candidate-modal"]} onSubmit={submitHandler}>
                <Input ref={nameRef} label="Name"/>
                <Input ref={positionRef} label="Position"/>
                <Select 
                    label="Area" 
                    ref={areaRef} 
                    options={areas} 
                />
                 <Button label="Create"/>
            </form>
        </Modal>
    )
}

export default AddCandidateModal 