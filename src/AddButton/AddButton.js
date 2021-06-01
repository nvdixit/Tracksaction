import "./AddButton.css"

function AddButton(props) {
    return (
        <button id="AddButton">
            {props.name}
        </button>
    )    
}

export default AddButton;