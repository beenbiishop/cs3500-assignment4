package model.transformations;

import java.awt.Color;
import model.Image;
import model.ImageTransformationMacro;
import model.Pixel;

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
  protected Pixel changePixel(Pixel pixel) {
    int posx = pixel.getPosition().x;
    int posy = pixel.getPosition().y;
    int blue = pixel.getBlue();
    return new Pixel(posx, posy, blue, blue, blue);
  }

  @Override
  protected String changeMessage() {
    return "Visualize blue component";
  }
}
