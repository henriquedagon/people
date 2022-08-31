import React, { useRef } from "react";
import Modal from "../../UI/Modal";
import Input from "../../UI/Input";
import Button from "../../UI/Button";
import Select from "../../UI/Select";

import CandidateService from "../../../service/candidate-service"

import classes from "./AddCandidateModal.module.css"

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

const AddCandidateModal = (props) => {
    const nameRef = useRef()
    const phaseRef = useRef()
    const positionRef = useRef()
    const areaRef = useRef()

    const cleanRef = refs => {
        for(let ref of refs){
            ref.current.value = ''
        }
    }

    const addCandidateHandler = (candidateData) => {
        CandidateService.addCandidate(candidateData)
    }

    const submitHandler = (event) => {
        event.preventDefault()
        const data = {
            name: nameRef.current.value,
            phase: phaseRef.current.value,
            position: positionRef.current.value,
            area: areaRef.current.value,
        }
        addCandidateHandler(data)
        cleanRef([nameRef, phaseRef, positionRef, areaRef])
        props.onClose()
    }

    return (
        <Modal onClose={props.onClose}>
            <form className={classes["add-candidate-modal"]} onSubmit={submitHandler}>
                <Input ref={nameRef} label="Name"/>
                <Input ref={positionRef} label="Position"/>
                <Select 
                    label="Phase" 
                    ref={phaseRef} 
                    options={phases}
                />
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