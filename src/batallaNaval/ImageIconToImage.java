package batallaNaval;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageIconToImage {

    /**
     * Constructor of ImageIconToImage class
     */

    public ImageIconToImage(){

    }

    /**
     * This function converts an ImageIcon to Image
     * @param imagen
     * @param largo
     * @param altura
     * @return image
     */

    public Image scaledImage(Image imagen, int largo, int altura){
        BufferedImage resizedImage = new BufferedImage(largo,altura,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(imagen, 0,0,largo,altura,null);
        g2.dispose();
        return resizedImage;
    }



}
