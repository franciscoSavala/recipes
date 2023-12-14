import react, {useState} from 'react';
import RecipeListItem from '../recipe-list-item/RecipeListItem';
const RecipeList = ({recipes}) => {
    return(
        <div>
            {recipes.map((recipe, index) => {
                return <RecipeListItem recipe={recipe} key={`recipe-list-item-${index}`} />
            })}
        </div>
    );
}
export default RecipeList;