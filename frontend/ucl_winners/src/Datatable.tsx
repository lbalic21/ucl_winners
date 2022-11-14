import React, { useCallback, useEffect, useState } from "react";
import {Table} from "react-bootstrap"
import DropDown from "./Dropdown";
import { UclWinner } from "./types";
import axios from "axios";
import { ScrollRestoration } from "react-router-dom";

const Datatable:React.FC = () => {
  const [searchText, setSearchText] = useState("");
  const [showDropDown, setShowDropDown] = useState<boolean>(false);
  const [selectAttribute, setSelectAttribute] = useState<string>("Wildcard");
  const [values, setValues] = useState<UclWinner[]>([]);

  const attributes = () => {
    return ["Wildcard", "Club", "City", "Country", "Year", "Stadium", "Head Coach", "Captain", "Match-up", "Result", "Attendance"];
  };
 
  const toggleDropDown = () => {
    setShowDropDown(!showDropDown);
  };

  const dismissHandler = (event: React.FocusEvent<HTMLButtonElement>): void => {
    if (event.currentTarget === event.target) {
      setShowDropDown(false);
    }
  };

  const attributeSelection = (attribute: string): void => {
    console.log(attribute);
    setSelectAttribute(attribute);
  };


  var blob = new Blob([],{type:"csv"});
  const href = URL.createObjectURL(blob)
  const a = Object.assign(document.createElement("a"), {href,download: "ucl_winners.csv"})
 
  
  
  useEffect(() => {
    axios.get("http://localhost:8080/uclWinner/all", {params:{"value":searchText,"attribute":selectAttribute}}).then(response => {setValues(response.data);
    console.log(response.data);
    blob = response.data
    })}, [searchText, selectAttribute]);

    return(
        <>
        <input type="search" id="site-search" name="q" onChange={(event) => setSearchText(event.target.value)}></input>
        <button
        className={showDropDown ? "active" : undefined}
        onClick={(): void => toggleDropDown()}
        onBlur={(e: React.FocusEvent<HTMLButtonElement>): void =>
          dismissHandler(e)
        }
      >
      <div>{selectAttribute? selectAttribute : "Select ..."} </div>
        {showDropDown && <DropDown attributes={attributes()} showDropDown={false} toggleDropDown={() => toggleDropDown} attributeSelection={attributeSelection}/>}
        </button>
        <Table>
            <thead>
            <tr>
                <th>Club</th>
                <th>City</th>
                <th>Country</th>
                <th>Year</th>
                <th>Stadium</th>
                <th>Head Coach</th>
                <th>Match-up</th>
                <th>Result</th>
                <th>Scorers</th>
                <th>Attendance</th>
            </tr>
            </thead>
            <tbody>
            {values.map(value =>
            {return(
                <tr key = {value.id}>
                <td>{value.club}</td>
                <td>{value.city}</td>
                <td>{value.country}</td>
                <td>{value.year}</td>
                <td>{value.finalStadium}</td>
                <td>{value.headCoach.name}</td>
                <td>{value.finalMatchup}</td>
                <td>{value.result}</td>
                <td>{value.scorers[0].name}</td>
                <td>{value.finalAttendance}</td>
            </tr>)
            })}
            </tbody>
        </Table>
       
        </>
    )
}

export default Datatable;