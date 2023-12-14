import react from 'react';

const RecipeListItem = ({ recipe }) => {
  return (
    <div>
      <h2>{recipe.name}</h2>
      <p>{recipe.description}</p>
    </div>
  );
}

export default RecipeListItem;