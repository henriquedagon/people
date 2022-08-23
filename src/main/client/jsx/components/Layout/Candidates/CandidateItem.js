import React from "react";
import modules from "./CandidateItem.module.css"

const CandidateItem = props => {
    return (
        <tr className={modules.candidate} key={props.id}>
                <td>{`#${props.id}`}</td>
                <td className={modules.name}>{props.name}</td>
                <td>{props.phase}</td>
                <td>{props.position}</td>
                <td>{props.area}</td>
        </tr>
    )
}

export default CandidateItem 