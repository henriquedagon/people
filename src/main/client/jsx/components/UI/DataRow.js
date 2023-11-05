import React from 'react'

import classes from "./DataRow.module.css"

function DataRow(props) {
  return (
    <div className={classes.row}>
      <div className='row__key'>
        {props.field}:
      </div>
      <div className='row__value'>
      {props.value}
      </div>
    </div>
  )
}

export default DataRow