import React, { useRef } from "react";
import Modal from "../../UI/Modal";
import Input from "../../UI/Input";
import Button from "../../UI/Button";
import Select from "../../UI/Select";

import classes from "./EditCandidateModal.module.css"

const states = [
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

const EditCandidateModal = (props) => {
    const nameRef = useRef()
    const stateRef = useRef()
    const positionRef = useRef()
    const areaRef = useRef()

    const cleanRef = refs => {
        for(let ref of refs){
            ref.current.value = ''
        }
    }

    async function editCandidateHandler (candidateData) {
        await fetch(`http://localhost:8080/api/candidate/${props.candidate.id}`, {
            method: 'PUT', 
            body: JSON.stringify(candidateData), 
            headers: {'Content-Type': 'application/json'
        }})
    }

    const submitHandler = (event) => {
        event.preventDefault()
        const data = {
            name: nameRef.current.value,
            state: stateRef.current.value,
            position: positionRef.current.value,
            area: areaRef.current.value,
        }
        editCandidateHandler(data)
        cleanRef([nameRef, stateRef, positionRef, areaRef])
        props.onClose()
    }

    return (
        <Modal onClose={props.onClose}>
            <form className={classes["edit-candidate-modal"]} onSubmit={submitHandler}>
                <Input ref={nameRef} 
                        label="Name"
                        input={{
                            defaultValue: props.candidate.name
                        }}
                />
                <Input ref={positionRef} 
                        label="Position"
                        input={{
                            defaultValue:props.candidate.position
                        }}
                />
                <Select 
                    label="State" 
                    ref={stateRef} 
                    options={states}
                    input={{
                        selected: props.candidate.state
                    }}
                />
                <Select 
                    label="Area" 
                    ref={areaRef}
                    options={areas}
                    input={{
                        selected: props.candidate.state
                    }}
                />
                 <Button label="Send"/>
            </form>
        </Modal>
    )
}

export default EditCandidateModal 