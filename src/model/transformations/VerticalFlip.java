package model.transformations;

import java.awt.Point;
import model.Image;
import model.RGBPixel;

public class VerticalFlip extends Flip {

  private Image image;

  /**
   * Constructs a new horizontal flip transformation with the given image.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public VerticalFlip(Image image) throws IllegalArgumentException {
    super(image);
    this.image = image;
  }

  @Override
  protected RGBPixel flipPixel(RGBPixel pixel) {
    Point position = pixel.getPosition();
    int x = position.x;
    int y = this.height - position.y - 1;
    Point newPosition = new Point(x, y);
    return new RGBPixel(newPosition, pixel.getColor());
  }

  @Override
  protected void updateImage(RGBPixel[][] pixels) {
    this.image.update(pixels, "Flip vertically");
  }

}
