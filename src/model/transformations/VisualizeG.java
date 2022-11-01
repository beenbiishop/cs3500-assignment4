package model.transformations;

import java.awt.Color;
import model.Image;
import model.ImageTransformationMacro;

/**
 * Represents a macro that transforms an {@link Image} to visualize its green component.
 *
 * <p>This transformation transforms the given image's pixels by setting each pixel's red and
 * blue values to the same as the green value. This inherently transforms the image into a grayscale
 * image, and the brightness (value) of each pixel in the transformed image represents how much
 * green was in that pixel in the original image.</p>
 */
public class VisualizeG extends ImageTransformationMacro {

  /**
   * Constructs a new image transformation macro that visualizes the red component of each pixel.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public VisualizeG(Image image) throws IllegalArgumentException {
    super(image);
  }

  @Override
  protected Color changePixel(Color pixel, int width, int height) {
    int green = pixel.getGreen();
    return new Color(green, green, green);
  }

  @Override
  protected String changeMessage() {
    return "Visualize green component";
  }
}
