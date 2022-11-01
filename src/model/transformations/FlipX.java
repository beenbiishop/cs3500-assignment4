package model.transformations;

import java.awt.Point;
import java.util.ArrayList;
import model.Image;

public class FlipX extends Flip {

  /**
   * Constructs a new horizontal flip transformation with the given image.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public FlipX(Image image) throws IllegalArgumentException {
    super(image);
  }

  @Override
  protected Pixel flipPixel(Pixel pixel) {
    Point position = pixel.getPosition();
    int x = this.width - position.x - 1;
    int y = position.y;
    Point newPosition = new Point(x, y);
    return new Pixel(newPosition, pixel.getColor());
  }

  @Override
  protected void updateImage(ArrayList<Pixel> pixels) {
    this.image.update(pixels, "Flip horizontally");
  }

}
