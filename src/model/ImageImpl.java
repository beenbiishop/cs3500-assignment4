package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * Implements the {@link Image} interface.
 */
public class ImageImpl implements Image {

  private final ImageStateImpl state;
  private final String logMessage;
  private final Stack<Map<ImageStateImpl, String>> revisions;


  public ImageImpl(ImageStateImpl state) {
    if (state == null) {
      throw new IllegalArgumentException("ImageStateImpl cannot be null");
    }
    this.state = state;
    this.revisions = new Stack<>();
    this.save("Original image");
  }

  private void save(String logMessage) {
    Map<ImageStateImpl, String> revision = new HashMap<>();
    revision.put(this.state, logMessage);
    this.revisions.push(revision);
  }

  /**
   * Gets the pixels of the Image.
   *
   * @return a copy of the pixels.
   */
  @Override
  public ArrayList<Pixel> getPixels() {
    return new ArrayList<Pixel>(this.state.getPixels());
  }

}
