
package ClasesEditoras;

import java.awt.image.BufferedImage;
import proyecto2.BmpHandlerCopy;
import proyecto2.ImageHandler;


public class JPEGImageCopy extends ImageHandler{
    
    private BufferedImage nu; 

    public JPEGImageCopy(String filename) {
        super(filename);
    }

    @Override
    public void readFile() throws Exception {
        System.out.println("Imagen laída "+ this.handledFileName);
        
        BmpHandlerCopy bmpHandlerCopy = new BmpHandlerCopy(this.handledFileName); 
        
        bmpHandlerCopy.readFile();
        
        bmpHandlerCopy.generateFiles();
        
    }

    @Override
    public void generateFiles() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
 