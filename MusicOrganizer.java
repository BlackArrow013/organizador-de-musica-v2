import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Se imprimir� por pantalla la lista de todos los archivos almacenados.
     */
    public void listAllFiles()
    {
        int contador = 1;
        for(String file: files) {
            System.out.println(contador + ". " + file);
            contador++;
        }
    }

    /**
     * Busca una lista de archivos que contengan un elemento concreto en su nombre. Si no hay caracteres coincidentes, se imprimir� por pantalla un mensaje de error.
     */
    public void listMatching(String searchString)
    {
        boolean hayCoincidencia = false;
        for(String filename : files) {
            if(filename.contains(searchString)) {
                // Una coincidencia
                System.out.println(filename);
                hayCoincidencia = true;
            }
            else if (!hayCoincidencia) {
                System.out.println("No hay archivos coincidentes con lo introducido.");
            }
        }
    }
    
    /**
     * Reproducir� fragmentos de todas las canciones del autor seleccionado por par�metro.
     */
    public void artistMusic(String artist)
    {
        boolean hayCoincidencia = false;
        for(String file : files) {
            if(file.contains(artist)) {
                // Una coincidencia
                player.playSample(file);
            }
            else if (!hayCoincidencia) {
                System.out.println("No hay archivos coincidentes con lo introducido.");
            }
        }
    }
    
    /**
     * Localizar el �ndice del primer archivo que se corresponde con
     * la cadena de b�squeda indicada.
     * @param searchString La cadena que hay que buscar.
     * @return El �ndice de la primera aparici�n, es decir, -1 si
     * no se encuentra ninguna correspondencia.
     */
    public int findFirst(String searchString)
    {
        int index = 0;
        int aDevolver = 0;
        int numeroArchivos = files.size();
        // Indicar que vamos a seguir buscando hasta encontrar una correspondencia.
        boolean searching = true;
        while (searching && index < numeroArchivos) {
            String filename = files.get(index);
            if(filename.contains(searchString)) {
                // Una correspondencia. Podemos dejar de buscar.
                searching = false;
            }
            else {
                // Pasar al siguiente elemento.
                index++;
            }
            if (searching) {
                //No la hemos encontrado.
                aDevolver = -1;
            }
            else {
                // Devolver la ubicaci�n donde la hayamos encontrado.
                aDevolver = index;
            }            
        }
        return aDevolver;
    }
}
