package view;

import java.io.IOException;

/**
 * This interface represents the view of the Image Processor. It contains methods that the
 * controller can call to render the view.
 */
public interface ImageProcessorView {

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  void renderMessage(String message) throws IOException;

}
