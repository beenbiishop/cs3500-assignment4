package model.transformations;

import java.awt.Point;
import model.Image;
import model.RGBPixel;

public class HorizontalFlip extends Flip {

  private Image image;

  /**
   * Constructs a new horizontal flip transformation with the given image.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public HorizontalFlip(Image image) throws IllegalArgumentException {
    super(image);
    this.image = image;
  }

  @Override
  protected RGBPixel flipPixel(RGBPixel pixel) {
    Point position = pixel.getPosition();
    int x = this.width - position.x - 1;
    int y = position.y;
    Point newPosition = new Point(x, y);
    return new RGBPixel(newPosition, pixel.getColor());
  }

  @Override
  protected void updateImage(RGBPixel[][] pixels) {
    this.image.update(pixels, "Flip horizontally");
  }

}
