import './App.css';
import {useEffect, useState} from "react";

let completed;

function App() {
    const [toDo, setToDo] = useState([])
    const [comp, setComp] = useState("-");


    useEffect(() => {

        function getToDo() {
            fetch('https://jsonplaceholder.typicode.com/todos')
                .then(response => response.json())
                .then(json => setToDo(json))

        }

        getToDo();

    }, [])

    function countOpen() {
        completed = 0;
        for (let i = 0; i < toDo.length; i++) {
            if (toDo[i].completed) {
                completed++;


            }

        }
        setComp(completed)
    }

    return (
        <div className="App">

            <p>Hey, heute gibt es <strong>{toDo.length}</strong> ToDo's</p>
            <button id={"myButton"} onClick={countOpen}> count The Open</button>
            <p>Davon sind {comp || 1} erledigt worden <br/>Glückwunsch!</p>

            <table className="customers">
                <tr>
                    <th>ID</th>
                    <th>ToDo</th>
                    <th>Completed</th>
                </tr>
                <br/>

                {toDo.map(t => <tr>

                    <td style={{with: "500px"}}>{t.id}</td>
                    <td>{t.title}</td>
                    <td style={{backgroundColor: (t.completed ? "green" : "red")}}>{t.completed}</td>
                </tr>)}
            </table>

        </div>
    );
}

export default App;
