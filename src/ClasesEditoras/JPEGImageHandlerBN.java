package ClasesEditoras; 

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import proyecto2.ImageHandler;

public class JPEGImageHandlerBN extends ImageHandler {
    private BufferedImage nu;

    public JPEGImageHandlerBN(String filename) {
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
        BufferedImage grayImage = new BufferedImage(nu.getWidth(), nu.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        for (int i = 0; i < nu.getWidth(); i++) {
            for (int j = 0; j < nu.getHeight(); j++) {
                int pixel = nu.getRGB(i, j);
                Color color = new Color(pixel);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int gray = (int) (red * 0.299 + green * 0.587 + blue * 0.114);
                Color grayColor = new Color(gray, gray, gray);

                grayImage.setRGB(i, j, grayColor.getRGB());
            }
        }

        int indexBarra = this.handledFileName.lastIndexOf("\\");
        int indexPunto = this.handledFileName.lastIndexOf(".");

        String nombreBN = this.handledFileName.substring(indexBarra, indexPunto) + "BN.bmp";
        File nuevoArchivoBN = new File("./Temporal/" + nombreBN);
        ImageIO.write(grayImage, "bmp", nuevoArchivoBN);
    }

}
