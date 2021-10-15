import java.io.FileNotFoundException;

public class MushroomFarmer {
    public static void main(String[] args) throws FileNotFoundException {

        // Create field object
        Field field = new Field();

        // if filename is provided as an argument it gets passed to field setup
        // otherwise it'll enter setupField with null and there inside it will ask for file name.
        if (args.length == 1) {
            // Start setup with argument
            field.setupField(args[0]);
        }
        else {
            // Start setup without argument
            field.setupField(null);
        }

        // Start simulation of farm
        field.farmSimulation();
        // Summarize the simulation results
        field.summarizeSimulation();

    }
}
