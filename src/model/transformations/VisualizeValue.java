package model.transformations;

import java.awt.Color;
import model.Image;
import model.ImageTransformationMacro;
import model.Pixel;

/**
 * Represents a macro that transforms an {@link Image} to visualize its value component.
 *
 * <p>This transformation transforms the given image's pixels by setting each pixel's red, blue,
 * and green values to the maximum of its three previous values. This inherently transforms the
 * image into a grayscale image, and the brightness (value) of each pixel in the transformed image
 * represents this maximum.</p>
 */
public class VisualizeValue extends ImageTransformationMacro {

  /**
   * Constructs a new image transformation macro that visualizes the value component of each pixel.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public VisualizeValue(Image image) throws IllegalArgumentException {
    super(image);
  }


  @Override
  protected Pixel changePixel(Pixel pixel) {
    int posx = pixel.getPosition().x;
    int posy = pixel.getPosition().y;
    int max = Math.max(pixel.getRed(), Math.max(pixel.getBlue(), pixel.getGreen()));
    return new Pixel(posx, posy, max, max, max);
  }

  @Override
  protected String changeMessage() {
    return "Visualize value component";
  }
}
