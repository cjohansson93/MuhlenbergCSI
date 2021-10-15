import java.util.LinkedList;

public class Mound {

    // Private variables of nutrition in that mound and spores.
    private int nutrientRemaining;
    private int sporesInMound;

    // LinkedList made from the Mushroom.java "Node" class.
    private final LinkedList <Mushroom> shrooms;

    // Mound object constructor.
    public Mound(int nutrientRemaining) {
        this.nutrientRemaining = nutrientRemaining;
        this.sporesInMound = 0;
        this.shrooms = new LinkedList<>();
    }

    /**
     * Expends life for each mushroom, if no life left, mushroom is removed.
     *
     * @return Returns number of new spores based on how many mushrooms were removed.
     */
    public int expendLife() {

        // Holds spores created from every mushroom that is removed/dies.
        int spores = 0;
        int currentLength = shrooms.size();

        // Made this loop go from back to front as going forward produced an error since
        // the LinkedList gets smaller as mushrooms die/removed, and i got bigger.
        for ( int i = currentLength - 1; i >= 0; i--) {
            shrooms.get(i).expendLife();

            // Add a spore for every mushroom that has no life left and is removed.
            if (shrooms.get(i).getDaysRemaining() <= 0) {
                shrooms.remove(i);
                spores+= 1;

            }
        }
        return spores;
    }

    /**
     *  Adds a spore to the mound's spore count.
     *
     * @param spores Number of spores to add to mound.
     */
    public void addSpores(int spores) {
        sporesInMound = sporesInMound + spores;
    }

    /**
     * If spores and nutrients available, remove one of each and add a mushroom.
     *
     * @param lifespan Lifespan of the new mushroom(s).
     */
    public void sporeIntoMushroom(int lifespan) {

        // As long as there are spores and nutrition to support them, remove one of each
        // and make a single mushroom for each pair.
        while (nutrientRemaining > 0 && sporesInMound > 0){
            sporesInMound -= 1;
            nutrientRemaining -= 1;
            shrooms.add( new Mushroom(lifespan));
        }
    }

    /**
     *  Method to retrieve the size of the Mushroom LinkedList, which acts as a count for mushrooms in a mound.
     *
     * @return size of the Mushroom LinkedList, which acts as a count for mushrooms in a mound.
     */
    public int getMushroomCount() {
        return shrooms.size();
    }

    /**
     * Method to retrieve nutrient count in a given mound.
     *
     * @return The nutrients in a given mound.
     */
     public int getNutrientRemaining() {
         return nutrientRemaining;
     }
}
