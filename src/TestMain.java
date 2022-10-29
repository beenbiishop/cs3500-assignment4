import java.awt.Color;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Image;
import model.Image.ColorChannel;
import model.ImageImpl;
import model.Pixel;

/**
 * A class to test the Image interface.
 */
public class TestMain {

  // TODO: delete this method

  public static Image readPPM(String filename) {
    Scanner sc;
    List<Pixel> pixels = new ArrayList<>();

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File " + filename + " not found!");
    }
    StringBuilder builder = new StringBuilder();

    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;
    token = sc.next();

    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }

    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();

    // Iterate through and create pixels for each color
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        Point p = new Point(j, i);
        Color c = new Color(r, g, b);
        Pixel pixel = new Pixel(p, c);
        pixels.add(pixel);
      }
    }

    // Create the image
    return new ImageImpl(pixels);

  }

  /**
   * A main method to test the program.
   *
   * @param args
   */
  public static void main(String[] args) {
    Image image = readPPM("res/provided/Koala.ppm");
    image.visualize(ColorChannel.RED);

    for (Pixel p : image.getPixels()) {
      Point position = p.getPosition();
      Color color = p.getColor();
      System.out.println("Position: (" + position.getX() + ", " + position.getY() + ") Color: rgb("
          + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")");
    }
  }


}
