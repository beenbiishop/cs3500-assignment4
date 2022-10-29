package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Implements the {@link Image} interface.
 */
public class ImageImpl implements Image {

  private final Stack<ImageState> revisions;

  public ImageImpl(ImageStateImpl state) {
    if (state == null) {
      throw new IllegalArgumentException("ImageStateImpl cannot be null");
    }
    this.revisions = new Stack<>();
    this.revisions.push(new ImageStateImpl(pixels, "Initial image"));
  }

  /**
   * Returns the most recent state of the image.
   *
   * @return the current state of the image
   */
  private ImageState state() {
    return this.revisions.peek();
  }

  @Override
  public ArrayList<Pixel> getPixels() {
    return new ArrayList<Pixel>(this.state().getPixels());
  }

}
