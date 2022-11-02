package model.transformations;

import java.awt.Color;
import model.Image;
import model.ImageTransformationMacro;
import model.RGBPixel;

/**
 * Represents a macro that transforms an {@link Image} to visualize its blue component.
 *
 * <p>This transformation transforms the given image's pixels by setting each pixel's red and
 * green values to the same as the blue value. This inherently transforms the image into a grayscale
 * image, and the brightness (value) of each pixel in the transformed image represents how much blue
 * was in that pixel in the original image.</p>
 */
public class VisualizeB extends ImageTransformationMacro {

  /**
   * Constructs a new image transformation macro that visualizes the blue component of each pixel.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public VisualizeB(Image image) throws IllegalArgumentException {
    super(image);
  }

  @Override
  protected Color changePixel(RGBPixel pixel, int width, int height) {
    int blue = pixel.getBlue();
    return new Color(blue, blue, blue);
  }

  @Override
  protected String changeMessage() {
    return "Visualize blue component";
  }
}