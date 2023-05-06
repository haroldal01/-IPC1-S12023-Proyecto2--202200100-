package ClasesEditoras;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import proyecto2.ImageHandler;

public class JPEGtoBMPImage extends ImageHandler{
    
    private BufferedImage nu; 

    public JPEGtoBMPImage(String filename) {
        super(filename);
    }
    
    

    @Override
    public void readFile() throws Exception {
        System.out.println("imagen leída " + this.handledFileName);
        
        File file = new File(this.handledFileName); 
        
        nu = ImageIO.read(file); 
    }

    @Override
    public void generateFiles() throws Exception {
       if(this.handledFileName.endsWith(".jpg")){
           
           int indexBarra = this.handledFileName.lastIndexOf("//");
           
           int indexPunto = this.handledFileName.lastIndexOf(".");
           
           String nuevoNombre = this.handledFileName.substring(indexBarra,indexPunto) + ".bmp"; 
           
           File nuevoArchivo = new File("./Temporal/" + nuevoNombre);
           
           new File(nuevoArchivo.getParent()).mkdirs(); 
           
           ImageIO.write(nu, "bmp", nuevoArchivo); 
       }else{
           int indexBarra = this.handledFileName.lastIndexOf("\\"); 
           int indexPunto = this.handledFileName.lastIndexOf("."); 
           
           String nuevoNombre =  this.handledFileName.substring(indexBarra, indexPunto)+ ".jpg"; 
           
           File nuevoArchivo = new File("/Temporal/" + nuevoNombre); 
           
           new File(nuevoArchivo.getParent()).mkdirs();
           
           ImageIO.write(nu, "jpg", nuevoArchivo); 
       }
    }

    
}
