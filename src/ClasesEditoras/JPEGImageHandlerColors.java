
package ClasesEditoras;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import proyecto2.ImageHandler;


public class JPEGImageHandlerColors extends ImageHandler{
    
     private BufferedImage nu; 

    public JPEGImageHandlerColors(String filename) {
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
        
        BufferedImage copiaRoja = new BufferedImage(nu.getWidth(), nu.getHeight(), BufferedImage.TYPE_INT_RGB); 
        
        BufferedImage copiaVerde = new BufferedImage(nu.getWidth(), nu.getHeight(), BufferedImage.TYPE_INT_RGB); 
        
        BufferedImage copiaAzul = new BufferedImage(nu.getWidth(), nu.getHeight(), BufferedImage.TYPE_INT_RGB); 
        
        BufferedImage copiaSepia = new BufferedImage(nu.getWidth(), nu.getHeight(), BufferedImage.TYPE_INT_RGB); 
        
       for(int i = 0;i<nu.getWidth();i++){
           for(int j = 0;j<nu.getHeight();j++){
               int pixel = nu.getRGB(i, j);
               Color color = new Color(pixel);
               int red = color.getRed(); 
               int green = color.getGreen(); 
               int blue = color.getBlue();
               int alpha = color.getAlpha(); 
               
               Color colorRojo = new Color(red,0,0,alpha); 
               
               Color colorVerde = new Color(0,green,0,alpha); 
               
               Color colorAzul = new Color(0,0,blue,alpha); 
               
               int nuevoRojo = (int) (red * 0.393 + green * 0.769 + blue * 0.109);
               
               int nuevoVerde = (int) (red * 0.349 + green * 0.686 + blue * 0.168);
               
               int nuevoAzul = (int) (red * 0.272 + green * 0.534 + blue * 0.131);
               
               
               if(nuevoRojo > 255){
                   nuevoRojo = 255; 
               }
               
               if(nuevoVerde>255){
                   nuevoVerde=255;
               }
               
               if(nuevoAzul>255){
                   nuevoAzul=255; 
               }
               
               Color colorSepia = new Color(nuevoRojo,nuevoVerde,nuevoAzul,alpha); 
               
               copiaRoja.setRGB(i, j, colorRojo.getRGB());
               copiaAzul.setRGB(i, j, colorAzul.getRGB());
               copiaVerde.setRGB(i, j, colorVerde.getRGB());
               copiaSepia.setRGB(i,j,colorSepia.getRGB()); 
               
               
           }
       }
       
       int indexBarra = this.handledFileName.lastIndexOf("\\");
       int indexPunto = this.handledFileName.lastIndexOf("."); 
       
       //rojo
       String nombreRojo = this.handledFileName.substring(indexBarra,indexPunto) + "Rojo.bmp"; 
       File nuevoArchivoRojo = new File("./Temporal/" + nombreRojo); 
       ImageIO.write(copiaRoja, "bmp", nuevoArchivoRojo); 
       
       
       //verde
       String nombreVerde = this.handledFileName.substring(indexBarra,indexPunto) + "Verde.bmp"; 
       File nuevoArchivoVerde = new File("./Temporal/" + nombreVerde); 
       ImageIO.write(copiaVerde, "bmp", nuevoArchivoVerde); 
       
       //azul
       String nombreAzul = this.handledFileName.substring(indexBarra,indexPunto) + "Azul.bmp"; 
       File nuevoArchivoAzul = new File("./Temporal/" + nombreAzul); 
       ImageIO.write(copiaAzul, "bmp", nuevoArchivoAzul); 
       
       //Sepia
       String nombreSepia = this.handledFileName.substring(indexBarra,indexPunto) + "Sepia.bmp"; 
       File nuevoArchivoSepia = new File("./Temporal/" + nombreSepia); 
       ImageIO.write(copiaSepia, "bmp", nuevoArchivoSepia); 
    }
    
}
