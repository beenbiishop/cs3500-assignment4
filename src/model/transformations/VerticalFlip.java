package model.transformations;

import java.awt.*;

import model.Image;
import model.Pixel;

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
  protected Pixel flipPixel(Pixel pixel) {
    Point position = pixel.getPosition();
    int x = position.x;
    int y = this.height - position.y - 1;
    Point newPosition = new Point(x, y);
    return new Pixel(newPosition, pixel.getColor());
  }

  @Override
  protected void updateImage(Pixel[][] pixels) {
    this.image.update(pixels, "Flip vertically");
  }

}
