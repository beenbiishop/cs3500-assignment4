package model.transformations;

import java.awt.Color;
import model.Image;
import model.ImageTransformationMacro;
import model.Pixel;

/**
 * Represents a macro that transforms an {@link Image} to visualize its luma component.
 *
 * <p>This transformation transforms the given image's pixels by setting each pixel's red, blue,
 * and green values to the weighted sum of (0.2126 * original red), (0.7152 * original blue), and
 * (0.0722 * original blue) . This inherently transforms the image into a grayscale image, and the
 * brightness (value) of each pixel in the transformed image represents this weighted sum.</p>
 */
public class VisualizeLuma extends ImageTransformationMacro {

  /**
   * Constructs a new image transformation macro that visualizes the luma component of each pixel.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public VisualizeLuma(Image image) throws IllegalArgumentException {
    super(image);
  }

  @Override
  protected Pixel changePixel(Pixel pixel) {
    int posx = pixel.getPosition().x;
    int posy = pixel.getPosition().y;
    int luma = (int) (0.2126 * pixel.getRed() + 0.7152 * pixel.getGreen()
        + 0.0722 * pixel.getBlue());
    return new Pixel(posx, posy, luma, luma, luma);
  }

  @Override
  protected String changeMessage() {
    return "Visualize luma component";
  }
}
