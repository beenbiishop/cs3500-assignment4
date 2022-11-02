package model.transformations;

import model.Image;
import model.ImageTransformationMacro;
import model.RGBPixel;

/**
 * Represents a macro that transforms an {@link Image} to visualize its intensity component.
 *
 * <p>This transformation transforms the given image's pixels by setting each pixel's red, blue,
 * and green values to the average of its three previous values. This inherently transforms the
 * image into a grayscale image, and the brightness (value) of each pixel in the transformed image
 * represents this average.</p>
 */
public class VisualizeIntensity extends ImageTransformationMacro {

  /**
   * Constructs a new image transformation macro that visualizes the intensity component of each
   * pixel.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public VisualizeIntensity(Image image) throws IllegalArgumentException {
    super(image);
  }

  @Override
  protected RGBPixel changePixel(RGBPixel pixel, int xPosition, int yPosition) {
    int avg = (pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3;
    return new RGBPixel(avg, avg, avg, pixel.getMaxValue());
  }

  @Override
  protected String changeMessage() {
    return "Visualize intensity component";
  }
}
