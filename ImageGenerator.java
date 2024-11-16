import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageGenerator {

    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("Usage: java ImageGenerator <width> <height> <red> <green> <blue>");
            return;
        }

        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int red = Integer.parseInt(args[2]);
        int green = Integer.parseInt(args[3]);
        int blue = Integer.parseInt(args[4]);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        Color color = new Color(red, green, blue);
        graphics.setColor(color);
        graphics.fillRect(0, 0, width, height);

        File outputFile = new File("random_image.png");
        try {
            ImageIO.write(image, "png", outputFile);
            System.out.println("Image saved as random_image.png");
        } catch (IOException e) {
            System.err.println("Error saving the image: " + e.getMessage());
        }

        graphics.dispose();
    }
}
