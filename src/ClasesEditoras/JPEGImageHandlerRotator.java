package ClasesEditoras;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import proyecto2.ImageHandler;

public class JPEGImageHandlerRotator extends ImageHandler{

    private BufferedImage nu; 

    public JPEGImageHandlerRotator(String filename) {
        
        super(filename);     
    }

    @Override
    public void readFile() throws Exception {  
     System.out.println("Imagen Leída  "+ this.handledFileName);
     File file = new File(this.handledFileName);
     nu = ImageIO.read(file);      
    }
    


    @Override
    public void generateFiles() throws Exception {
      BufferedImage copiaX = new BufferedImage(nu.getWidth(), nu.getHeight(), BufferedImage.TYPE_INT_RGB); 
      BufferedImage copiaY = new BufferedImage(nu.getWidth(), nu.getHeight(), BufferedImage.TYPE_INT_RGB); 
      
      
      for(int i =0 ;i<nu.getWidth();i++){
          for(int j=0;j<nu.getHeight();j++){
              int pixel  = nu.getRGB(i, j); 
              int nuevaX = (int) (nu.getWidth()-1-i); 
              int nuevaY = (int) (nu.getHeight()-1-j); 
              copiaX.setRGB(nuevaX,j, nu.getRGB(i, j));
              copiaY.setRGB(i, nuevaY, nu.getRGB(i, j));
            }
        }
      
      int indexBarra = this.handledFileName.lastIndexOf("\\");
      int indexPunto = this.handledFileName.lastIndexOf(".");
      
       String rotadoX = this.handledFileName.substring(indexBarra,indexPunto) + "rotadoX.bmp"; 
       File nuevoArchivorotadoX = new File("./Temporal/" + rotadoX); 
       ImageIO.write(copiaX, "bmp", nuevoArchivorotadoX);
       
       String rotadoY = this.handledFileName.substring(indexBarra,indexPunto) + "rotadoY.bmp"; 
       File nuevoArchivorotadoY = new File("./Temporal/" + rotadoY); 
       ImageIO.write(copiaY, "bmp", nuevoArchivorotadoY); 
    }
    
}
