package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the state of an image.
 *
 * <p>This includes the images pixels, as well as a log what change was made to the last image
 * state to make this image.</p>
 */
public interface ImageState {

  /**
   * Returns the {@link Pixel}s of this image state.
   *
   * @return the pixels as an {@link ArrayList}
   */
  List<Pixel> getPixels();

  /**
   * Returns the log message of this image state.
   *
   * @return the log message as a string
   */
  String getLogMessage();
}
