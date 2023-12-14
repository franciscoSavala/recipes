import './App.css';
import Header from "./components/header/Header";
import Home from "./containers/Home";
import {useState} from "react";
function App() {
    const [search, setSearch] = useState("");
    const handleInput = (e) => {
        setSearch(e.target.value);
    }
    return (
    <div className="App">
      <Header handleInput={handleInput}/>
      <Home searchText={search}/>
    </div>
  );
}

export default App;
