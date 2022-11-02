package model.transformations;

import model.Image;
import model.ImageTransformationMacro;
import model.RGBPixel;

/**
 * Represents a macro that transforms an {@link Image} to visualize its red component.
 *
 * <p>This transformation transforms the given image's pixels by setting each pixel's blue and
 * green values to the same as the red value. This inherently transforms the image into a grayscale
 * image, and the brightness (value) of each pixel in the transformed image represents how much red
 * was in that pixel in the original image.</p>
 */
public class VisualizeR extends ImageTransformationMacro {

  /**
   * Constructs a new image transformation macro that visualizes the red component of each pixel.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public VisualizeR(Image image) throws IllegalArgumentException {
    super(image);
  }

  @Override
  protected RGBPixel changePixel(RGBPixel pixel, int xPosition, int yPosition) {
    int red = pixel.getRed();
    return new RGBPixel(red, red, red, pixel.getMaxValue());
  }

  @Override
  protected String changeMessage() {
    return "Visualize red component";
  }
}
