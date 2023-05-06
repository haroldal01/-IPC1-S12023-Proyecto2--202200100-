
package datos;

import ClasesEditoras.JPEGImageCopy;
import ClasesEditoras.JPEGImageHandlerColors;
import ClasesEditoras.JPEGImageHandlerRotator;
import proyecto2.ImageHandler;
import proyecto2.JPEGHandler;

public class Tareas implements Runnable {

    
    private ImageHandler imageHandler; 
    
    public Tareas(String pathImagen,TipoTarea tarea){
        System.out.println("creando tarea");
        
        switch(tarea){
            case MODIFICAR:
                imageHandler = new JPEGImageHandlerRotator(pathImagen); 
                break; 
                
            case COPIA_JPEG: 
                imageHandler = new JPEGImageCopy(pathImagen);
                break; 
                
            case RVAS:
                imageHandler = new JPEGImageHandlerColors(pathImagen);
                break; 
        }    
    }
    
    
    
    @Override
    public void run() {
        System.out.println("ejecutando tarea");
        try{
            JPEGHandler.runHandler(imageHandler);
        } catch (Exception e) {
            throw new RuntimeException(e); 
        }
    }
    
}
