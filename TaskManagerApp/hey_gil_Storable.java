package TaskManagerApp;

import java.io.IOException;

public interface hey_gil_Storable {
    // Saves the current state to a file
    void saveToFile(String filename) throws IOException;

    // Loads the saved state from a file
    void loadFromFile(String filename) throws IOException;
}


