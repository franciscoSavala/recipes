import react, {useEffect, useState} from 'react';
import RecipeList from "../components/recipe-list/RecipeList";

const Home = ({ searchText }) => {
    const API_URL = 'http://localhost:8080';
    const [recipes, setRecipes] = useState([]);
    useEffect(() => {
        const queryParams = { q: searchText };
        const queryString = new URLSearchParams(queryParams).toString();
        const urlConParametros = API_URL + '/recipes?' + queryString;
        fetch(urlConParametros)
            .then(response => response.json())
            .then(data => setRecipes(data));
    }, [searchText]);

    return (
        <div>
            <RecipeList recipes={recipes}/>
        </div>
    );
}

export default Home;