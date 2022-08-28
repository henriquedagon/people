import React from "react";
import { Link } from "react-router-dom";
import Button from "../../UI/Button"
import modules from "./CandidateItem.module.css"

const CandidateItem = props => {

    const editCandidateHanlder = event => {
        props.onEditCandidate(props.id)
    }

    return (
        <tr className={modules.candidate} key={props.id}>
            <td>
                <Link to={`/candidate/${props.id}`}>
                    {`#${props.id}`}
                </Link>
            </td>
            <td className={modules.name}>
                <Link to={`/candidate/${props.id}`}>
                    {props.name}
                </Link>
            </td>
            <td>{props.phase}</td>
            <td>{props.position}</td>
            <td>{props.area}</td>
            <td><Button onClick={editCandidateHanlder} label="Edit"/></td>
        </tr>
    )
}

export default CandidateItem 