package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the {@link ImageState} interface.
 */
public class ImageStateImpl implements ImageState {

  private final List<Pixel> pixels;
  private final String logMessage;

  /**
   * Constructs a new image state with the given list of pixels and log message.
   *
   * @param pixels  the pixels of the image state
   * @param changes the changes of the image state
   * @throws IllegalArgumentException if the pixels or changes are null or empty
   */
  public ImageStateImpl(List<Pixel> pixels, String changes) {
    if (pixels == null || pixels.isEmpty()) {
      throw new IllegalArgumentException("Pixels cannot be null");
    }
    if (changes == null || changes.length() == 0) {
      throw new IllegalArgumentException("Changes cannot be null or empty");
    }
    this.pixels = pixels;
    this.logMessage = changes;
  }

  @Override
  public List<Pixel> getPixels() {
    return new ArrayList<>(this.pixels);
  }

  @Override
  public String getLogMessage() {
    return this.logMessage;
  }
}
