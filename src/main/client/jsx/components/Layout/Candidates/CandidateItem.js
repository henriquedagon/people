import React from "react";
import Button from "../../UI/Button"
import modules from "./CandidateItem.module.css"

const CandidateItem = props => {

    const editCandidateHanlder = event => {
        props.onEditCandidate(props.id)
    }

    return (
        <tr className={modules.candidate} key={props.id}>
            <td>{`#${props.id}`}</td>
            <td className={modules.name}>{props.name}</td>
            <td>{props.phase}</td>
            <td>{props.position}</td>
            <td>{props.area}</td>
            <td><Button onClick={editCandidateHanlder} label="Edit"/></td>
        </tr>
    )
}

export default CandidateItem 