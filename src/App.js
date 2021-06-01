import ContentBox from "./ContentBox/ContentBox"

function App() {
  return (
      <div>
          <ContentBox name="Credit Cards" btnName="Add Credit Card" items={["American Express", "Visa", "Chase"]}/>
          <ContentBox name="Transactions" btnName="Add Transaction" items={["Groceries", "Gas", "Rent"]}/>
      </div>
  );
}

export default App;