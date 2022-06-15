package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {
    private static char WHITE_PIXEL;
    private static char BLACK_PIXEL;
    private static BufferedImage image;

    private static void checkArgs(String[] args) {
        if (args.length == 3) {
            WHITE_PIXEL = args[1].charAt(0);
            BLACK_PIXEL = args[2].charAt(0);
            image = null;
            try {
                image = ImageIO.read(new File(args[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        checkArgs(args);
        new Logic(WHITE_PIXEL, BLACK_PIXEL).printImage(image);
    }
}
