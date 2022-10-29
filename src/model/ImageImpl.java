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

  /**
   * Constructs a new image with the given list of pixels.
   *
   * @param pixels the pixels of the image
   */
  public ImageImpl(List<Pixel> pixels) {
    // TODO: We might need to check if there is a pixel in every slot when constructing the image
    if (pixels == null || pixels.isEmpty()) {
      throw new IllegalArgumentException("Pixels cannot be null");
    }
    this.revisions = new Stack<>();
    this.revisions.push(new ImageStateImpl(pixels, "Initial image"));
  }

  @Override
  public ArrayList<Pixel> getPixels() {
    return new ArrayList<Pixel>(this.state().getPixels());
  }

}
