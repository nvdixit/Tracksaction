import AddButton from '../AddButton/AddButton'
import './ContentBox.css'

function ContentBox(props) {
    return (
        <div id="ContentBox">
            <h2>{props.name}</h2>
            <div id="ListBox">
                <ul>
                    {props.items.map((item, i) => (<li key={i}>{item}</li>))}
                </ul>
            </div>
            <AddButton name={props.btnName}/>
        </div>
    )
}

export default ContentBox;